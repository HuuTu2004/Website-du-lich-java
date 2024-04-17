package product.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import product.dao.CategoryDAO;
import product.dao.OrderDetailDAO;
import product.dao.TourDAO;
import product.dao.UserDAO;
import product.entites.Category;
import product.entites.CustomUserDetails;
import product.entites.OrderDetail;
import product.entites.Role;
import product.entites.Tour;
import product.entites.User;
import product.entites.User_Role;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CategoryDAO catDao;
	@Autowired
	TourDAO tourDao;
	@Autowired
	UserDAO userDAO;
	@Autowired
	OrderDetailDAO orderDetailDAO;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}

	@RequestMapping("/home")
	public String adminPage(Model model, HttpSession session) {
		model.addAttribute("mess", "Welcome to admin page");
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		session.setAttribute("user", user);
		return "adminHome";
	}

	@RequestMapping("/listCategory")
	public String listCate(Model model, HttpSession session) {
		List<Category> list = catDao.getAllCategories();
		model.addAttribute("list", list);
		return "listCategory";
	}

	@RequestMapping("/insertCategory")
	public String insertCate(Model model) {
		Category p = new Category();
		model.addAttribute("p", p);
		return "insertCategory";
	}

	@RequestMapping("insert")
	public String insert(@Valid @ModelAttribute("p") Category p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("p", p);
			return "insertCategory";
		} else {
			boolean bl = catDao.insert(p);
			if (bl) {
				return "redirect:/admin/listCategory";
			} else {
				model.addAttribute("p", p);
				model.addAttribute("err", "insert failed!");
				return "insertCategory";
			}
		}

	}

	@RequestMapping("/scc")
	public String scc(Model model, HttpSession session) {
		List<Category> list = catDao.getAllCategories();
		model.addAttribute("list", list);
		model.addAttribute("scc", "Delete successFully!");

		return "listCategory";
	}

	@RequestMapping("deleteCategory")
	public String DeleteCategory(@RequestParam("id") Integer id, Model model) {
		List<Tour> cat = tourDao.getToursByCategory(id);
		List<Category> list = catDao.getAllCategories();

		if (cat.isEmpty()) {
			boolean bl = catDao.delete(id);
			if (bl) {

				return "redirect:/admin/scc";
			} else {
				model.addAttribute("list", list);
				model.addAttribute("err", "Delete failed!");
				return "listCategory";
			}
		} else {
			model.addAttribute("list", list);
			model.addAttribute("err", "Delete Lỗi vì đang có Tour !");
			return "listCategory";

		}

	}

	@RequestMapping("viewEdit")
	public String viewEdit(@RequestParam("id") Integer id, Model model) {

		Category p = catDao.findById(id);
		model.addAttribute("p", p);
		return "editCategory";
	}

	@RequestMapping("editCategory")
	public String editCate(@Valid @ModelAttribute("p") Category p, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("p", p);
			return "insertCategory";
		} else {
			System.out.println(p.getId());
			boolean bl = catDao.update(p);
			if (bl) {
				model.addAttribute("uscc", "Update successFully!");
				return "redirect:/admin/listCategory";
			} else {
				model.addAttribute("p", p);
				model.addAttribute("err", "update failed!");
				return "editCategory";
			}
		}

	}

//	Tour

	@RequestMapping("/listProduct")
	public String listProduct(Model model, HttpSession session) {
		List<Tour> list = tourDao.getAllTours();
		model.addAttribute("list", list);
		return "listTour";
	}

	@RequestMapping("/insertProduct")
	public String insertProduct(Model model) {
		Tour t = new Tour();
		List<Category> list = catDao.getAllCategories();
		model.addAttribute("t", t);
		model.addAttribute("cat", list);
		return "insertTour";
	}

	@RequestMapping("/insert-product")
	public String insertProduct(@Valid @ModelAttribute("t") Tour t, BindingResult result,
			@RequestParam("imgUrl") MultipartFile imgFile, HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			List<Category> list = catDao.getAllCategories();
			model.addAttribute("t", t);
			model.addAttribute("cat", list);
			return "insertTour";
		} else {
			String path = request.getServletContext().getRealPath("resources/img");
			File f = new File(path);
			if (imgFile != null) {
				String fileName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
				File dest = new File(f.getAbsoluteFile() + "/" + fileName);
				try {
					Files.write(dest.toPath(), imgFile.getBytes(), StandardOpenOption.CREATE_NEW);
					t.setImage(fileName);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			boolean bl = tourDao.insert(t);
			if (bl) {
				return "redirect:/admin/listProduct";
			} else {
				List<Category> list = catDao.getAllCategories();
				model.addAttribute("cat", list);
				model.addAttribute("t", t);
				model.addAttribute("err", "insert failed!");
				return "insertTour";
			}
		}

	}

	@RequestMapping("deleteProduct")
	public String DeleteProduct(@RequestParam("id") Integer id, Model model) {
		boolean bl = tourDao.delete(id);
		if (bl) {

			return "redirect:/admin/listProduct?scc=Delete success";
		} else {
			List<Category> list = catDao.getAllCategories();
			model.addAttribute("cat", list);
			List<Tour> list1 = tourDao.getAllTours();
			model.addAttribute("list", list1);
			model.addAttribute("err", "Delete failed!");
			return "listTour";
		}

	}
	@RequestMapping("/viewUpdate")
	public String viewUpdate(Model model,@RequestParam("id") Integer id) {
		Tour t = tourDao.findById(id);
		List<Category> list = catDao.getAllCategories();
		model.addAttribute("t", t);
		model.addAttribute("cat", list);
		return "editTour";
	}
	@RequestMapping("/getTourByName")
	public String getTourByName(Model model,@RequestParam("name") String n) {

		List<Tour> list = tourDao.getToursByName(n);
		
		model.addAttribute("list", list);
		return "listTour";
	}
	@RequestMapping("/edit-product")
	public String editProduct(@Valid @ModelAttribute("t") Tour t, BindingResult result,
			@RequestParam("imgUrl") MultipartFile imgFile, HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			List<Category> list = catDao.getAllCategories();
			model.addAttribute("t", t);
			model.addAttribute("cat", list);
			return "editTour";
		} else {
			String path = request.getServletContext().getRealPath("resources/img");
			File f = new File(path);
			if (imgFile != null) {
				String fileName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
				File dest = new File(f.getAbsoluteFile() + "/" + fileName);
				try {
					Files.write(dest.toPath(), imgFile.getBytes(), StandardOpenOption.CREATE_NEW);
					t.setImage(fileName);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			boolean bl = tourDao.update(t);
			if (bl) {
				return "redirect:/admin/listProduct";
			} else {
				List<Category> list = catDao.getAllCategories();
				model.addAttribute("cat", list);
				model.addAttribute("t", t);
				model.addAttribute("err", "update failed!");
				return "editTour";
			}
		}

	}
//	user
	@RequestMapping("/listAccount")
	public String ListUser(Model model) {

		List<User> list = userDAO.findUsersWithoutRole();

		model.addAttribute("list", list);
		return "listUser";
	}
	@RequestMapping("/listAccountNo")
	public String ListUserNo(Model model) {

		List<User> list = userDAO.findUsersWithoutNoRole();

		List<Role> listR = userDAO.ListUserRole();
		User_Role r = new User_Role();
		model.addAttribute("list", list);
		model.addAttribute("r", r);
		model.addAttribute("listR", listR);
		
		return "listUserNo";
	}
	@RequestMapping("/insertUserRole")
	public String insertUserRole(@ModelAttribute("r")User_Role r,Model model) {
		boolean bl = userDAO.InsertUserRole(r);
		if(bl) {
			model.addAttribute("scc", "Xác thực thành công");
			return "redirect:/admin/listAccount";
		}
		model.addAttribute("er", "Xác thực ko thành công");

		return "listUserNo";
	}
//	list order
	@RequestMapping("/listOrderNo")
	public String ListOrder(Model model) {

		List<OrderDetail> list = orderDetailDAO.getAllListOrder(false);

		model.addAttribute("order", list);
		return "listOrderNo";
	}
	@RequestMapping("/listOrder")
	public String ListOrderNo(Model model) {

		List<OrderDetail> list = orderDetailDAO.getAllListOrder(true);

		model.addAttribute("order", list);
		return "listOrder";
	}
	
	@RequestMapping("/confirmOrder")
	public String confirmOrder(@RequestParam("id")Integer id,Model model) {

		OrderDetail list = orderDetailDAO.getOrderDetailById(id);
		list.setStatus(true);
		boolean bl = orderDetailDAO.updateOrderDetail(list);
		if(bl) {
			model.addAttribute("scc", "Xác thực thành công");
			return "redirect:/admin/listOrder";
		}else {
			model.addAttribute("err", "Xác thực Không thành công");
			return "redirect:/admin/listOrderNo";
		}

	}
}
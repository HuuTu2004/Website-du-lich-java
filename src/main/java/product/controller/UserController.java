package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.dao.OrderDetailDAO;
import product.dao.TourDAO;
import product.dao.UserDAO;
import product.entites.OrderDetail;
import product.entites.Tour;
import product.entites.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private TourDAO tourDAO;
	@Autowired
	private OrderDetailDAO detailDAO;
	
	@RequestMapping("")
	public String userPage(Model model) {
		model.addAttribute("mess", "Welcome user page");
		List<Tour> list = tourDAO.getAllTourStatus();
		model.addAttribute("list", list);
		return "home";
	}
	@RequestMapping("/orderDetail")
	public String orderDetail(@RequestParam("id")String userName,Model model) {
		User user = userDao.findByUserName(userName);
		if(user!= null) {
			List<OrderDetail> od = detailDAO.getListOrder(user.getId());
			model.addAttribute("mess", od);
			return "orderDetail";
		}
		return "orderDetail";
		
		
		
	}
	@RequestMapping("/order")
	public String orderDetail(@RequestParam("T")Integer id,@RequestParam("id")String userName,Model model) {
		User user = userDao.findByUserName(userName);
		Tour tour = tourDAO.findById(id);
		OrderDetail detail = new OrderDetail();
		detail.setUser(user);
		detail.setTour(tour);
		if(user!= null) {
			boolean bl = detailDAO.saveOrderDetail(detail);
			if(bl) {
				model.addAttribute("scc","Đặt tour thành công");
				
				return "redirect:/user/orderDetail?id="+userName;
			}
		}
		return "redirect:/";
	}

}
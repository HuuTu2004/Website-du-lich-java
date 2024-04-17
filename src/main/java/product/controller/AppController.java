package product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.dao.TourDAO;
import product.dao.UserDAO;
import product.entites.Tour;
import product.entites.User;

@Controller
public class AppController {
	@Autowired
	private TourDAO tuorDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@RequestMapping(value = {"/login" })
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("mess", "Login failed!");
		}
		return "loginAdmin";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "loginAdmin";
	}
	@RequestMapping("register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	@RequestMapping("insertUser")
	public String insertUser(@Valid @ModelAttribute("user")User user,BindingResult rs,Model model) {
		User getUserName = userDao.findByUserName(user.getUserName());
		if(rs.hasFieldErrors()) {
			model.addAttribute("user", user);
			return "register";
			
		}
		if(getUserName != null) {
			model.addAttribute("err", "Tên tài khoản của bạn bị trùng vui lòng đặt lại");
			model.addAttribute("user", user);
			return "register";
		}
		 String encodedPassword = passwordEncoder.encode(user.getPassWord());
		    user.setPassWord(encodedPassword);
		boolean bl = userDao.InsertUser(user);
		if(bl) {
			
			model.addAttribute("scc", "Đăng Kí Thành Công");
			return "loginAdmin";
		}else {
			model.addAttribute("user",user);
			model.addAttribute("err", "Đăng Ký Thất Bại");
			return "register";
		}
		
	}
	@RequestMapping("/")
	public String home(Model model) {
		List<Tour> list = tuorDao.getAllTourStatus();
		model.addAttribute("list", list);
		return "home";
	}
}

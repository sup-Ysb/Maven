package maven.p01.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import maven.p01.entity.Users;
import maven.p01.repo.UserMsgRepo;

@CrossOrigin
@Controller
public class LoginController implements WebMvcConfigurer {
	
	@Autowired
	private UserMsgRepo umrepo;
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/task").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/home").setViewName("welcome");
    }
	
	@PostMapping("/login")
	public String checkLogin(@Validated Users user, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasFieldErrors()) {
			model.addAttribute("user",user);
			return "login";
		}else
			return "redirect:home";
	}
	
	@PostMapping("/register")
	public String checkRegister(@Validated Users user, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasFieldErrors()) {
			model.addAttribute("user",user);
			return "register";
		}else {
			model.addAttribute("user",user);
			return "redirect:login";
		}
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new Users());
		return "login";
	}
	
	@RequestMapping("/register")
	public String ragister(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}
}

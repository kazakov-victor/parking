package edu.pet.vkazakov.controller;
/*
import edu.pet.entity.User;
import edu.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());

		return "registration.html";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration.html";
		}
		if (!user.getPassword().equals(user.getPasswordConfirm())){
			model.addAttribute("passwordError", "Пароли не совпадают");
			return "registration.html";
		}


		if (!userService.saveUser(user)){
			model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
			return "registration.html";
		}

		return "redirect:/";
	}
}


 */
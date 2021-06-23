
package edu.pet.vkazakov.controller;
/*
import edu.pet.entity.User;
import edu.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/list")
	public List<User> userList() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@PostMapping("/delete")
	public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
							  @RequestParam(required = true, defaultValue = "" ) String action,
							  Model model) {
		if (action.equals("delete")){
			userRepository.deleteUser(userId);
		}
		return "redirect:/admin";
	}

	@GetMapping("/gt/{userId}")
	public User  gtUser(@PathVariable("userId") Long userId) {
		User user = userService.findById(userId);
		return user;
	}
	@GetMapping("/save/")
	public String  saveUser(User user) {
		userService.save(user);
		return "user was saved";
	}
}


*/

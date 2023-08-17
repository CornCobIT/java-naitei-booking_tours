package com.naite.bookingTour.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naite.bookingTour.model.User;
import com.naite.bookingTour.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/profile")
	public String showDashboard(HttpServletRequest request, Model model) {
		// Check if the model contains any flash attributes with the "error" key
		if (model.containsAttribute("error")) {
			// Retrieve the error message and add it to the model for rendering in the login
			// page
			String errorMessage = (String) model.getAttribute("error");
			model.addAttribute("errorMessage", errorMessage);
		}
		// Check if the user is authenticated (session has the username attribute)
		HttpSession session = request.getSession();
		if (session.getAttribute("username") == null) {
			return "redirect:/login"; // Redirect to the login page if not authenticated
		}

		Optional<User> userOptional = userRepository.findByUsername((String) session.getAttribute("username"));
		User user = userOptional.get();
		model.addAttribute("fullname", user.getFullname());
		model.addAttribute("user", user);
		// User is authenticated, show the profile
		return "userProfile";
	}

	@PostMapping("/updateprofile")
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") User updatedUser,
			RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession();
		Object username = session.getAttribute("username");
		if (username == null) {
			return "redirect:/login"; // Redirect to the login page if not authenticated
		}

		User user = userRepository.findByUsername(username.toString()).orElse(null);

		// Update user properties
		user.setFullname(updatedUser.getFullname());
		user.setPhone(updatedUser.getPhone());
		user.setEmail(updatedUser.getEmail());
		user.setAddress(updatedUser.getAddress());
		user.setPassword(updatedUser.getPassword());
		user.setRepeatPassword(updatedUser.getRepeatPassword());

		if (user.isPasswordMatching()) {
			if (user.isPasswordEnoughLength()) {
				// Save the updated user
				userRepository.save(user);
				// Redirect to user details page or another appropriate destination
				return "redirect:/profile";
			}
			redirectAttributes.addFlashAttribute("error", "Password must have 6 or more character!");
			return "redirect:/profile";
		} else {
			redirectAttributes.addFlashAttribute("error", "Password doesn't match!");
			return "redirect:/profile";
		}

	}

}

package com.naite.bookingTour.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naite.bookingTour.model.Booking;
import com.naite.bookingTour.model.Tour;
import com.naite.bookingTour.model.User;
import com.naite.bookingTour.repository.BookingRepository;
import com.naite.bookingTour.repository.UserRepository;
import com.naite.bookingTour.service.TourService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookingController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TourService tourService;

	@GetMapping("/booking/{tourId}")
	public String bookingTour(HttpServletRequest request, Model model, @PathVariable("tourId") Long tourId) {
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
		model.addAttribute("user", user);

		// Retrieve the tour information based on the tour ID
		Tour tour = tourService.findTourById(tourId);
		model.addAttribute("tour", tour);

		// User is authenticated, show the booking page
		return "booking";
	}

}
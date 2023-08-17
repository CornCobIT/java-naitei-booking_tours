package com.naite.bookingTour.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.naite.bookingTour.model.DateTour;
import com.naite.bookingTour.model.Tour;
import com.naite.bookingTour.model.TourDateWrapper;
import com.naite.bookingTour.service.DateTourService;
import com.naite.bookingTour.service.TourService;


@Controller
public class TourController {

    @Autowired
    private TourService tourService;

    @Autowired
    private DateTourService dateTourService;

    @GetMapping("/tour")
    public String showTour(Model model) {
        // Retrieve tour data from the database
        List<Tour> tours = tourService.findAllTours();

        // Create a list to hold the combined tour and date tour data
        List<TourDateWrapper> tourDateWrappers = new ArrayList<>();

        // Iterate over the tours and fetch the corresponding DateTour for each tour
        for (Tour tour : tours) {
            DateTour dateTour = dateTourService.getDateTourByTourId(tour.getId());

            // Create a TourDateWrapper instance and set the tour and date tour objects
            TourDateWrapper tourDateWrapper = new TourDateWrapper();
            tourDateWrapper.setTour(tour);
            tourDateWrapper.setDateTour(dateTour);

            // Add the TourDateWrapper to the list
            tourDateWrappers.add(tourDateWrapper);
        }

        // Add the tour data to the model
        model.addAttribute("tourDateWrappers", tourDateWrappers);

        // Return the name of the HTML view file to render
        return "tourPage";
        
    }

}

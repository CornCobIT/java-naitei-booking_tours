package com.naite.bookingTour.service;

import java.util.List;

import com.naite.bookingTour.model.Tour;


public interface TourService {
	List<Tour> findAllTours();
	Tour findTourById(Long tourId);
}

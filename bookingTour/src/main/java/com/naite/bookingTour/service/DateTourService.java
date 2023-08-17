package com.naite.bookingTour.service;

import java.util.List;

import com.naite.bookingTour.model.DateTour;
import com.naite.bookingTour.model.TourDateWrapper;


public interface DateTourService {
	public DateTour getDateTourByTourId(Long tourId);
}

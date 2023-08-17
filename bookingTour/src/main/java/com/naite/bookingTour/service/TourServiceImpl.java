package com.naite.bookingTour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naite.bookingTour.model.Tour;
import com.naite.bookingTour.repository.TourRepository;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> findAllTours() {
        return tourRepository.findAll();
    }

	@Override
	public Tour findTourById(Long tourId) {
		return tourRepository.findById(tourId).get();
	}


}
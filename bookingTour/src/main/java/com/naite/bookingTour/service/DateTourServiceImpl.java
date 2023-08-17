package com.naite.bookingTour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naite.bookingTour.model.DateTour;
import com.naite.bookingTour.model.TourDateWrapper;
import com.naite.bookingTour.repository.DateTourRepository;

@Service
public class DateTourServiceImpl implements DateTourService {

    @Autowired
    private DateTourRepository dateTourRepository;

    @Override
    public DateTour getDateTourByTourId(Long tourId) {
        return dateTourRepository.findByTourId(tourId);
    }

}
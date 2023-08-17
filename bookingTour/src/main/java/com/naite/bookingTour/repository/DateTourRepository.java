package com.naite.bookingTour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naite.bookingTour.model.DateTour;

@Repository
public interface DateTourRepository extends JpaRepository<DateTour, Long> {
    DateTour findByTourId(Long tourId);
}
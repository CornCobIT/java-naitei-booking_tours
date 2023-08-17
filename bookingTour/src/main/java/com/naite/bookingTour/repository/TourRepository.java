package com.naite.bookingTour.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naite.bookingTour.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findAll();

    Optional<Tour> findById(Long id);

}
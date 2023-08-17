package com.naite.bookingTour.model;

public class TourDateWrapper {
    private Tour tour;
    private DateTour dateTour;
	public TourDateWrapper(Tour tour, DateTour dateTour) {
		super();
		this.tour = tour;
		this.dateTour = dateTour;
	}
	
	public TourDateWrapper() {
		super();
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public DateTour getDateTour() {
		return dateTour;
	}

	public void setDateTour(DateTour dateTour) {
		this.dateTour = dateTour;
	}
	
	
    
}
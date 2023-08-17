package com.naite.bookingTour.model;


import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tours")
public class Tour implements Serializable {
	/**
	 * 
	 * @author PHUONG MINH
	 */
	

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(max = 200)
	@Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
	private String description;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;
    
    @Column(name = "location", columnDefinition = "TEXT")
    private String location;
    
    @Column(name= "duration")
    private Integer duration;
    
    @Transient
    private String imageUrl;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categoryId;
    
    public Tour(long l, String string, String string2) {
    	super();
	}

	public Tour(Long id, String name, String description, BigDecimal price, String location, Integer duration,
			String imageUrl, Category categoryId) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.location = location;
		this.duration = duration;
		this.imageUrl = imageUrl;
		this.categoryId = categoryId;
	}

	public Tour() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}

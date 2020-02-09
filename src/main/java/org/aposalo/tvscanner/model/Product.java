package org.aposalo.tvscanner.model;

import java.sql.Date;

public class Product {

	String name;
	Date year;
	float stars;
	String directors;
	String actors;
	String category;
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setYear(Date newYear) {
		year = newYear;
	}
	
	public Date getYear() {
		return year;
	}
	
	public void setStars(float newStars) {
		stars = newStars;
	}
	
	public float getStars() {
		return stars;
	}
	
	public void setDirectors(String newDirectors) {
		directors = newDirectors;
	}
	
	public String getDirectors() {
		return directors;
	}
	
	public void setActors(String newActors) {
		actors = newActors;
	}
	
	public String getActors() {
		return actors;
	}
	
	public void setCategory(String newCategory) {
		category = newCategory;
	}
	
	public String getCategory() {
		return category;
	}
	
}

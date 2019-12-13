package com.zvone.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="review")
public class EntityReview {

	// define fields
	// define constructors 
	// define getters/setters
	// define tostring
	//annotiate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="comment")
	private String comment;
	
	
	public EntityReview() {
	}

	public EntityReview(String comment) {
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	


	@Override
	public String toString() {
		return "EntityReview [id=" + id + ", comment=" + comment + "]";
	}
	
	
	
}

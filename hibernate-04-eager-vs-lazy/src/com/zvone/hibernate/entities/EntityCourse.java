package com.zvone.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class EntityCourse {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private EntityInstructor instructor;
	
	
	public EntityCourse() {
	}


	public EntityCourse(String title) {
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "EntityCourse [id=" + id + ", title=" + title + "]";
	}


	public EntityInstructor getInstructor() {
		return instructor;
	}


	public void setInstructor(EntityInstructor instructor) {
		this.instructor = instructor;
	}
	
	
	
}

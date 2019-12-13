package com.zvone.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class EntityInstructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="first_name")
	private String first_name; 
	
	@Column(name="last_name")
	private String last_name; 
	
	@Column(name="email")
	private String email; 
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private EntityInstructorDetails instructorDetail;

	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="instructor", 
			cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<EntityCourse> courses;

	

	public void add (EntityCourse theCourse) {
		if (courses == null) {
			courses=new ArrayList<>();
		}
		courses.add(theCourse);
		theCourse.setInstructor(this);
	}
	
	
	public EntityInstructor() {}

	public EntityInstructor(String first_name, String last_name, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "EntityInstructor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", instructorDetail=" + instructorDetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 public EntityInstructorDetails getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(EntityInstructorDetails instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<EntityCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<EntityCourse> courses) {
		this.courses = courses;
	}
	

}

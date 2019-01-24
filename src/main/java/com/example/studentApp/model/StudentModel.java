package com.example.studentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "students")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)

public class StudentModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @NotBlank
    private String student_name;

    @NotBlank
    private String student_addr;
    
    @NotNull
    private int age;
    
    @NotBlank
    private String student_qual;
    
   	@NotNull 
    private float student_percent;

    @NotNull
    private int student_year_passed;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
        
    
    

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_addr() {
		return student_addr;
	}

	public void setStudent_addr(String student_addr) {
		this.student_addr = student_addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStudent_qual() {
		return student_qual;
	}

	public void setStudent_qual(String student_qual) {
		this.student_qual = student_qual;
	}

	public float getStudent_percent() {
		return student_percent;
	}

	public void setStudent_percent(float student_percent) {
		this.student_percent = student_percent;
	}

	public int getStudent_year_passed() {
		return student_year_passed;
	}

	public void setStudent_year_passed(int student_year_passed) {
		this.student_year_passed = student_year_passed;
	}
}


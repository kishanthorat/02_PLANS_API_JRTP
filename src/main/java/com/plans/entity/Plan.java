package com.plans.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PLAN_TABLE")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PLAN_ID")
	private Integer planId;
	@Column(name="PLAN_NAME")
	private String planName;
	@Column(name="PLAN_START_DATE")
	private LocalDate planStartDate;
	@Column(name="PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="ACTIVE1_SW") 
	private String activeSw;
	
	@Column(name="CREATED_BY", updatable=false)
	private String createdBy;
	@Column(name="UPDATED_BY", insertable = false)
	private String updatedBy;
	
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private LocalDate createDate;
	@UpdateTimestamp
	@Column(name="UPDATE_DATE")
	private LocalDate updateDate;

}

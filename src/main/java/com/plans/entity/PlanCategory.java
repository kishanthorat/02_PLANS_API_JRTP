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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "ACTIVE_SW")
	private String activeSw;

	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private LocalDate createDate;
	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updateDate;

}

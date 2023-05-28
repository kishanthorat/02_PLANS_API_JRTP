package com.plans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plans.entity.Plan;
@Repository
public interface PlanRepo extends JpaRepository<Plan, Integer>{

}

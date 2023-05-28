package com.plans.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plans.entity.Plan;
import com.plans.service.PlanService;

@RestController
public class PlanController {

	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategory()
	{
		
		        Map<Integer, String> planCategories = planService.getPlanCategories();
	          
		        return new ResponseEntity<>(planCategories,HttpStatus.OK);
	}
	
	@PostMapping("/Plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan)
	{
		String responseMsg= "";
		
		             boolean savePlan = planService.savePlan(plan);
		             
		       if(savePlan){
		    	   responseMsg="Plan Save";
		       }
		       else{
		    	   responseMsg="Not save";
		       }
					return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);	
	}
	
	@GetMapping("/Plan")
	public ResponseEntity<List<Plan>> getPlan()
	{
		
		                 List<Plan> allPlans = planService.getAllPlans();
		                 
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
		
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		     
		                 Plan planById = planService.getPlanById(planId);
		        	 return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan)
	{
		                     boolean updatePlan = planService.updatePlan(plan);
		                 String responseMsg="";    
		               if(updatePlan)
		               {
		            	     responseMsg="Plan Update";		               }
		               else {
		            	   responseMsg="Not Update";
		               }
		           return new ResponseEntity<>(responseMsg,HttpStatus.OK);    
	}
	
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		     String responseMsg="";
		                      boolean deletePlan = planService.deletePlan(planId);
		                      if(deletePlan) {
		                    	  responseMsg="Plan Delete";
		                      }
		                      else {
		                    	  responseMsg="Not Delete";
		                      }
		                      
		        	 return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
	@PutMapping("/stratus-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status)
	{
		                             boolean statusChange=planService.planStatusChange(planId, status);
		String responseMsg="";
		
		if(statusChange) {
			responseMsg="Status Change";
		}
		else {
			responseMsg="Status Not Change";
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
		                             
	}
	
	
	
}

package com.plans.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plans.constant.AppConstant;
import com.plans.entity.Plan;
import com.plans.properties.AppProperties;
import com.plans.service.PlanService;

@RestController
public class PlanController {

//	@Autowired
	private PlanService planService;
	
	private Map<String, String> messages;

//	@Autowired
//	private AppProperties appProp;
	
	public PlanController(PlanService planService, AppProperties appProp)
	{
		this.planService=planService;
		this.messages=appProp.getMessages();
		System.err.println(this.messages);
	}

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategory() {

		Map<Integer, String> planCategories = planService.getPlanCategories();

		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
//		String responseMsg = "";
		String responseMsg = AppConstant.Empty_STR;

		boolean savePlan = planService.savePlan(plan);

		//Map<String, String> message = appProp.getMessage(); coz we take it globally by using constructor

		if (savePlan) {
			//responseMsg = messages.get("planSaveSucc");
			responseMsg = messages.get(AppConstant.PLAN_SAVE_SUCC);
			// responseMsg = "Plan Save";
		} else {
			//responseMsg = messages.get("planSaveFail");
			responseMsg = messages.get(AppConstant.PLAN_SAVE_FAIL);
			
			// responseMsg = "Plan Not Save";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	@GetMapping("/plan")
	public ResponseEntity<List<Plan>> getPlan() {

		List<Plan> allPlans = planService.getAllPlans();

		return new ResponseEntity<>(allPlans, HttpStatus.OK);

	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {

		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<>(planById, HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		
		//String responseMsg = "";
				String responseMsg = AppConstant.Empty_STR;
				
		boolean updatePlan = planService.updatePlan(plan);

		//Map<String, String> message = appProp.getMessage();
		if (updatePlan) {
			// responseMsg = "Plan Update";
			
//			responseMsg = messages.get("planUpdateSucc");
			responseMsg = messages.get(AppConstant.PLAN_UPDATE_SUCC);
			
		} else {
			// responseMsg = "Not Update";
			
//			responseMsg = messages.get("planUpdateFail");
			responseMsg = messages.get(AppConstant.PLAN_UPDATE_FAIL);
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		//String responseMsg = "";
		String responseMsg = AppConstant.Empty_STR;
		
	//	Map<String, String> message = appProp.getMessage();
		boolean deletePlan = planService.deletePlan(planId);
		if (deletePlan) {

			//responseMsg = messages.get("planDeleteSucc");
			responseMsg = messages.get(AppConstant.PLAN_DELETE_SUCC);
			
			// responseMsg = "Plan Delete";
		} else {
			//responseMsg = messages.get("planDeleteFail");
			responseMsg = messages.get(AppConstant.PLAN_DELETE_Fail);
			
			// responseMsg = "Not Delete";
		}

		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		boolean statusChange = planService.planStatusChange(planId, status);
		//String responseMsg = "";
		String responseMsg = AppConstant.Empty_STR;
		
		//Map<String, String> message = appProp.getMessage();
		if (statusChange) {

			//responseMsg = messages.get("planStatusChange");
			responseMsg = messages.get(AppConstant.PLAN_STATUS_CHANGE);
			
			// responseMsg = "Status Change";
		} else {
			//responseMsg = messages.get("planStatusChangeFail");
			responseMsg = messages.get(AppConstant.PLAN_STATUS_CHANGE_FAIL);
			
			// responseMsg = "Status Not Change";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);

	}

}

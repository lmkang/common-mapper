package org.wandaima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wandaima.model.Criteria;
import org.wandaima.model.EmployeeInfo;
import org.wandaima.service.EmployeeInfoService;

@RestController
@RequestMapping("/employee")
public class EmployeeInfoController {

	@Autowired
	private EmployeeInfoService employeeInfoService;
	
	@PostMapping("/add")
	public Object addEmployeeInfo(EmployeeInfo employeeInfo) {
		int result = employeeInfoService.addEmployeeInfo(employeeInfo);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
	
	@PostMapping("/edit")
	public Object editEmployeeInfo(EmployeeInfo employeeInfo) {
		return "success";
	}
	
	@GetMapping("/list")
	public Object listEmployeeInfo() {
		Criteria criteria = new Criteria();
		criteria.like("departmentInfo.deptName", "测试");
		return employeeInfoService.listEmployeeInfo(criteria);
	}
}

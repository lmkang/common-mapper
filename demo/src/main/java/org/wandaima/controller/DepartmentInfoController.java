package org.wandaima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wandaima.model.DepartmentInfo;
import org.wandaima.service.DepartmentInfoService;

@RestController
@RequestMapping("/dept")
public class DepartmentInfoController {

	@Autowired
	private DepartmentInfoService departmentInfoService;
	
	@PostMapping("/add")
	public Object addDepartmentInfo(DepartmentInfo departmentInfo) {
		int result = departmentInfoService.addDepartmentInfo(departmentInfo);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
}

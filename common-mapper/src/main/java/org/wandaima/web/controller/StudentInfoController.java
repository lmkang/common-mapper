package org.wandaima.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wandaima.web.model.StudentInfo;
import org.wandaima.web.service.StudentInfoService;

@RestController
@RequestMapping("/student")
public class StudentInfoController {

	@Autowired
	private StudentInfoService studentInfoService;
	
	@GetMapping("/add")
	public Object addStudentInfo() {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setName("test");
		studentInfo.setStuNumber("123456");
		studentInfo.setAge(18);
		int result = studentInfoService.addStudentInfo(studentInfo);
		System.out.println(result);
		if(result == 0) {
			return "error";
		}
		return "success";
	}
}

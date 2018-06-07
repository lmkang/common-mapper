package org.wandaima.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.wandaima.annotation.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "employee_info")
public class EmployeeInfo {

	private Long id;
	private String fullName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	private String phoneNumber;
	private DepartmentInfo departmentInfo;
}

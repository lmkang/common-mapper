package org.wandaima.service;

import java.util.List;

import org.wandaima.model.Criteria;
import org.wandaima.model.EmployeeInfo;

public interface EmployeeInfoService {

	int addEmployeeInfo(EmployeeInfo employeeInfo);
	
	int editEmployeeInfo(EmployeeInfo employeeInfo);
	
	List<EmployeeInfo> listEmployeeInfo(Criteria criteria);
}

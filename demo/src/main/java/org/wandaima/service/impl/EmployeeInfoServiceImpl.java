package org.wandaima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wandaima.mapper.EmployeeInfoMapper;
import org.wandaima.model.Criteria;
import org.wandaima.model.EmployeeInfo;
import org.wandaima.service.EmployeeInfoService;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

	@Autowired
	private EmployeeInfoMapper employeeInfoMapper;
	
	@Transactional
	@Override
	public int addEmployeeInfo(EmployeeInfo employeeInfo) {
		if(employeeInfo != null) {
			return employeeInfoMapper.insert(employeeInfo);
		}
		return 0;
	}

	@Transactional
	@Override
	public int editEmployeeInfo(EmployeeInfo employeeInfo) {
		if(employeeInfo != null) {
			return employeeInfoMapper.update(employeeInfo, null);
		}
		return 0;
	}

	@Override
	public List<EmployeeInfo> listEmployeeInfo(Criteria criteria) {
		if(criteria != null) {
			String[] fieldList = {"id", "fullName", "birthday", "phoneNumber", "departmentInfo.deptName"};
			return employeeInfoMapper.selectAll(criteria, fieldList);
		}
		return null;
	}

}

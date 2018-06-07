package org.wandaima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wandaima.mapper.DepartmentInfoMapper;
import org.wandaima.model.DepartmentInfo;
import org.wandaima.service.DepartmentInfoService;

@Service
public class DepartmentInfoServiceImpl implements DepartmentInfoService {

	@Autowired
	private DepartmentInfoMapper departmentInfoMapper;
	
	@Transactional
	@Override
	public int addDepartmentInfo(DepartmentInfo departmentInfo) {
		if(departmentInfo != null) {
			return departmentInfoMapper.insert(departmentInfo);
		}
		return 0;
	}

}

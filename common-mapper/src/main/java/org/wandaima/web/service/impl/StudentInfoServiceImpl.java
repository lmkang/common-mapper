package org.wandaima.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wandaima.web.mapper.StudentInfoMapper;
import org.wandaima.web.model.StudentInfo;
import org.wandaima.web.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	@Transactional
	public int addStudentInfo(StudentInfo studentInfo) {
		if(studentInfo != null) {
			return studentInfoMapper.insert(studentInfo);
		}
		return 0;
	}

}

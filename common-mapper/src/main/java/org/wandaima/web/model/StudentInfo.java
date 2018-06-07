package org.wandaima.web.model;

import java.util.List;

import org.wandaima.annotation.Table;

@Table(name = "student_info")
public class StudentInfo {

	private Long id;
	private String name;
	private Integer age;
	private String stuNumber;
	private List<TeacherInfo> teacherInfoList;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public List<TeacherInfo> getTeacherInfoList() {
		return teacherInfoList;
	}
	public void setTeacherInfoList(List<TeacherInfo> teacherInfoList) {
		this.teacherInfoList = teacherInfoList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stuNumber == null) ? 0 : stuNumber.hashCode());
		result = prime * result + ((teacherInfoList == null) ? 0 : teacherInfoList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stuNumber == null) {
			if (other.stuNumber != null)
				return false;
		} else if (!stuNumber.equals(other.stuNumber))
			return false;
		if (teacherInfoList == null) {
			if (other.teacherInfoList != null)
				return false;
		} else if (!teacherInfoList.equals(other.teacherInfoList))
			return false;
		return true;
	}
	
}

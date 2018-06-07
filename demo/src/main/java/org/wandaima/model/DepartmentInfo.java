package org.wandaima.model;

import lombok.Setter;

import org.wandaima.annotation.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "department_info")
public class DepartmentInfo {

	private Long id;
	private String deptName;
	private String description;
}

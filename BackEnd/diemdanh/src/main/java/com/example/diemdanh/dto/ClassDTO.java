package com.example.diemdanh.dto;

import java.util.List;

import com.example.diemdanh.entity.ClassEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassDTO {
	private int intStatusCode;
	private String strError;
	private String strMsg;
	
	private String strClassId;
	private String strClassName;
	
	private ClassEntity classEntity;
	
	private List<ClassEntity> lstClass; 
	
	public ClassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassDTO(int intStatusCode, String strError, String strMsg, String strClassId, String strClassName,
			ClassEntity classEntity, List<ClassEntity> lstClass) {
		super();
		this.intStatusCode = intStatusCode;
		this.strError = strError;
		this.strMsg = strMsg;
		this.strClassId = strClassId;
		this.strClassName = strClassName;
		this.classEntity = classEntity;
		this.lstClass = lstClass;
	}

	public int getIntStatusCode() {
		return intStatusCode;
	}

	public void setIntStatusCode(int intStatusCode) {
		this.intStatusCode = intStatusCode;
	}

	public String getStrError() {
		return strError;
	}

	public void setStrError(String strError) {
		this.strError = strError;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public String getStrClassId() {
		return strClassId;
	}

	public void setStrClassId(String strClassId) {
		this.strClassId = strClassId;
	}

	public String getStrClassName() {
		return strClassName;
	}

	public void setStrClassName(String strClassName) {
		this.strClassName = strClassName;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public List<ClassEntity> getLstClass() {
		return lstClass;
	}

	public void setLstClass(List<ClassEntity> lstClass) {
		this.lstClass = lstClass;
	}
}
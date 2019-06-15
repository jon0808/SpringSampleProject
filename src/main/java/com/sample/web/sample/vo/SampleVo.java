package com.sample.web.sample.vo;

public class SampleVo {
    private int deptNo;
    private String deptName;
    
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "{deptNo=" + deptNo + ", deptName=" + deptName + "}";
	}
	
	
}

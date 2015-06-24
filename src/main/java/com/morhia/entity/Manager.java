package com.morhia.entity;

public class Manager extends Employee {
	Boolean approveFunds;

	public Boolean getApproveFunds() {
		return approveFunds;
	}

	public void setApproveFunds(Boolean approveFunds) {
		this.approveFunds = approveFunds;
	}

	@Override
	public String toString() {
		return "Manager [approveFunds=" + approveFunds + ", id=" + id
				+ ", name=" + name + "]";
	}

}

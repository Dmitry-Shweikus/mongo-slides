package com.morhia.entity;

public class Worker extends Employee{
	Integer yearsExperience;

	public Integer getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	@Override
	public String toString() {
		return "Worker [yearsExperience=" + yearsExperience + ", id=" + id
				+ ", name=" + name + "]";
	}
}

package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class Vacation extends Entity {
	private static final long serialVersionUID = -634462871920702537L;
	private Integer vacYear;
	private Integer vacDaysLeft;
	private int vacType;
	private int vacEmployeeId;
	
	
	public Vacation() {
		super();
	}
	public Vacation(int vacType, int vacEmployeeId) {
		super();
		this.vacType = vacType;
		this.vacEmployeeId = vacEmployeeId;
	}
	public Vacation(Integer vacYear, Integer vacDaysLeft, int vacType, int vacEmployeeId) {
		super();
		this.vacYear = vacYear;
		this.vacDaysLeft = vacDaysLeft;
		this.vacType = vacType;
		this.vacEmployeeId = vacEmployeeId;
	}
	

	public Integer getVacYear() {
		return this.vacYear;
	}
	public void setVacYear(Integer vacYear) {
		this.vacYear = vacYear;
	}
	public Integer getVacDaysLeft() {
		return this.vacDaysLeft;
	}
	public void setVacDaysLeft(Integer vacDaysLeft) {
		this.vacDaysLeft = vacDaysLeft;
	}
	public int getVacType() {
		return this.vacType;
	}
	public void setVacType(int vacType) {
		this.vacType = vacType;
	}
	public int getVacEmployeeId() {
		return this.vacEmployeeId;
	}
	public void setVacEmployeeId(int vacEmployeeId) {
		this.vacEmployeeId = vacEmployeeId;
	}
}
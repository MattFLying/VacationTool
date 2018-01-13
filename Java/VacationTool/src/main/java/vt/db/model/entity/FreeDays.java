package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class FreeDays extends Entity {
	private static final long serialVersionUID = -6860986496270908990L;
	private Integer freeDay;
	private Integer freeMonth;
	private Integer freeYear;

	
	public FreeDays() {
		super();
	}
	public FreeDays(Integer freeDay, Integer freeMonth, Integer freeYear) {
		super();
		this.freeDay = freeDay;
		this.freeMonth = freeMonth;
		this.freeYear = freeYear;
	}

	
	public Integer getFreeDay() {
		return this.freeDay;
	}
	public void setFreeDay(Integer freeDay) {
		this.freeDay = freeDay;
	}
	public Integer getFreeMonth() {
		return this.freeMonth;
	}
	public void setFreeMonth(Integer freeMonth) {
		this.freeMonth = freeMonth;
	}
	public Integer getFreeYear() {
		return this.freeYear;
	}
	public void setFreeYear(Integer freeYear) {
		this.freeYear = freeYear;
	}
}
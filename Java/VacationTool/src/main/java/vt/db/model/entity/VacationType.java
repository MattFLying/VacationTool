package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class VacationType extends Entity {
	private static final long serialVersionUID = -4948327781815195654L;
	private String vacTypeName;
	private Integer vacTypeMaxDays;

	
	public VacationType() {
		super();
	}
	public VacationType(String vacTypeName, Integer vacTypeMaxDays) {
		super();
		this.vacTypeName = vacTypeName;
		this.vacTypeMaxDays = vacTypeMaxDays;
	}


	public String getVacTypeName() {
		return this.vacTypeName;
	}
	public void setVacTypeName(String vacTypeName) {
		this.vacTypeName = vacTypeName;
	}
	public Integer getVacTypeMaxDays() {
		return this.vacTypeMaxDays;
	}
	public void setVacTypeMaxDays(Integer vacTypeMaxDays) {
		this.vacTypeMaxDays = vacTypeMaxDays;
	}
}
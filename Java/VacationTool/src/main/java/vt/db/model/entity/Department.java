package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class Department extends Entity {
	private static final long serialVersionUID = -6065174214450498585L;
	private String depName;

	
	public Department() {
		super();
	}
	public Department(String depName) {
		super();
		this.depName = depName;
	}

	
	public String getDepName() {
		return this.depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
}
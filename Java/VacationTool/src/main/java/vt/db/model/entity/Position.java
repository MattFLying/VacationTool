package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class Position extends Entity {
	private static final long serialVersionUID = 8899862037850331650L;
	private String positionName;
	private Integer positionDepartmentId;
	
	
	public Position() {
		super();
	}
	public Position(String positionName, Integer positionDepartmentId) {
		super();
		this.positionName = positionName;
		this.positionDepartmentId = positionDepartmentId;
	}
	

	public String getPositionName() {
		return this.positionName;
	}
	public void setPositionName(String posName) {
		this.positionName = posName;
	}
	public Integer getPositionDepartmentId() {
		return this.positionDepartmentId;
	}
	public void setPositionDepartmentId(Integer positionDepartmentId) {
		this.positionDepartmentId = positionDepartmentId;
	}
}
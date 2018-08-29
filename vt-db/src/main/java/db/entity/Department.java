package db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class represents Department.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
@Entity
@Table(name = "vt_department")
public final class Department extends BaseEntity {
	private static final long serialVersionUID = -6065174214450498585L;
	private String departmentName;

	/**
	 * Default constructor.
	 */
	public Department() {
		super();
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of department
	 * @param departmentName
	 *            department name
	 */
	public Department(Integer id, String departmentName) {
		super(id);
		this.departmentName = departmentName;
	}

	/**
	 * Method to get department name
	 * 
	 * @return department name
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Method to set department name
	 * 
	 * @param departmentName
	 *            department name
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
package db.entity;

/**
 * Entity class represents Position.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
public final class Position extends Entity {
	private static final long serialVersionUID = 8899862037850331650L;
	private String positionName;
	private Integer departmentId;

	/**
	 * Default constructor.
	 */
	public Position() {
		super();
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of position
	 * @param positionName
	 *            position name
	 * @param positionDepartmentId
	 *            department of which position exists
	 */
	public Position(Integer id, String positionName, Integer departmentId) {
		super(id);
		this.positionName = positionName;
		this.departmentId = departmentId;
	}

	/**
	 * Method to get position name
	 * 
	 * @return position name
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * Method to get department of which position exists
	 * 
	 * @return department of which position exists
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * Method to set position name
	 * 
	 * @param positionName
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * Method to set department of which position exists
	 * 
	 * @param departmentId
	 *            department of which position exists
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
}
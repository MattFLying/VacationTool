package db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class represents Employee.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
@Entity
@Table(name = "vt_employee")
public final class Employee extends BaseEntity {
	private static final long serialVersionUID = -1400760321767476971L;
	private String firstName, password, role, lastName, birthDate, avatar, evidenceNumber, firstWorkDay;
	private Integer departmentId, enabled, positionId, managerId, isManager, workingHoursPerDay;
	private Double areaOfWork;

	/**
	 * Default constructor.
	 */
	public Employee() {
		super();
	}

	/**
	 * Default constructor to set employee identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 */
	public Employee(Integer id) {
		this();

		setId(id);
	}

	/**
	 * Constructor build basic information of employee.
	 * 
	 * @param firstName
	 *            employee's name
	 * @param lastName
	 *            employee's surname
	 */
	public Employee(String firstName, String lastName) {
		this();

		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Constructor build basic information of employee with identificator.
	 * 
	 * @param id
	 *            identificator of employee
	 * @param firstName
	 *            employee's name
	 * @param lastName
	 *            employee's surname
	 */
	public Employee(Integer id, String firstName, String lastName) {
		this(firstName, lastName);

		setId(id);
	}

	/**
	 * Constructor to build basic information with department identificator for
	 * employee.
	 * 
	 * @param id
	 *            identificator of employee
	 * @param firstName
	 *            employee's name
	 * @param lastName
	 *            employee's surname
	 * @param departmentId
	 *            department identificator where employee works
	 */
	public Employee(Integer id, String firstName, String lastName, Integer departmentId) {
		this(id, firstName, lastName);

		this.departmentId = departmentId;
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of employee
	 * @param firstName
	 *            first name of employee
	 * @param password
	 *            employee's password
	 * @param role
	 *            employee's role in system
	 * @param lastName
	 *            surname of employee
	 * @param birthDate
	 *            birthdate
	 * @param avatar
	 *            employee's picture in system
	 * @param departmentId
	 *            identificator of deparment where employee is working
	 * @param enabled
	 *            is the account enabled
	 * @param positionId
	 *            identificator of position held by employee
	 * @param managerId
	 *            identificator of manager of employee
	 * @param isManager
	 *            is employee manager
	 * @param evidenceNumber
	 *            evidence number of employee in company
	 * @param areaOfWork
	 *            area of work: 1 - full-time, 0.5 - half-time etc.
	 * @param workingHoursPerDay
	 *            how many hours employee should work per day(should depends
	 *            than area of work)
	 * @param firstWorkDay
	 *            date of first day in work
	 */
	public Employee(Integer id, String firstName, String password, String role, String lastName, String birthDate,
			String avatar, Integer departmentId, Integer enabled, Integer positionId, Integer managerId,
			Integer isManager, String evidenceNumber, Double areaOfWork, Integer workingHoursPerDay,
			String firstWorkDay) {
		super(id);

		this.firstName = firstName;
		this.password = password;
		this.role = role;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.avatar = avatar;
		this.departmentId = departmentId;
		this.enabled = enabled;
		this.positionId = positionId;
		this.managerId = managerId;
		this.isManager = isManager;
		this.evidenceNumber = evidenceNumber;
		this.areaOfWork = areaOfWork;
		this.workingHoursPerDay = workingHoursPerDay;
		this.firstWorkDay = firstWorkDay;
	}

	/**
	 * Method to get first name of employee
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Method to get employee's password
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to get employee's role in system
	 * 
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Method to get surname of employee
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Method to get birthdate
	 * 
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Method to get employee's picture in system
	 * 
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Method to get evidence number of employee in company
	 * 
	 * @return the evidenceNumber
	 */
	public String getEvidenceNumber() {
		return evidenceNumber;
	}

	/**
	 * Method to get date of first day in work
	 * 
	 * @return the firstWorkDay
	 */
	public String getFirstWorkDay() {
		return firstWorkDay;
	}

	/**
	 * Method to get identificator of deparment where employee is working
	 * 
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * Method to get if the account is enabled
	 * 
	 * @return the enabled
	 */
	public Integer getEnabled() {
		return enabled;
	}

	/**
	 * Method to get identificator of position held by employee
	 * 
	 * @return the positionId
	 */
	public Integer getPositionId() {
		return positionId;
	}

	/**
	 * Method to get identificator of manager of employee
	 * 
	 * @return the managerId
	 */
	public Integer getManagerId() {
		return managerId;
	}

	/**
	 * Method to check if employee is manager
	 * 
	 * @return the isManager
	 */
	public Integer getIsManager() {
		return isManager;
	}

	/**
	 * Method to get how many hours employee should work per day(should depends
	 * than area of work)
	 * 
	 * @return the workingHoursPerDay
	 */
	public Integer getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}

	/**
	 * Method to get area of work: 1 - full-time, 0.5 - half-time etc.
	 * 
	 * @return the areaOfWork
	 */
	public Double getAreaOfWork() {
		return areaOfWork;
	}

	/**
	 * Method to set first name of employee
	 * 
	 * @param firstName
	 *            the firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Method to set employee's password
	 * 
	 * @param password
	 *            the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method to set employee's role in system
	 * 
	 * @param role
	 *            the role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Method to set surname of employee
	 * 
	 * @param lastName
	 *            the lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Method to set birthdate
	 * 
	 * @param birthDate
	 *            the birthDate
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Method to set employee's picture in system
	 * 
	 * @param avatar
	 *            the avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Method to set evidence number of employee in company
	 * 
	 * @param evidenceNumber
	 *            the evidenceNumber
	 */
	public void setEvidenceNumber(String evidenceNumber) {
		this.evidenceNumber = evidenceNumber;
	}

	/**
	 * Method to set date of first day in work
	 * 
	 * @param firstWorkDay
	 *            the firstWorkDay
	 */
	public void setFirstWorkDay(String firstWorkDay) {
		this.firstWorkDay = firstWorkDay;
	}

	/**
	 * Method to set identificator of deparment where employee is working
	 * 
	 * @param departmentId
	 *            the departmentId
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Method to set the account enabled
	 * 
	 * @param enabled
	 *            the enabled
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	/**
	 * Method to set identificator of position held by employee
	 * 
	 * @param positionId
	 *            the positionId
	 */
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	/**
	 * Method to set identificator of manager of employee
	 * 
	 * @param managerId
	 *            the managerId
	 */
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	/**
	 * Method to set if employee is manager
	 * 
	 * @param isManager
	 *            the isManager
	 */
	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	/**
	 * Method to set how many hours employee should work per day(should depends
	 * than area of work)
	 * 
	 * @param workingHoursPerDay
	 *            the workingHoursPerDay
	 */
	public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}

	/**
	 * Method to set area of work: 1 - full-time, 0.5 - half-time etc.
	 * 
	 * @param areaOfWork
	 *            the areaOfWork
	 */
	public void setAreaOfWork(Double areaOfWork) {
		this.areaOfWork = areaOfWork;
	}

}
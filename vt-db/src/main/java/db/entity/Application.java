package db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class represents application of vacation.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
@Entity
@Table(name = "vt_application")
public final class Application extends BaseEntity {
	private static final long serialVersionUID = -1142522010772045610L;
	private String dateFrom, dateTo, acceptedDate, modifiedDate, status, managerComment, createdDate, comment;
	private Integer type, days, replacement, employeeId, managerId, acceptedManager;

	/**
	 * Default constructor.
	 */
	public Application() {
		super();
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of application
	 * @param type
	 *            application type
	 * @param dateFrom
	 *            application start date
	 * @param dateTo
	 *            application end date
	 * @param days
	 *            number of days
	 * @param replacement
	 *            identificator of employee to replacement
	 * @param comment
	 *            comment to application
	 * @param employeeId
	 *            identificator of employee for current application
	 * @param createdDate
	 *            date of created application
	 * @param acceptedManager
	 *            identificator of manager which accepted application
	 * @param managerId
	 *            identificator of employee's manager which should accept
	 *            application
	 * @param acceptedDate
	 *            date of acceptation
	 * @param modifiedDate
	 *            date of modification
	 * @param atatus
	 *            status of application
	 * @param managerComment
	 *            comment to current application from manager
	 */
	public Application(String dateFrom, String dateTo, String acceptedDate, String modifiedDate, String status,
			String managerComment, String createdDate, String comment, Integer type, Integer days, Integer replacement,
			Integer employeeId, Integer managerId, Integer acceptedManager) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.acceptedDate = acceptedDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.managerComment = managerComment;
		this.createdDate = createdDate;
		this.comment = comment;
		this.type = type;
		this.days = days;
		this.replacement = replacement;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.acceptedManager = acceptedManager;
	}

	/**
	 * Method to get application start date
	 * 
	 * @return application start date
	 */
	public String getDateFrom() {
		return dateFrom;
	}

	/**
	 * Method to get application end date
	 * 
	 * @return application end date
	 */
	public String getDateTo() {
		return dateTo;
	}

	/**
	 * Method to get date of acceptation
	 * 
	 * @return the AcceptedDate date of acceptation
	 */
	public String getAcceptedDate() {
		return acceptedDate;
	}

	/**
	 * Method to get date of modification
	 * 
	 * @return the ModifiedDate date of modification
	 */
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Method to get status of application
	 * 
	 * @return status of application
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Method to get comment to current application from manager
	 * 
	 * @return comment to current application from manager
	 */
	public String getManagerComment() {
		return managerComment;
	}

	/**
	 * Method to get date of created application
	 * 
	 * @return date of created application
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Method to get comment to application
	 * 
	 * @return comment to application
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Method to get application type
	 * 
	 * @return application type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Method to get number of days
	 * 
	 * @return number of days
	 */
	public Integer getDays() {
		return days;
	}

	/**
	 * Method to get identificator of employee to replacement
	 * 
	 * @return identificator of employee to replacement
	 */
	public Integer getReplacement() {
		return replacement;
	}

	/**
	 * Method to get identificator of employee for current application
	 * 
	 * @return identificator of employee for current application
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Method to get identificator of employee's manager which should accept
	 * application
	 * 
	 * @return identificator of employee's manager which should accept
	 *         application
	 */
	public Integer getManagerId() {
		return managerId;
	}

	/**
	 * Method to get identificator of manager which accepted application
	 * 
	 * @return identificator of manager which accepted application
	 */
	public Integer getAcceptedManager() {
		return acceptedManager;
	}

	/**
	 * Method to set application start date
	 * 
	 * @param DateFrom
	 *            the DateFrom
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 * Method to set application end date
	 * 
	 * @param DateTo
	 *            the DateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 * Method to set date of acceptation
	 * 
	 * @param AcceptedDate
	 *            date of acceptation
	 */
	public void setAcceptedDate(String acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	/**
	 * Method to set date of modification
	 * 
	 * @param ModifiedDate
	 *            date of modification
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * Method to set status of application
	 * 
	 * @param Status
	 *            status of application
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Method to set comment to current application from manager
	 * 
	 * @param ManagerComment
	 *            comment to current application from manager
	 */
	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}

	/**
	 * Method to set date of created application
	 * 
	 * @param CreatedDate
	 *            date of created application
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Method to set comment to application
	 * 
	 * @param Comment
	 *            comment to application
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Method to set application type
	 * 
	 * @param Type
	 *            the Type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Method to set number of days
	 * 
	 * @param Days
	 *            number of days
	 */
	public void setDays(Integer days) {
		this.days = days;
	}

	/**
	 * Method to set identificator of employee to replacement
	 * 
	 * @param Replacement
	 *            identificator of employee to replacement
	 */
	public void setReplacement(Integer replacement) {
		this.replacement = replacement;
	}

	/**
	 * Method to set identificator of employee for current application
	 * 
	 * @param EmployeeId
	 *            identificator of employee for current application
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Method to set identificator of employee's manager which should accept
	 * application
	 * 
	 * @param ManagerId
	 *            identificator of employee's manager which should accept
	 *            application
	 */
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	/**
	 * Method to set identificator of manager which accepted application
	 * 
	 * @param AcceptedManager
	 *            identificator of manager which accepted application
	 */
	public void setAcceptedManager(Integer acceptedManager) {
		this.acceptedManager = acceptedManager;
	}

}
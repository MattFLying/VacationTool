package db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class represents Vacation.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
@Entity
@Table(name = "vt_vacation")
public final class Vacation extends BaseEntity {
	private static final long serialVersionUID = -634462871920702537L;
	private Integer vacationYear, vacationDaysLeft, vacationType, employeeId;

	/**
	 * Default constructor.
	 */
	public Vacation() {
		super();
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of vacation
	 * @param vacYear
	 *            vacation year
	 * @param vacDaysLeft
	 *            vacation days left
	 * @param vacType
	 *            vacation type
	 * @param employeeId
	 *            identificator of employee for current vacation
	 */
	public Vacation(Integer id, Integer vacationYear, Integer vacationDaysLeft, Integer vacationType,
			Integer employeeId) {
		super(id);
		this.vacationYear = vacationYear;
		this.vacationDaysLeft = vacationDaysLeft;
		this.vacationType = vacationType;
		this.employeeId = employeeId;
	}

	/**
	 * Method to get vacation year
	 * 
	 * @return vacation year
	 */
	public Integer getVacationYear() {
		return vacationYear;
	}

	/**
	 * Method to get vacation days left
	 * 
	 * @return vacation days left
	 */
	public Integer getVacationDaysLeft() {
		return vacationDaysLeft;
	}

	/**
	 * Method to get vacation type
	 * 
	 * @return vacation type
	 */
	public Integer getVacationType() {
		return vacationType;
	}

	/**
	 * Method to get identificator of employee for current vacation
	 * 
	 * @return identificator of employee for current vacation
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Method to set vacation year
	 * 
	 * @param vacationYear
	 *            vacation year
	 */
	public void setVacationYear(Integer vacationYear) {
		this.vacationYear = vacationYear;
	}

	/**
	 * Method to set vacation days left
	 * 
	 * @param vacationDaysLeft
	 *            vacation days left
	 */
	public void setVacationDaysLeft(Integer vacationDaysLeft) {
		this.vacationDaysLeft = vacationDaysLeft;
	}

	/**
	 * Method to set vacation type
	 * 
	 * @param vacationType
	 *            vacation type
	 */
	public void setVacationType(Integer vacationType) {
		this.vacationType = vacationType;
	}

	/**
	 * Method to set identificator of employee for current vacation
	 * 
	 * @param vacation
	 *            identificator of employee for current vacation
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
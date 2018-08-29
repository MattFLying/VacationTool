package db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class represents Vacation Type.<br>
 * <br>
 * Generated 2017-09-26 19:55:22 by Hibernate Tools 5.1.0.Alpha1 and modified by
 * Mateusz Mucha.
 * 
 * @author Mateusz Mucha
 *
 */
@Entity
@Table(name = "vt_vacation_type")
public final class VacationType extends BaseEntity {
	private static final long serialVersionUID = -4948327781815195654L;
	private String vacationTypeName;
	private Integer vacationTypeMaxDays;

	/**
	 * Default constructor.
	 */
	public VacationType() {
		super();
	}

	/**
	 * Default constructor with all possible parameters to set up.
	 * 
	 * @param id
	 *            identificator of vacation type
	 * @param vacationTypeName
	 *            name of vacation type
	 * @param vacationTypeMaxDays
	 *            max days of this vacation type to use
	 */
	public VacationType(Integer id, String vacationTypeName, Integer vacationTypeMaxDays) {
		super(id);
		this.vacationTypeName = vacationTypeName;
		this.vacationTypeMaxDays = vacationTypeMaxDays;
	}

	/**
	 * Method to get name of vacation type
	 * 
	 * @return name of vacation type
	 */
	public String getVacationTypeName() {
		return this.vacationTypeName;
	}

	/**
	 * Method to get max days of this vacation type to use
	 * 
	 * @return max days of this vacation type to use
	 */
	public Integer getVacationTypeMaxDays() {
		return this.vacationTypeMaxDays;
	}

	/**
	 * Method to set name of vacation type
	 * 
	 * @param vacationTypeName
	 *            name of vacation type
	 */
	public void setVacationTypeName(String vacationTypeName) {
		this.vacationTypeName = vacationTypeName;
	}

	/**
	 * Method to set max days of this vacation type to use
	 * 
	 * @param vacationTypeMaxDays
	 *            max days of this vacation type to use
	 */
	public void setVacationTypeMaxDays(Integer vacationTypeMaxDays) {
		this.vacationTypeMaxDays = vacationTypeMaxDays;
	}
}
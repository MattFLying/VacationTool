package db.entity;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import db.util.ClassFields;

/**
 * Abstract representation of entites with common ID attribute.
 * 
 * @author Mateusz Mucha
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = -3968642659012613961L;
	@Id
	@GeneratedValue
	private Integer id;

	/**
	 * Default constructor.
	 */
	protected BaseEntity() {
		this.id = 0;
	}

	/**
	 * Default constructor to set up identificator of entity.
	 * 
	 * @param id
	 *            - identificator of entity
	 */
	protected BaseEntity(Integer id) {
		this.id = id;
	}

	/**
	 * Method to get identificator of entity.
	 * 
	 * @return identificator of entity
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Method to set identificator of entity.
	 * 
	 * @param id
	 *            identificator of entity
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Method shows all parameters and their values. If values of keys are null
	 * then they are skiped.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		ClassFields.getClassFields(this).entrySet().stream().forEach((field) -> {
			Optional.ofNullable(field.getValue()).map(value -> sb.append("[").append(field.getKey()).append(" -> ")
					.append(field.getValue()).append("] "));
		});

		return sb.toString();
	}

}
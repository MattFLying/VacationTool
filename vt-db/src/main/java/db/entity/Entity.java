package db.entity;

import java.io.Serializable;

import db.util.ClassFields;

/**
 * Abstract representation of entites with common ID attribute.
 * 
 * @author Mateusz Mucha
 *
 */
public abstract class Entity implements Serializable {
	private static final long serialVersionUID = -3968642659012613961L;
	private Integer id;

	/**
	 * Default constructor.
	 */
	protected Entity() {
		this.id = 0;
	}

	/**
	 * Default constructor to set up identificator of entity.
	 * 
	 * @param id
	 *            - identificator of entity
	 */
	protected Entity(Integer id) {
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
	 * Method shows all parameters and their values.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		ClassFields.getClassFields(this).entrySet().stream().forEach((field) -> {
			sb.append("[");
			sb.append(field.getKey());
			sb.append(" -> ");
			sb.append(field.getValue());
			sb.append("] ");
		});

		return sb.toString();
	}

}
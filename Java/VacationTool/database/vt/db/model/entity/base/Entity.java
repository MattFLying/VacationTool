package vt.db.model.entity.base;
/***
 * Basic abstract class represents entities. Should be exntended by each one entity class.
 * @author Mateusz Mucha
 */
public abstract class Entity implements java.io.Serializable {
	private static final long serialVersionUID = -3968642659012613961L;
	private Integer id;
	
	/**
	 * Default constructor.
	 */
	public Entity() {
		this.id = 0;
	}
	
	/**
	 * Method returns id.
	 * @return identificator
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Method sets id.
	 * @param id - identificator
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
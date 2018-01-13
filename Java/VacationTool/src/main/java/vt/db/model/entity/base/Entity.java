package vt.db.model.entity.base;


public abstract class Entity implements java.io.Serializable {
	private static final long serialVersionUID = -3968642659012613961L;
	private Integer id;
	
	public Entity() {
		this.id = 0;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
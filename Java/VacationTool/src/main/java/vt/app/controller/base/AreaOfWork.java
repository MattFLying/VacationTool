package vt.app.controller.base;

public enum AreaOfWork {
	FULL(1.0, "Pełny etat"), HALF(0.5, "1/2 etatu"), SIXHOURS(0.75, "3/4 etatu"), TWOHOURS(0.25, "1/4 etatu");
	
	private double value;
	private String name;
	AreaOfWork(double value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public static AreaOfWork find(double id) {
		if(id == FULL.getValue()) {
			return AreaOfWork.FULL;
		} else if(id == HALF.getValue()) {
			return AreaOfWork.HALF;
		} else if(id == SIXHOURS.getValue()) {
			return AreaOfWork.SIXHOURS;
		} else if(id == TWOHOURS.getValue()) {
			return AreaOfWork.TWOHOURS;
		} else {
			return null;
		}
	}
}
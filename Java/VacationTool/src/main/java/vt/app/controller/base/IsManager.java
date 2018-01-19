package vt.app.controller.base;

public enum IsManager {
	NO(0, "Nie"), YES(1, "Tak");
	
	private int value;
	private String name;
	IsManager(int value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public static IsManager find(int id) {
		return (id == 0) ? IsManager.NO : IsManager.YES;
	}
}
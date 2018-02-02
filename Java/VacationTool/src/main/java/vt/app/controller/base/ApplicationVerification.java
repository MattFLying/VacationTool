package vt.app.controller.base;

public enum ApplicationVerification {
	ACCEPTED("Wniosek został zaakceptowany przez przełożonego."), DECLINED("Wniosek został odrzucony przez przełożonego."), WAIT("Wniosek oczekuje na rozpatrzenie...");
	
	private String name;
	ApplicationVerification(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
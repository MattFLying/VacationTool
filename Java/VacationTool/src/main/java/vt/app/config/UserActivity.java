package vt.app.config;

public enum UserActivity {
	NO("Nie", 0), YES("Tak", 1);
	
	private String title;
	private int id;
	UserActivity(String title, int id) {
		this.title = title;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public int getId() {
		return id;
	}
	public static UserActivity find(int id) {
		if(id == NO.id) {
			return NO;
		} else if(id == YES.id) {
			return YES;
		} else {
			return null;
		}
	}
}
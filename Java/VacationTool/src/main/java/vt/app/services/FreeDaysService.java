package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;
import vt.db.controller.dao.FreeDaysDao;
import vt.db.controller.dao.interfaces.IFreeDays;

@Service
public class FreeDaysService {
	private IFreeDays freeDays;
	
	


	public FreeDaysService() {
		this.freeDays = new FreeDaysDao();
	}
	

	public IFreeDays getFreeDays() {
		return freeDays;
	}
	
	public String getMonthName(int monthNumber) {
		switch(monthNumber) {
			case 1:
				return "Styczeń";
			case 2:
				return "Luty";
			case 3:
				return "Marzec";
			case 4:
				return "Kwiecień";
			case 5:
				return "Maj";
			case 6:
				return "Czerwiec";
			case 7:
				return "Lipiec";
			case 8:
				return "Sierpień";
			case 9:
				return "Wrzesień";
			case 10:
				return "Pazdziernik";
			case 11:
				return "Listopad";
			case 12:
				return "Grudzień";
			default:
				return "none";
		}
	}
	
	
	
	
	
}
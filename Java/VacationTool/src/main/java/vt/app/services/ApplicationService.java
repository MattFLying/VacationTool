package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;

import vt.app.controller.base.ApplicationVerification;
import vt.db.controller.dao.ApplicationDao;
import vt.db.controller.dao.interfaces.IApplication;

@Service
public class ApplicationService {
	private IApplication app;
	
	


	public ApplicationService() {
		this.app = new ApplicationDao();
	}
	

	public IApplication getApp() {
		return app;
	}
	public String getStatusName(String id) {
		if(id.equals(ApplicationVerification.ACCEPTED.name())) {
			return ApplicationVerification.ACCEPTED.getName();
		} else if(id.equals(ApplicationVerification.DECLINED.name())) {
			return ApplicationVerification.DECLINED.getName();
		} else if(id.equals(ApplicationVerification.WAIT.name())) {
			return ApplicationVerification.WAIT.getName();
		} else {
			return null;
		}
	}
	
	
	
}
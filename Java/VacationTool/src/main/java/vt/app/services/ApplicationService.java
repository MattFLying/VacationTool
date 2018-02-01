package vt.app.services;

import java.util.List;
import org.springframework.stereotype.Service;
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
	
	
	
	
}
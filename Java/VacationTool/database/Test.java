import java.util.ArrayList;
import java.util.List;

import vt.db.controller.dao.DepartmentDao;
import vt.db.controller.dao.interfaces.IDepartmentDao;
import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Department;

public class Test {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		Department entity;
		IGenericDao<Department> genDao = new DepartmentDao();
		IDepartmentDao depDao = (IDepartmentDao)genDao;
		
		
		
		
		/*entity = dao.findById(1);
		System.out.println(entity.getDepName());*/
		
		/*List<Department> list = new ArrayList<Department>();
		list = dao.findAll(Department.class);
		for(Department d : list) {
			System.out.println(d.getDepName());
		}*/
		
		/*entity = dao.findById(6);
		System.out.println("Status usuniecia: " + dao.delete(entity));*/
		
		/*entity = dao.findById(6);
		entity.setDepName("Departamencik");
		System.out.println("Status update: " + dao.update(entity));*/
		
		/*entity = new Department();
		entity.setDepName("Nowo dodany");
		System.out.println("Status dodania: " + dao.save(entity));*/
		
		
		
	}

}

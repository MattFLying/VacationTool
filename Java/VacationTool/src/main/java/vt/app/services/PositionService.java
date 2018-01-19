package vt.app.services;

import java.util.List;

import org.springframework.stereotype.Service;
import vt.db.controller.dao.PositionDao;
import vt.db.controller.dao.interfaces.IPosition;
import vt.db.model.entity.Position;

@Service
public class PositionService {
	private IPosition pos;
	
	


	public PositionService() {
		this.pos = new PositionDao();
	}
	

	public IPosition getPos() {
		return pos;
	}
	public Position getPositionById(int id) {
		return this.pos.findById(id);
	}
	public List<Position> getAllPositions() {
		return this.pos.findAllPositions();
	}
	
	
}
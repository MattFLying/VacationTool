package vt.db.controller.dao.interfaces;

import java.util.List;

import vt.db.model.dao.IGenericDao;
import vt.db.model.entity.Position;


public interface IPosition extends IGenericDao<Position> {
	public List<Position> findAllPositions();
}
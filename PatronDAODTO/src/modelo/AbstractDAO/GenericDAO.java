package modelo.AbstractDAO;

import java.util.Collection;

public interface GenericDAO<T,ID> {
	public void create(T entidad);
	public Collection<T> findAll();
	public T findById(ID id);
}

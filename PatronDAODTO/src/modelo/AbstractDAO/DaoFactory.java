package modelo.AbstractDAO;

import modelo.ImplDAO.PersonaDAOJdbc;

public abstract class DaoFactory {
	public DaoFactory factory;

	public DaoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DaoFactory getFactory() {
		return factory;
	}

	public void setFactory(DaoFactory factory) {
		this.factory = factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	
}

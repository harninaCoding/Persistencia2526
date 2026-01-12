package modelo.AbstractDAO;

import modelo.Entity.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer> {
	public Persona findByName(String name);
}

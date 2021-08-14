package model.core.managers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import pruebaMSEJB.model.core.entities.Asignatura;

/**
 * Session Bean implementation class ManagerAsignatura
 */
@Stateless
@LocalBean
public class DAOManagerAsignatura {
	@PersistenceContext(unitName = "samoretacDS")
	private EntityManager em;
    /**
     * Default constructor. 
     */
	
	
	
    public DAOManagerAsignatura() {
        // TODO Auto-generated constructor stub
    	
    	
    }
    
    
    public List<Asignatura> findAllAsignaturas(){
    	return em.createNamedQuery("Asignatura.findAll", Asignatura.class).getResultList();		
    }
    
    
    public void insertarEstudiante(Asignatura asignatura) throws Exception {
    	em.persist(asignatura);
    }
    
    public void eliminarAignatura(int idAsignatura) {
    	Asignatura e = em.find(Asignatura.class, idAsignatura);
    	if (e!= null)
    		em.remove(e);
    }
    
    public void actualizarEstudiante(Asignatura asignatura) throws Exception{
    	Asignatura e = em.find(Asignatura.class, asignatura.getIdAsignatura());
    	if (e == null) 
    		throw new Exception("Ya existe la cedula");
    	////crud asignaturas
    	e.setNombreAsignatura(asignatura.getNombreAsignatura());
    	e.setDescripcionAsignatura(asignatura.getDescripcionAsignatura());
    	e.setNivel(asignatura.getNivel());
    	em.merge(e);
    }
    
    /////metodos de la API Crud
    
	public Asignatura findByIdApi(int id) {
		return em.find(Asignatura.class, id);
	}


}

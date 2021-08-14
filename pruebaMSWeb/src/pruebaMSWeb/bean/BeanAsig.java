/**
 * 
 */
package pruebaMSWeb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.core.managers.DAOManagerAsignatura;
import pruebaMSEJB.model.core.entities.Asignatura;
import util.JSFUtil;

@Named
@SessionScoped
/**
 * @author fedora
 *
 */
public class BeanAsig implements Serializable {

	/**
	 * 
	
	 */

	@EJB
	private DAOManagerAsignatura mAsignatura;

	private List<Asignatura> listaAsignatura;
	private Asignatura asignatura;
	private Asignatura asignaturaEdicion;

	public BeanAsig() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		listaAsignatura = mAsignatura.findAllAsignaturas();
		asignatura = new Asignatura();
		asignaturaEdicion = new Asignatura();
	}

	public void actionListenerInsertarAsignatura() {
		try {
			mAsignatura.insertarEstudiante(asignatura);
			listaAsignatura = mAsignatura.findAllAsignaturas();
			asignatura = new Asignatura();
		JSFUtil.crearMensajeInfo("Creado");;
			JSFUtil.crearMensajeInfo("Estudiante creado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
		}
	}

	public void actionListenerEliminarAsignatura(Asignatura asignatura) {
		mAsignatura.eliminarAignatura(asignatura.getIdAsignatura());
		listaAsignatura = mAsignatura.findAllAsignaturas();
		JSFUtil.crearMensajeInfo("Asignatura eliminada");
	}

	public void actionListenerSeleccionarAsignatura(Asignatura e) {
		asignaturaEdicion = e;
	}

	public void actionListenerActualizarAsignatura() {

		try {
			mAsignatura.actualizarEstudiante(asignaturaEdicion);
			listaAsignatura = mAsignatura.findAllAsignaturas();
			JSFUtil.crearMensajeInfo("Asignatura actualizado");

		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.crearMensajeError(e.getMessage());
			e.printStackTrace();
		}
	}

	public DAOManagerAsignatura getmAsignatura() {
		return mAsignatura;
	}

	public void setmAsignatura(DAOManagerAsignatura mAsignatura) {
		this.mAsignatura = mAsignatura;
	}

	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}

	public void setListaAsignatura(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Asignatura getAsignaturaEdicion() {
		return asignaturaEdicion;
	}

	public void setAsignaturaEdicion(Asignatura asignaturaEdicion) {
		this.asignaturaEdicion = asignaturaEdicion;
	}
	
	
	
	

}

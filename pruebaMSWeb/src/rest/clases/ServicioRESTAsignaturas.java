/**
 * 
 */
package rest.clases;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.core.managers.DAOManagerAsignatura;
import pruebaMSEJB.model.core.entities.Asignatura;

/**
 * @author fedora
 *
 */
@RequestScoped
@Path("asignatura")
@Produces("application/json")
@Consumes("application/json")
public class ServicioRESTAsignaturas {

	@Inject
	private DAOManagerAsignatura mInventario;

	// comentario
	@GET
	@Path(value = "todos")
	public List<Asignatura> findAllAsignatura() {
		return mInventario.findAllAsignaturas();
	}

	@GET
	@Path("{id}")
	public Response getTodo(@PathParam("id") int id) {
		Asignatura todo = mInventario.findByIdApi(id);
		return Response.ok(todo).build();
	}

	/// actualizar
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") int id, Asignatura todo) {
		Asignatura updateTodo = mInventario.findByIdApi(id);
		try {
			updateTodo.setNombreAsignatura(todo.getNombreAsignatura());
			updateTodo.setDescripcionAsignatura(todo.getDescripcionAsignatura());
			updateTodo.setNivel(todo.getNivel());
			mInventario.actualizarEstudiante(updateTodo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().build();
	}

	//// crear
	@POST
	public Response create(Asignatura todo) {
		try {
			mInventario.insertarEstudiante(todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().build();
	}

	/// eliminar
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") int id) {
		mInventario.eliminarAignatura(id);
		return Response.ok().build();
	}

}

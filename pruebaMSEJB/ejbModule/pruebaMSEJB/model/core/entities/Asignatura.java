package pruebaMSEJB.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asignaturas database table.
 * 
 */
@Entity
@Table(name="asignaturas")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignatura")
	private Integer idAsignatura;

	@Column(name="descripcion_asignatura")
	private String descripcionAsignatura;

	private Integer nivel;

	@Column(name="nombre_asignatura")
	private String nombreAsignatura;

	public Asignatura() {
	}

	public Integer getIdAsignatura() {
		return this.idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getDescripcionAsignatura() {
		return this.descripcionAsignatura;
	}

	public void setDescripcionAsignatura(String descripcionAsignatura) {
		this.descripcionAsignatura = descripcionAsignatura;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getNombreAsignatura() {
		return this.nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

}
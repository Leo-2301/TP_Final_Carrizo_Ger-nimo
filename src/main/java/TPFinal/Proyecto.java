package TPFinal;

import java.time.LocalDate;
import java.util.Date;

public class Proyecto {
	private int codigoProyecto;
	private String nombreProyecto;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private Double montoPres;
	
	private Empleado empleado;
	//Constructor Vacio
	public Proyecto() {
		
	}

	//Constructor con parametros
	public Proyecto(int codigoProyecto, String nombreProyecto, LocalDate fechaIni, LocalDate fechaFin, Double montoPres,
			Empleado empleado) {
		super();
		this.codigoProyecto = codigoProyecto;
		this.nombreProyecto = nombreProyecto;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.montoPres = montoPres;
		this.empleado = empleado;
	}

	//Getters and Setters
	public int getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(int codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getMontoPres() {
		return montoPres;
	}

	public void setMontoPres(Double montoPres) {
		this.montoPres = montoPres;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
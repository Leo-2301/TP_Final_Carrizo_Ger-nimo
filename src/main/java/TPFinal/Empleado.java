package TPFinal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import javax.swing.JOptionPane;

public class Empleado {
	private int ndeLegajo;
	private String nombres;
	private String apellidos;
	private int cuit;
	private LocalDate fechaNacimiento;
	private Double sueldo;
	//Constructor vacio
	public Empleado() {
		
	}
	//Constructor con parametros
	public Empleado(int ndeLegajo, String nombres, String apellidos, int cuit, LocalDate fechaNacimiento, Double sueldo) {
		super();
		this.ndeLegajo = ndeLegajo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cuit = cuit;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldo = sueldo;
	}
	//Getters and Setters
	public int getNdeLegajo() {
		return ndeLegajo;
	}
	public void setNdeLegajo(int ndeLegajo) {
		this.ndeLegajo = ndeLegajo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento ) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	
	public long calcularEdad(Empleado emp) {
		//int edad = 0;
		LocalDate fechaActual = LocalDate.now();
		LocalDate nacimiento = emp.getFechaNacimiento();
		//String feAct =(fechaActual);
		long edad= ChronoUnit.YEARS.between((Temporal) nacimiento, fechaActual); 
		return edad;
	}

	
}

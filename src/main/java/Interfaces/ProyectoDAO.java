package Interfaces;

import TPFinal.Empleado;
import TPFinal.Proyecto;

public interface ProyectoDAO {
	void agregarProy(Proyecto proy);
	void eliminarProy(int CodProy);
	void listarProy();
	void agreEmpAProy(Empleado emp);
	void quitarEmpDeProy();
	void listarDatdeProy();
	void calcularTotal();
	void calcElMontEqui();
	void listarPorFecha();
	void MenuProy();
}
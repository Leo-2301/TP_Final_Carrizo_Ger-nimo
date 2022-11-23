package Interfaces;

import TPFinal.Empleado;

public interface EmpleadoDAO {
	void agregarEmp(Empleado emp);
	void eliminarEmp(int dni);
	void actualizarEmp(int nleg);
	void listarEmp();
	void listEmpMayor();
	void listEmpPorSueldo(Double sueldo);
	void buscar(String ape);
	void MenuEmp();
}

package TPFinal;

import javax.swing.JOptionPane;

import Implementacion.ImpleEmpleadoDAO;
import Implementacion.ImpleProyectoDAO;
import Interfaces.EmpleadoDAO;
import Interfaces.ProyectoDAO;


public class Main {
	public static void main(String[] args) {
		EmpleadoDAO empp = new ImpleEmpleadoDAO();
		ProyectoDAO proyy = new ImpleProyectoDAO();
		int option;
		try {
			do {
					String menu = JOptionPane.showInputDialog(
							 "***MENU***"+
							 "\n1. Empleados" +
							 "\n2. Proyectos"+
							 "\n3. Salir");
					 option = Integer.parseInt(menu);
					switch (option) {
					case 1:
						empp.MenuEmp();
						break;
					case 2:
						proyy.MenuProy();
						break;
					case 3:
						break;
					}
				}while (option != 3);
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en Id");
		}
	}
}


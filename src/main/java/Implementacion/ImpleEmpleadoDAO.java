package Implementacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import Interfaces.EmpleadoDAO;
import TPFinal.Empleado;

public class ImpleEmpleadoDAO implements EmpleadoDAO {
	List<Empleado> listEmp = new ArrayList<Empleado>();
	public void agregarEmp(Empleado emp) {
		// TODO Auto-generated method stub
		try {
			emp.setNdeLegajo(Integer.parseInt(JOptionPane.showInputDialog("Num de Legajo: ")));
			emp.setApellidos(JOptionPane.showInputDialog("Ingrese el Apellido/s: "));
			emp.setNombres(JOptionPane.showInputDialog("Ingrese el Nombre/s: "));
			emp.setCuit(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el CUIT: ")));
			emp.setFechaNacimiento(LocalDate.parse(JOptionPane.showInputDialog ("Ingrese la Fecha de Nacimiento: ")));
			emp.setSueldo(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Sueldo: ")));
		
			listEmp.add(new Empleado(emp.getNdeLegajo(),emp.getApellidos() , emp.getNombres(), emp.getCuit(), emp.getFechaNacimiento(), emp.getSueldo()));
			JOptionPane.showMessageDialog(null, "El Empleado " + emp.getApellidos() + " " + emp.getNombres() +" fue agregado.");
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en el campo \nNum. de Legajo \nCUIT \ny Sueldo");
		}
	}

	public void eliminarEmp(int dni) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < listEmp.size(); i++) {
				if (dni == listEmp.get(i).getCuit()) {
					listEmp.remove(listEmp.get(i));
					JOptionPane.showMessageDialog(null, "El Empleado "+ listEmp.get(i).getApellidos() + listEmp.get(i).getNombres() + " fue eliminado con exito");
				}else {
					JOptionPane.showMessageDialog(null, "El empleado no esta registrado o no existe");
				}
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en los campos \nNum. de Legajo");
		}
	}

	public void actualizarEmp(int nleg) {
		// TODO Auto-generated method stub
		try {
		for(Empleado e : listEmp) {
			for (int i = 0; i< listEmp.size(); i++) {
				if (nleg == listEmp.get(i).getNdeLegajo()) {
					int option;
					JOptionPane.showMessageDialog(null, "Empleado a Modificar\n(No puede modificarse el Numero de Legajo)\n" + e.getNdeLegajo()+"\n"+e.getApellidos()+"\n"+e.getNombres()+"\n"+e.getCuit()+"\n"+e.getFechaNacimiento()+"\n"+e.getSueldo());
					do {
						String menu = JOptionPane.showInputDialog(
							 "***Menu Actualizar Empleado***"+
							 "\n1. Modificar Apellido." +
							 "\n2. Modificar Nombre."+
							 "\n3. Modificar CUIT"+
							 "\n4. Modificar Sueldo"+
							 "\n5. Salir");
						option = Integer.parseInt(menu);
						switch (option) {
						case 1:
							e.setApellidos(JOptionPane.showInputDialog("Ingrese nuevo Apellido: "));
							break;
						case 2:
							e.setNombres(JOptionPane.showInputDialog("Ingrese nuevo Nombre: "));
							break;
						case 3: 
							e.setCuit(Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo CUIT: ")));
							break;
						case 4:
							e.setSueldo(Double.parseDouble(JOptionPane.showInputDialog("Ingrese nueva Cantidad del Sueldo: ")));
							break;
						case 5:
							break;
						default:
							JOptionPane.showMessageDialog(null, "Opcion no encontrada!");
							break;
						}
					} while (option != 5);
				}else {
					JOptionPane.showMessageDialog(null, "Empleado no Encontrado.");
				}
			}
		}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en los campos \nId y Año de estreno");
		}
	}

	public void listarEmp() {
		// TODO Auto-generated method stub
		for (Empleado e : listEmp) {
			JOptionPane.showMessageDialog(null,"|  "+ e.getNdeLegajo()+"  |  "+ e.getApellidos()+"  |  "+ e.getNombres()+"  |  "+ e.calcularEdad(e)+"  |");
			}
	}

	public void listEmpMayor() {
		// TODO Auto-generated method stub
		
		try {
			for(Empleado e : listEmp) {
				
			}
		}catch(Exception ex) {
			
		}
	}

	public void listEmpPorSueldo(Double sueldo) {
		// TODO Auto-generated method stub
		try {
			for(Empleado e : listEmp) {
				if(sueldo < e.getSueldo()) {
					JOptionPane.showMessageDialog(null, "|  "+ e.getNdeLegajo()+"  |  "+ e.getApellidos()+"  |  "+ e.getNombres()+"  |  "+ e.calcularEdad(e)+"  |");
				} else {
					JOptionPane.showMessageDialog(null, "No existen empleados que posean un Sueldo que superen al Sueldo ingresado.");
				}
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Inesperado");
		}
	}

	public void buscar(String ape) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for (Empleado e : listEmp) {
			if (ape == e.getApellidos()) {
				bandera = true;
				JOptionPane.showMessageDialog(null, "Empleado Encontrado\n"+e.getNdeLegajo()+"\n"+e.getApellidos()+"\n"+e.getNombres()+"\n"+e.getFechaNacimiento()+"\n"+e.getSueldo());
			}
		}
		if(bandera == false) {
			JOptionPane.showMessageDialog(null, "Empleado no encontrado");
		}
	}
	
	public void MenuEmp() {
		EmpleadoDAO empl = new ImpleEmpleadoDAO();
		Empleado e = new Empleado();
		int option;
		try {
			
		do {
			String menu = JOptionPane.showInputDialog(
						"***MENU***"+
						 "\n1.Agregar Empleado." +
						 "\n2.Eliminar Empleado."+
						 "\n3.Modificar Empleado."+
						 "\n4.Listar Empleados"+ 
						 "\n5.Mostrar el empleado de Mayor Edad." + 
						 "\n6.Listar empleados que superen a un determinado sueldo básico ingresado." + 
						 "\n7.Buscar empleado por DNI o por Apellido." + 
						 "\n8.Salir.");
				 option = Integer.parseInt(menu);
				switch (option) {
				case 1:
					empl.agregarEmp(e);
					break;
				case 2:
					int eli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el CUIT del Empleado"+ "\nque desea eliminar: "));
					empl.eliminarEmp(eli);
					break;
				case 3:
					int actu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Num de Legajo del empleado que desea actualizar: "));
					empl.actualizarEmp(actu);
					break;
				case 4:
					empl.listarEmp();
					break;
				case 5:
					//
					break;
				case 6:
					Double suel = Double.parseDouble(JOptionPane.showInputDialog("Ingrese un monto: "));
					empl.listEmpPorSueldo(suel);
					break;
				case 7:
					String busc = JOptionPane.showInputDialog("Ingrese el Apellido del Empleado que busca: ");
					empl.buscar(busc);
					break;
				case 8:
					break;
				}
			}while (option != 7);
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros, entre el 1 y 8");
		}
	}
}

package Implementacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Interfaces.ProyectoDAO;
import TPFinal.Empleado;
import TPFinal.Proyecto;

public class ImpleProyectoDAO implements ProyectoDAO {
	
	List<Empleado> listEmp = new ArrayList<Empleado>();
	List<Proyecto> listProy = new ArrayList<Proyecto>();
	List<Proyecto> listEmpProy = new ArrayList<Proyecto>();
	
	public void agregarProy(Proyecto proy) {
		// TODO Auto-generated method stub
		try {
			proy.setCodigoProyecto(Integer.parseInt(JOptionPane.showInputDialog("Num de Legajo: ")));
			proy.setNombreProyecto(JOptionPane.showInputDialog("Ingrese el Apellido/s: "));
			proy.setFechaIni(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la Fecha de Inicio: ")));
			proy.setFechaFin(LocalDate.parse(JOptionPane.showInputDialog("Ingrese la Fecha Final: ")));
			proy.setMontoPres(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Monto: ")));
		
			listProy.add(new Proyecto(proy.getCodigoProyecto(),proy.getNombreProyecto() , proy.getFechaIni(), proy.getFechaFin(), proy.getMontoPres(), null));
			JOptionPane.showMessageDialog(null, "El Proyecto " + proy.getNombreProyecto() + " fue agregado.");
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en el campo \nNum. de Legajo \nCUIT \ny Sueldo");
		}
	}

	public void eliminarProy(int CodProy) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < listProy.size(); i++) {
				if (CodProy == listProy.get(i).getCodigoProyecto()) {
					listProy.remove(listProy.get(i));
					JOptionPane.showMessageDialog(null, "El Proyecto "+ listProy.get(i).getNombreProyecto() +" fue eliminado con exito");
				}else {
					JOptionPane.showMessageDialog(null, "El Proyecto no esta registrado o no existe");
				}
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en los campos \nCodigo de Proyecto");
		}
	}

	public void listarProy() {
		// TODO Auto-generated method stub
		for (Proyecto p : listProy) {
			JOptionPane.showMessageDialog(null,"|  "+ p.getNombreProyecto()+"  |  "+ p.getFechaIni()+"  |  "+ p.getFechaFin()+"  |  "+ p.getMontoPres()+"  |");
			}
	}

	public void agreEmpAProy(int ndeLeg) {
		// TODO Auto-generated method stub 
		//List<Proyecto> listEmpProy = new ArrayList<Proyecto>();
		try {
			Empleado emp = new Empleado();
			for (int j = 0; j < listProy.size(); j++) {
				for (int i = 0; i < listEmpProy.size(); i++) {
					if(ndeLeg == listEmp.get(i).getNdeLegajo()) {
						emp.setNdeLegajo(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Num de Legajo del Empleado: ")));
					}
				}
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros en los campos \nCodigo de Proyecto");
		}
	}

	public void quitarEmpDeProy() {
		// TODO Auto-generated method stub
		
	}

	public void listarDatdeProy() {
		// TODO Auto-generated method stub
		
	}

	public void calcularTotal( ) {
		// TODO Auto-generated method stub
		try {
			double total = 0.00;
			for(Proyecto proy : listProy) {
				total += proy.getMontoPres();
			}
			JOptionPane.showMessageDialog(null, "El monto total es: "+ total);
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Error inesperado.");
		}
	}

	public void calcElMontEqui() {
		// TODO Auto-generated method stub
		
	}

	public void listarPorFecha() {
		// TODO Auto-generated method stub
		
	}

	
	public void MenuProy() {
		ProyectoDAO proye = new ImpleProyectoDAO();
		Proyecto p = new Proyecto();
		int option;
		try {
		do {
			String menu = JOptionPane.showInputDialog(
						"***MENU Proyectos***"+
						 "\n1.Agregar un nuevo proyecto." +
						 "\n2.Eliminar un proyecto."+
						 "\n3.Listar proyectos."+
						 "\n4.Agregar empleado a un proyecto."+ 
						 "\n5.Quitar empleado de un proyecto." + 
						 "\n6.Listar datos de un proyecto." + 
						 "\n7.Calcular el total de montos destinados a proyectos." +
						 "\n8.Calcular el monto que recibe cada participante de un proyecto."+
						 "\n9.Listar proyectos por rangos de fechas"+
						 "\n10.Salir.");
				 option = Integer.parseInt(menu);
				switch (option) {
				case 1:
					proye.agregarProy(p);;
					break;
				case 2:
					int elim = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el CUIT del Empleado"+ "\nque desea eliminar: "));
					proye.eliminarProy(elim);
					break;
				case 3:
					proye.listarProy();
					break;
				case 4:
				    //
					break;
				case 5:
					//
					break;
				case 6:
					//
					break;
				case 7:
					proye.calcularTotal();
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				}
			}while (option != 10);
		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos enteros, entre el 1 y 8");
		}
	}
}

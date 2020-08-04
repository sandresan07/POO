
package vistacontrol;

import modelo.Alumno;

public class Principal {
    public static void main(String[] args) {
       Alumno alumno = new Alumno();
       Alumno alumno1 = new Alumno(2,"2015144365","Jorge Gonzales");
       //CLASE OBJETO  CONSTRUCTOR
       
       //Ingresar valores al objeto alumno
       alumno.setIdalumno(1);
       alumno.setCodigo("2015844858");
       alumno.setNombre("Andres Eduardo");
       
       //Obtener y mostrar valores del objeto alumno
        System.out.println("objeto: alumno");
        System.out.println("ID: " + alumno.getIdalumno());
        System.out.println("Codigo: " + alumno.getCodigo());
        System.out.println("Nombre: " + alumno.getNombre());
        //Obtener y mostrar valores del objeto alumno
        System.out.println("objeto: alumno1");
        System.out.println("ID: " + alumno1.getIdalumno());
        System.out.println("Codigo: " + alumno1.getCodigo());
        System.out.println("Nombre: " + alumno1.getNombre());
    }
}

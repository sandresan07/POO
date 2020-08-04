
package vistacontrol;
import java.util.ArrayList;
import modelo.Cliente;
import utils.Leer;
/*
MENU PRINCIPAL
1. Agregar Cliente
2. Eliminar Cliente
3. Editar Cliente
4. Listar Cliente
5. Salir
 */
public class Index {
    //Variables Globales
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private static int idcliente=-1;
    //Metodos del proyecto
    public static void cargarDataSintetica(){
        Cliente cliente0 = new Cliente(0, "Diyei Mario", "Mostoles Efece", "10330098", "10/12/98");
        clientes.add(cliente0);
        
        Cliente cliente1 = new Cliente(0, "Emsi Mochila", "Supremacia", "10345098", "10/12/98");
        clientes.add(cliente1);
                
        Cliente cliente2 = new Cliente(0, "Kunsito", "Awero", "10314478", "10/12/98");
        clientes.add(cliente2);
        
        Cliente cliente3 = new Cliente(0, "Pepe", "Gonzales", "15330098", "10/12/98");
        clientes.add(cliente3);
    }
    public static void agregarcliente(){
        String nombre;
        String apellidos;
        String dni;
        String f_nacimiento;
        
        System.out.println("Agregar Cliente");
        System.out.print("Nombre: ");
        nombre=Leer.cadena();
        System.out.print("Apellidos: ");
        apellidos=Leer.cadena();
        do{
            System.out.print("DNI: ");
            dni=Leer.cadena();
        }while(dniValido(dni)==false || esNumero(dni)==false || dniUnico(dni)==false);
        
        System.out.print("Fecha de nacimiento: ");
        f_nacimiento=Leer.cadena();
        idcliente++;
        Cliente cliente = new Cliente(idcliente, nombre, apellidos, dni, f_nacimiento);
        clientes.add(cliente);
        System.out.println("Resultado: Se agrego un cliente con exito...");
        
    }
    public static boolean dniValido(String dni){
        boolean resultado;
        //tamaño 8;
        if(dni.length()==8){
            resultado = true;
        }else{
            error(2);
            resultado=false;
        }
        return resultado;
    }
    public static boolean esNumero(String cadena){
        boolean resultado;
        try{
            //Para determinar si esta compuesto por digitos
            //se debe poder convertir String a double
            Double.parseDouble(cadena);
            resultado =true;
        }catch(NumberFormatException nfe){
            error(3);
            resultado=false;
        }
        return resultado;
    }
    public static boolean dniUnico(String dni){
        boolean resultado= true;
        for (Cliente cliente : clientes) {
            if(cliente.getDni().equals(dni)){
               error(4);
            resultado=false; 
            }
            
        }
       return resultado;
    }
    public static void eliminarcliente(){
        System.out.println("Eliminar Cliente");
        int elemento;
        listarcliente();
        System.out.print("Indique la posicion del cliente a eliminar: ");
        elemento = Leer.entero();
        elemento--;
        clientes.remove(elemento);
        System.out.println("Se elimino el cliente con exito...");
    }
    public static void editarcliente(){
        System.out.println("Editar Cliente");
        int elemento;
        listarcliente();
        System.out.print("Indique la posicion del cliente a editar: ");
        elemento = Leer.entero();
        elemento--;
        System.out.println("Resultado: " + clientes.get(elemento).getObtenerNombreCompleto());
        System.out.print("Nuevo Nombre: ");
        clientes.get(elemento).setNombre(Leer.cadena());
        System.out.print("Nuevos Apellidos: ");
        clientes.get(elemento).setApellidos(Leer.cadena());
        String dni;
        do{
            System.out.print("Nuevo DNI: ");
            dni = Leer.cadena();
        }while(dniValido(dni)==false || esNumero(dni)==false || dniUnico(dni)==false);       
        clientes.get(elemento).setDni(Leer.cadena());
        System.out.print("Nueva Fecha de Nacimiento: ");
        clientes.get(elemento).setF_nacimiento(Leer.cadena());
        System.out.println("Editado con exito...");
    }
    public static void listarcliente(){
        System.out.println("Listar Clientes");
        System.out.println("N°\tDni\tF_Nacimiento\tApellidos\tNombres");
        int num=0;
        for (Cliente cliente :clientes) {
        num ++;
            System.out.println(num+"\t" + cliente.getDni()+"\t"+cliente.getF_nacimiento()+"\t"+cliente.getApellidos()+"\t"+cliente.getNombre());
        }
    }
    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("Opcion Incorrecta");
                break;
            case 2:
                System.out.println("DNI debe tener 8 digitos");
                break;
            case 3:
                System.out.println("DNI debe ser digitos");
                break;
            case 4:
                System.out.println("El DNI ingresado pertenece a otra persona");
            default:
                System.out.println("Error");
                
        }
        
    }
    public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Eliminar Cliente");
        System.out.println("3. Editar Cliente");
        System.out.println("4. Listar Cliente");
        System.out.println("5. Salir");
        System.out.print("Digice una opcion [1-5]: ");
    }
    public static void inicio(){
        cargarDataSintetica();
        int opcion;
        do{
            menu();
            opcion = Leer.entero();
            switch(opcion){
                case 1:
                    agregarcliente();
                    break;
                case 2:
                    eliminarcliente();
                    break;
                case 3:
                    editarcliente();
                    break;
                case 4:
                    listarcliente();
                    break;
                case 5:
                    salir();
                    break;
                default:
                    error(1);
            }
        }while(opcion!=5);
    }
    public static void main(String[] args) {
        inicio();
    }
    
}

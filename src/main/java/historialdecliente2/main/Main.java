package historialdecliente2.main;

import historialdecliente1.clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List <Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Buscar clientes");
            System.out.println("4. Mostrar los clientes");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: \n");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    try{
                        System.out.println("Ingrese el nombre del cliente");
                        String nombre = scanner.next();
                        if(!validar(nombre, "[a-zA-Z]{1,200}")){
                            System.out.println("Solo se permiten letras para este campo");
                            break;
                        }
                        System.out.print("Ingrese la cedula del cliente: ");
                        String cedula = scanner.next();
                        if(!validar(cedula,"\\d{6,10}")) {
                            System.out.println("Para este campo solo son permitidos numeros ");
                            break;
                        }


                        String res = guardarCliente(nombre,cedula);
                        System.out.println(res);
                        break;
                    }catch (Exception e){
                        System.err.println(e);
                    }
                    break;
            case 2:
                    try {
                        if( listaClientes.size() > 0){
                            System.out.println("Ingrese el numero de cedula del cliente que desea eliminar");
                            String cedulaBorrar = scanner.next();
                            String resBo = eliminarCliente(cedulaBorrar);
                            System.out.println(resBo);
                            break;
                        }else {
                            System.out.println("Aun no hay clientes registrados");
                            break;
                        }
                    }catch (Exception e){
                        System.err.println(e);
                    }
                    break;
                case 3:
                    try {
                        if(listaClientes.size() > 0){
                        //Ver por que solo esta trayendo el primer cliente nada mas
                            System.out.println("Ingresa la cedula del cliente que deseas buscar");
                            String clienteBuscar = scanner.next();
                            String resBus = buscarCliente(clienteBuscar);
                            System.out.println(resBus);
                        }else {
                           // System.out.println("Primero debes registrar clientes");
                        }
                    }catch (Exception e){
                        System.err.println(e);
                    }
                    break;
                case 4:
                    try {
                        //Me falta hacer lo de ordenar alfabeticamente
                        if(listaClientes.size() == 0){
                            System.out.println("Aun no hay clientes registrados");
                            break;
                        }else {
                            System.out.println(mostarTodosLosClientes());
                        }
                    }catch (Exception e){
                        System.err.println(e);
                    }
                    break;
                default:
                    if (opcion != 5)
                        System.out.println("Vuelve pronto");
                    break;
            }
        }while (opcion!=5);
    }
    public static String guardarCliente(String nombre, String cedula){
        for (Cliente clienteNuev:listaClientes) {
            if(clienteNuev.getCedulaCliente().equals(cedula)) {
                return "La cedula " + cedula + " Ya se encuentra registrada";
            }
            break;
        }

        Cliente cliente1 = new Cliente(nombre,cedula);
        listaClientes.add(cliente1);
        return "Cliente guardado con exito";
    }
    public static String eliminarCliente(String cedulaBorrar){
        for (Cliente clienteBorrar:listaClientes) {
            if (clienteBorrar.getCedulaCliente().equals(cedulaBorrar)){
                listaClientes.remove(clienteBorrar);
                return  "El cliente con cédula " + clienteBorrar.getCedulaCliente() + " ha sido eliminado de la lista";
            }
        }
        return "El cliente aun no se encuentra registrado";
    }
    public static String buscarCliente(String clienteBuscar){

        for (Cliente cliente:listaClientes) {
            if (cliente.getCedulaCliente().equals(clienteBuscar)) {
                return " Nombre: "+cliente.getNombreCliente() + " Cedula: "+cliente.getCedulaCliente();
            }
        }
        return "Este cliente aun no esta registrado";
    }

    public static String mostarTodosLosClientes(){
        try {
            //Me falta hacer lo de ordenar alfabeticamente
            if(listaClientes.size() == 0){
                System.out.println("Aun no hay clientes registrados");
            }else {
                int con = 0;
                for (Cliente clientes : listaClientes) {
                    System.out.println("Cliente numero: "+con+ " Nombre: "+clientes.getNombreCliente()+ " y su cedula es: "+clientes.getCedulaCliente());
                    con ++;
                }
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return "";
    }

    public static boolean validar(String str, String er) {
        // Expresión regular para validar que el string solo contiene letras
        String regex = er;

        // Crear el objeto Pattern y Matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // Verificar si el string cumple con la expresión regular
        return matcher.matches();
    }
}

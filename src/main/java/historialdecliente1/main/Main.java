package historialdecliente1.main;

import historialdecliente1.clases.Cliente;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[4];
        Scanner scanner = new Scanner(System.in);
        int indiceCliente = 0;
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

            switch (opcion) {
                case 1:
                    if (clientes.length < 10){
                        System.out.print("Ingrese el nombre del cliente: ");
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
                        clientes[indiceCliente] = new Cliente(nombre, cedula);
                        indiceCliente++;

                        System.out.println("Cliente guardado correctamente.");
                        break;
                    }else {
                        System.out.println("Ya tienes 10 clientes tienes que eliminar uno");
                        break;
                    }
                case 2:
                    if(clientes.length < 1){
                        System.out.println("No hay clientes aun");
                        break;
                    }
                    System.out.print("Ingrese el cliente a eliminar: ");
                    int datoEliminar = scanner.nextInt();
                    if (datoEliminar > clientes.length){
                        System.out.println("Esta posicion es invalida");
                        break;
                    }
                    if(clientes[datoEliminar]!=null){
                        Cliente[] cl = new Cliente[clientes.length];
                        int j = 0;
                        for (int i=0; i<clientes.length; i++){
                            if (i == datoEliminar) {
                                continue;
                            }else {
                                cl[j] = clientes[i];
                                j++;
                            }
                        }
                        clientes=cl;
                        if(clientes.length < 4){
                            do {
                                clientes[clientes.length] = new Cliente();
                            }while (clientes.length < 4);
                        }
                        System.out.println("Cliente eliminado correctamente");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la cedula del cliente: ");
                    String ced = scanner.next();

                    for (int i = 0; i < clientes.length; i++){
                        if (clientes[i].getCedulaCliente().equals(ced)){
                            System.out.println("Cliente: "+ i + " Se llama "+ clientes[i].getNombreCliente()+ " Cedula: "+clientes[i].getCedulaCliente());
                            break;
                        }
                    }
                    //System.out.println("No se encontro un cliente con esta cedula");
                    break;
                case 4:
                    for (int i = 0; i < clientes.length; i++) {
                        if(clientes[i]!=null){
                            System.out.println("Nombre: "+clientes[i].getNombreCliente()+" cedula: "+clientes[i].getCedulaCliente());
                        }
                    }
                    break;
                default:
                    if (opcion != 5)
                        System.out.println("Vuelve pronto");
                    break;
            }
        } while (opcion != 5);
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



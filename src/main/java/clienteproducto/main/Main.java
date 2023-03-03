package clienteproducto.main;

import clienteproducto.clases.ClientePr;
import clienteproducto.clases.ProductoCliente;
import clienteproducto.clases.Producto;
import clienteproducto.clases.ProductoPorCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Cristian, subi este taller porque cuando lo reestructuramos se me daño el otro, entonces este funcioan mas.

public class Main {
    static List<Producto> listProductos = new ArrayList<>();
    static List<ProductoPorCliente> listProductoCliente = new ArrayList<>();

    public static void main(String[] args) {
        List<ClientePr> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int menuPrincipal;
        int segundoMenu;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Menu de clientes");
            System.out.println("2. Menu de productos");
            System.out.println("3. Terminar");
            System.out.print("Selecciona una opción: ");
            menuPrincipal = scanner.nextInt();

            switch (menuPrincipal) {
                case 1:
                    do {
                        //menu 1
                        System.out.println("MENU");
                        System.out.println("1. Insertar cliente");
                        System.out.println("2. Eliminar cliente");
                        System.out.println("3. Buscar clientes");
                        System.out.println("4. Mostrar los clientes");
                        System.out.println("5. Modificar cliente");
                        System.out.println("6. Agregar un producto");
                        System.out.println("7. Aplicar descuento por");
                        System.out.println("8. Salir");
                        System.out.print("Ingrese una opción: \n");
                        segundoMenu = scanner.nextInt();

                        switch (segundoMenu) {
                            case 1:
                                System.out.println("Ingrese el nombre del cliente");
                                String nombre = scanner.next();
                                if (!validar(nombre, "[a-zA-Z]{1,200}")) {
                                    System.out.println("Solo se permiten letras para este campo");
                                    break;
                                }
                                System.out.print("Ingrese la cedula del cliente: ");
                                String cedula = scanner.next();
                                if (!validar(cedula, "\\d{1,10}")) {
                                    System.out.println("Para este campo solo son permitidos numeros ");
                                    break;
                                }
                                String res = ProductoCliente.guardarCliente(listaClientes, nombre, cedula);
                                System.out.println(res);
                                break;
                            case 2:
                                try {
                                    if (listaClientes.size() > 0) {
                                        System.out.println("Ingrese el numero de cedula del cliente que desea eliminar");
                                        String cedulaBorrar = scanner.next();
                                        String resBo = ProductoCliente.eliminarCliente(listaClientes, cedulaBorrar);
                                        System.out.println(resBo);
                                        break;
                                    } else {
                                        System.out.println("Aun no hay clientes registrados");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.err.println(e);
                                }
                                break;
                            case 3:
                                try {
                                    if (listaClientes.size() > 0) {
                                        //Ver por que solo esta trayendo el primer cliente nada mas
                                        System.out.println("Ingresa la cedula del cliente que deseas buscar");
                                        String cedulaBuscar = scanner.next();

                                        String resBusc = ProductoCliente.buscarCliente(listaClientes, cedulaBuscar);
                                        System.out.println(resBusc);
                                        break;
                                    } else {
                                        // System.out.println("Primero debes registrar clientes");
                                    }
                                } catch (Exception e) {
                                    System.err.println(e);
                                }
                                break;
                            case 4:
                                try {

                                    if (listaClientes.size() == 0) {
                                        System.out.println("Aun no hay clientes registrados");
                                        break;
                                    } else {
                                        String resMos = ProductoCliente.mostrarClientes(listaClientes, listProductoCliente);
                                        System.out.println(resMos);
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.err.println(e);
                                }
                                break;
                            case 5:
                                if (listaClientes.size() == 0) {
                                    System.out.println("Aun no hay clientes registrados");
                                    break;
                                } else {
                                    System.out.println("Cedula del cliente a modificar");
                                    String cedulaModif = scanner.next();

                                    for (ClientePr clientes : listaClientes) {
                                        if (clientes.getCedula().equals(cedulaModif)) {
                                            System.out.println("Ingresa el nuevo nombre");
                                            String nuevoNombre = scanner.next();

                                            String resModClie = ProductoCliente.modificarCliente(listaClientes, cedulaModif, nuevoNombre);
                                            System.out.println(resModClie);
                                        }
                                        break;
                                    }
                                }
                                break;
                            case 6:
                                if (listaClientes.size() == 0 && listProductos.size() == 0) {
                                    System.out.println("Aun no hay clientes ni productos registrados");
                                    break;
                                } else {
                                    for (ClientePr clientes : listaClientes) {
                                        System.out.println("A cual cliente le vas a asignar la compra: " + clientes.getNombre());
                                    }

                                    for (Producto productos : listProductos) {
                                        System.out.println("Que producto deseas comprar: " + productos.getNombreProducto());
                                    }

                                    System.out.println("Nombre del cliente al que se le va a asignar el producto");
                                    String nomClientePro = scanner.next();

                                    System.out.println("Nombre del producto");
                                    String nomProAgre = scanner.next();

                                    String resClie = ProductoCliente.aggProdClien(listProductoCliente, nomClientePro, nomProAgre);
                                    System.out.println(resClie);
                                }
                                break;
                            case 7:

                                break;
                            case 8:
                                System.out.println("Saliendo del menu de productos...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (segundoMenu != 8);
                    break;
                case 2:
                    do {
                        System.out.println("Menú");
                        System.out.println("1. Añadir producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Mostrar productos");
                        System.out.println("4. Salir");
                        segundoMenu = scanner.nextInt();

                        switch (segundoMenu) {
                            case 1:
                                try {
                                    System.out.println("Ingresa el nombre del producto");
                                    String nombreProducto = scanner.next();
                                    System.out.println("Ingresa el precio del producto");
                                    Float precioProducto = scanner.nextFloat();

                                    String resGua = ProductoCliente.agregarProducto(listProductos, nombreProducto, precioProducto);
                                    System.out.println(resGua);

                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                break;
                            case 2:
                                if (listProductos.size() > 0) {
                                    System.out.println("Ingresa el nombre del producto que deseas eliminar");
                                    String proEliminar = scanner.next();

                                    String resELim = ProductoCliente.eliminarProducto(listProductos, proEliminar);
                                    System.out.println(resELim);
                                } else {
                                    System.out.println("Aun no hay productos registrados");
                                }
                                break;
                            case 3:
                                String resMostra = ProductoCliente.mostrarProductos(listProductos);
                                System.out.println(resMostra);
                                break;
                            case 0:
                                System.out.println("Saliendo del programa...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (segundoMenu != 4);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (menuPrincipal != 3);
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

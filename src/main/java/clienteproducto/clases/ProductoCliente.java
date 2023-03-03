package clienteproducto.clases;

import java.util.List;

public class ProductoCliente extends ClientePr{


    public ProductoCliente(String nombre, String cedula) {
        super(nombre, cedula);
    }

    /*public static String agregarProdCliente(String nombreProAgg){
                Producto proAggCli = new Producto(nombreProAgg);
                listProCliente.add(proAggCli);

                return "Producto agregado a tu lista";
            }*/
    public static String aggProdClien(List<ProductoPorCliente>productoPorClienteList, String nombreCliente, String nombreProducto){
        ProductoPorCliente prodAgg = new ProductoPorCliente(nombreCliente, nombreProducto);
        productoPorClienteList.add(prodAgg);
        return "El producto a sido agregado a tu lista";
    }
    public static String mostrarProductos(List<Producto>productosL){
        for (Producto productos : productosL) {
            return "Nombre: " + productos.getNombreProducto() + " Precio: " + productos.getPrecioProducto();
        }
        return "";
    }

    public static String agregarProducto(List<Producto> listclientes, String nombreProducto, Float precioProducto) {
        Producto producto1 = new Producto(nombreProducto, precioProducto);
        listclientes.add(producto1);
        return "Producto guardado con exito";
    }

    public static String eliminarProducto(List<Producto>listProductos, String prodElimiar){
        for (Producto producto:listProductos) {
            if(producto.equals(prodElimiar));
            return "El producto: "+prodElimiar +" a sido eliminado con exito";
        }
        return "Este producto no esta registrado";
    }
    public static String modificarCliente(List<ClientePr>listClientes, String cedulaBus, String nuevoNombre){
        for (ClientePr clientes:listClientes) {
            if (clientes.getCedula().equals(cedulaBus)){
                clientes.setNombre(nuevoNombre);

                return "El nuevo nombre del cliente con cedula "+clientes.getCedula() +" es: "+clientes.getNombre();
            }
            break;
        }
        return "cliente";
    }
    public static String mostrarClientes(List<ClientePr>listaClientes, List<ProductoPorCliente>productoPorClienteList){
        //Me falta hacer lo de ordenar alfabeticamente
        if (listaClientes.size() == 0) {
            return  "Aun no hay clientes registrados";
        } else {
            int con = 0;

            for (ClientePr clientes : listaClientes) {
                con++;
                System.out.println("Cliente numero: " + con + " Nombre: " + clientes.getNombre() + " y su cedula es: "+clientes.getCedula());
            }
        }
        return "Clientes";
    }

    public static String buscarCliente(List<ClientePr>listaClientes, String cedulaBuscar){
    int conBus = 0;
    for (ClientePr cliente : listaClientes) {
        if (cliente.getCedula().equals(cedulaBuscar)) {
            conBus++;
            return  "Cliente numero " + conBus + " Nombre: " +cliente.getNombre()+  " Cedula: " + cliente.getCedula();
        }
    }
    if (conBus == 0) {
        return  "No hay un cliente registrado con esta cedula";
    }
    return "cliente<";
    }
    public static String eliminarCliente(List<ClientePr>listaClientes, String cedulaBorrar){
        for (ClientePr clienteBorrar:listaClientes) {
            if (clienteBorrar.getCedula().equals(cedulaBorrar)){
                listaClientes.remove(clienteBorrar);
                return  "El cliente con cédula " + clienteBorrar.getCedula() + " ha sido eliminado de la lista";
            }
        }
        return "El cliente aun no se encuentra registrado";
    }
    public static String guardarCliente(List<ClientePr>listaClientes , String nombre, String cedula){
        for (ClientePr clienteNuev:listaClientes) {
            if(clienteNuev.getCedula().equals(cedula)) {
                return "La cedula " + cedula + " Ya se encuentra registrada";
            }
            break;
        }
        ClientePr clien = new ClientePr(nombre,cedula);
        listaClientes.add(clien);
        return "Cliente guardado con exito";
    }

}

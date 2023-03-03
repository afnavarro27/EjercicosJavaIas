package clienteproducto.clases;

public class ProductoPorCliente extends ClientePr{
    private String nombreProducto;
    public ProductoPorCliente(String nombre, String cedula) {
        super(nombre, cedula);
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
package historialdecliente2.Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String cedula;

    List <Cliente> listaClientes = new ArrayList<>();
    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


}

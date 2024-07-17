package modelo;

public class Usuario {
    private String cedula;
    private String nombre;

    public Usuario(String cedula, String nombre) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }
}
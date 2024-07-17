package modelo;

public class Recinto {
    private String nombre;
    private String canton;
    private String provincia;

    public Recinto(String nombre, String canton, String provincia) {
        this.nombre = nombre;
        this.canton = canton;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCanton() {
        return canton;
    }

    public String getProvincia() {
        return provincia;
    }
}
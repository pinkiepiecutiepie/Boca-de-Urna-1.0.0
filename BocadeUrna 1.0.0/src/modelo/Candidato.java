package modelo;

public class Candidato {
    private String nombre;
    private Partido partido;
    private String provincia;

    public Candidato(String nombre, Partido partido, String provincia) {
        this.nombre = nombre;
        this.partido = partido;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public Partido getPartido() {
        return partido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
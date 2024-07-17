package modelo;

public class Voto {
    private String cedula;
    private Candidato candidato;
    private Recinto recinto;

    public Voto(String cedula, Candidato candidato, Recinto recinto) {
        this.cedula = cedula;
        this.candidato = candidato;
        this.recinto = recinto;
    }

    public String getUsuario() {
        return cedula;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public Recinto getRecinto() {
        return recinto;
    }
}
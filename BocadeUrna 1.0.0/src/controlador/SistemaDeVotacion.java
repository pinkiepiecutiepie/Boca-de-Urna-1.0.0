package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelo.Candidato;
import modelo.Partido;
import modelo.Recinto;
import modelo.Voto;

public class SistemaDeVotacion {
    private List<Candidato> candidatos;
    private List<Voto> votos;
    private Map<String, Partido> partidos;
    private List<Recinto> recintos;

    public SistemaDeVotacion() {
        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();
        this.partidos = new HashMap<>();
        this.recintos = new ArrayList<>();
        agregarRecintos();
    }
    
    private void agregarRecintos() {
        recintos.add(new Recinto("Cuenca", "Cuenca", "Azuay"));
        recintos.add(new Recinto("Gualaceo", "Gualaceo", "Azuay"));
        recintos.add(new Recinto("Paute", "Paute", "Azuay"));

        recintos.add(new Recinto("Guaranda", "Guaranda", "Bolívar"));
        recintos.add(new Recinto("San Miguel", "San Miguel", "Bolívar"));
        recintos.add(new Recinto("Chillanes", "Chillanes", "Bolívar"));

        recintos.add(new Recinto("Azogues", "Azogues", "Cañar"));
        recintos.add(new Recinto("Biblián", "Biblián", "Cañar"));
        recintos.add(new Recinto("La Troncal", "La Troncal", "Cañar"));

        recintos.add(new Recinto("Tulcán", "Tulcán", "Carchi"));
        recintos.add(new Recinto("Mira", "Mira", "Carchi"));
        recintos.add(new Recinto("San Gabriel", "San Gabriel", "Carchi"));

        recintos.add(new Recinto("Riobamba", "Riobamba", "Chimborazo"));
        recintos.add(new Recinto("Guano", "Guano", "Chimborazo"));
        recintos.add(new Recinto("Chambo", "Chambo", "Chimborazo"));

        recintos.add(new Recinto("Latacunga", "Latacunga", "Cotopaxi"));
        recintos.add(new Recinto("Saquisilí", "Saquisilí", "Cotopaxi"));
        recintos.add(new Recinto("Pujilí", "Pujilí", "Cotopaxi"));

        recintos.add(new Recinto("Machala", "Machala", "El Oro"));
        recintos.add(new Recinto("Pasaje", "Pasaje", "El Oro"));
        recintos.add(new Recinto("Santa Rosa", "Santa Rosa", "El Oro"));

        recintos.add(new Recinto("Esmeraldas", "Esmeraldas", "Esmeraldas"));
        recintos.add(new Recinto("Atacames", "Atacames", "Esmeraldas"));
        recintos.add(new Recinto("Quinindé", "Quinindé", "Esmeraldas"));

        recintos.add(new Recinto("Puerto Baquerizo Moreno", "Puerto Baquerizo Moreno", "Galápagos"));
        recintos.add(new Recinto("Puerto Ayora", "Puerto Ayora", "Galápagos"));
        recintos.add(new Recinto("Puerto Villamil", "Puerto Villamil", "Galápagos"));

        recintos.add(new Recinto("Guayaquil", "Guayaquil", "Guayas"));
        recintos.add(new Recinto("Daule", "Daule", "Guayas"));
        recintos.add(new Recinto("Samborondón", "Samborondón", "Guayas"));

        recintos.add(new Recinto("Ibarra", "Ibarra", "Imbabura"));
        recintos.add(new Recinto("Otavalo", "Otavalo", "Imbabura"));
        recintos.add(new Recinto("Cotacachi", "Cotacachi", "Imbabura"));

        recintos.add(new Recinto("Loja", "Loja", "Loja"));
        recintos.add(new Recinto("Catamayo", "Catamayo", "Loja"));
        recintos.add(new Recinto("Macará", "Macará", "Loja"));

        recintos.add(new Recinto("Babahoyo", "Babahoyo", "Los Ríos"));
        recintos.add(new Recinto("Quevedo", "Quevedo", "Los Ríos"));
        recintos.add(new Recinto("Vinces", "Vinces", "Los Ríos"));

        recintos.add(new Recinto("Portoviejo", "Portoviejo", "Manabí"));
        recintos.add(new Recinto("Manta", "Manta", "Manabí"));
        recintos.add(new Recinto("Chone", "Chone", "Manabí"));

        recintos.add(new Recinto("Macas", "Macas", "Morona Santiago"));
        recintos.add(new Recinto("Gualaquiza", "Gualaquiza", "Morona Santiago"));
        recintos.add(new Recinto("Sucúa", "Sucúa", "Morona Santiago"));

        recintos.add(new Recinto("Tena", "Tena", "Napo"));
        recintos.add(new Recinto("Archidona", "Archidona", "Napo"));
        recintos.add(new Recinto("El Chaco", "El Chaco", "Napo"));

        recintos.add(new Recinto("Puerto Francisco de Orellana", "Puerto Francisco de Orellana", "Orellana"));
        recintos.add(new Recinto("La Joya de los Sachas", "La Joya de los Sachas", "Orellana"));
        recintos.add(new Recinto("El Coca", "El Coca", "Orellana"));

        recintos.add(new Recinto("Puyo", "Puyo", "Pastaza"));
        recintos.add(new Recinto("Mera", "Mera", "Pastaza"));
        recintos.add(new Recinto("Santa Clara", "Santa Clara", "Pastaza"));

        recintos.add(new Recinto("Quito", "Quito", "Pichincha"));
        recintos.add(new Recinto("Cayambe", "Cayambe", "Pichincha"));
        recintos.add(new Recinto("Machachi", "Machachi", "Pichincha"));

        recintos.add(new Recinto("La Libertad", "La Libertad", "Santa Elena"));
        recintos.add(new Recinto("Salinas", "Salinas", "Santa Elena"));
        recintos.add(new Recinto("Santa Elena", "Santa Elena", "Santa Elena"));

        recintos.add(new Recinto("Santo Domingo", "Santo Domingo", "Santo Domingo de los Tsáchilas"));
        recintos.add(new Recinto("La Concordia", "La Concordia", "Santo Domingo de los Tsáchilas"));

        recintos.add(new Recinto("Nueva Loja", "Nueva Loja", "Sucumbíos"));
        recintos.add(new Recinto("Shushufindi", "Shushufindi", "Sucumbíos"));
        recintos.add(new Recinto("Cascales", "Cascales", "Sucumbíos"));

        recintos.add(new Recinto("Ambato", "Ambato", "Tungurahua"));
        recintos.add(new Recinto("Baños", "Baños", "Tungurahua"));
        recintos.add(new Recinto("Pelileo", "Pelileo", "Tungurahua"));

        recintos.add(new Recinto("Zamora", "Zamora", "Zamora Chinchipe"));
        recintos.add(new Recinto("Yantzaza", "Yantzaza", "Zamora Chinchipe"));
        recintos.add(new Recinto("El Pangui", "El Pangui", "Zamora Chinchipe"));
    }
    
    public List<Recinto> getRecintos() {
        return recintos;
    }
    
    public void agregarPartido(String nombrePartido) {
        if (!partidos.containsKey(nombrePartido)) {
            partidos.put(nombrePartido, new Partido(nombrePartido));
        }
    }

    public Partido getPartidoPorNombre(String nombrePartido) {
        return partidos.get(nombrePartido);
    }

    public void agregarVoto(Voto voto) {
        votos.add(voto);
    }

    public void agregarCandidato(String nombre, Partido partido, String provincia) {
        Candidato candidato = new Candidato(nombre, partido, provincia);
        candidatos.add(candidato);
    }

    public void registrarVoto(String cedula, Candidato candidato, Recinto recinto) {
        if (candidato == null || recinto == null) {
            throw new IllegalArgumentException("Candidato o recinto no pueden ser nulos.");
        }
        Voto voto = new Voto(cedula, candidato, recinto);
        votos.add(voto);
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public Candidato getCandidatoPorNombre(String nombre) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNombre().equals(nombre)) {
                return candidato;
            }
        }
        return null;
    }

    public Recinto getRecintoPorNombre(String nombre, String provincia) {
        for (Recinto recinto : recintos) {
            if (recinto.getNombre().equals(nombre) && recinto.getProvincia().equals(provincia)) {
                return recinto;
            }
        }
        return null;
    }

    public List<Object[]> obtenerResultadosPorProvinciaYCanton() {
        Map<String, Map<String, Map<String, Integer>>> resultados = new HashMap<>();

        for (Voto voto : votos) {
            Recinto recinto = voto.getRecinto();
            if (recinto == null) {
                continue;
            }

            String provincia = recinto.getProvincia();
            String canton = recinto.getCanton();
            String candidato = voto.getCandidato().getNombre();

            resultados.putIfAbsent(provincia, new HashMap<>());
            resultados.get(provincia).putIfAbsent(canton, new HashMap<>());
            Map<String, Integer> votosPorCandidato = resultados.get(provincia).get(canton);

            votosPorCandidato.put(candidato, votosPorCandidato.getOrDefault(candidato, 0) + 1);
        }

        List<Object[]> filas = new ArrayList<>();
        for (String provincia : resultados.keySet()) {
            for (String canton : resultados.get(provincia).keySet()) {
                for (String candidato : resultados.get(provincia).get(canton).keySet()) {
                    String partido = getCandidatoPorNombre(candidato).getPartido().getNombre();
                    int votos = resultados.get(provincia).get(canton).get(candidato);
                    filas.add(new Object[]{provincia, canton, candidato, partido, votos});
                }
            }
        }
        return filas;
    }

    public List<Object[]> obtenerResultadosGenerales() {
        Map<String, Map<String, Integer>> resultados = new HashMap<>();

        for (Voto voto : votos) {
            String provincia = voto.getRecinto().getProvincia();
            String candidato = voto.getCandidato().getNombre();

            resultados.putIfAbsent(provincia, new HashMap<>());
            Map<String, Integer> votosPorCandidato = resultados.get(provincia);

            votosPorCandidato.put(candidato, votosPorCandidato.getOrDefault(candidato, 0) + 1);
        }

        List<Object[]> filas = new ArrayList<>();
        for (String provincia : resultados.keySet()) {
            for (String candidato : resultados.get(provincia).keySet()) {
                String partido = getCandidatoPorNombre(candidato).getPartido().getNombre();
                int votos = resultados.get(provincia).get(candidato);
                filas.add(new Object[]{provincia, candidato, partido, votos});
            }
        }

        return filas;
    }
    
    public List<String> obtenerProvinciasConCandidatos() {
        Set<String> provinciasConCandidatos = new HashSet<>();
        for (Candidato candidato : candidatos) {
            provinciasConCandidatos.add(candidato.getProvincia());
        }
        return new ArrayList<>(provinciasConCandidatos);
    }
}
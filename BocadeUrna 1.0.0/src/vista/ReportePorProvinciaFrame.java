package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.SistemaDeVotacion;

import java.awt.*;
import java.util.List;

public class ReportePorProvinciaFrame extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private SistemaDeVotacion sistema;
    private JTable reporteTable;

    public ReportePorProvinciaFrame(SistemaDeVotacion sistema) {
        super("Resultados por Provincia", true, true, true, true);
        this.sistema = sistema;
        setSize(600, 400);
        setLayout(new BorderLayout());

        reporteTable = new JTable();
        add(new JScrollPane(reporteTable), BorderLayout.CENTER);

        mostrarResultados();
    }

    private void mostrarResultados() {
        String[] columnas = {"Provincia", "Cantón", "Candidato", "Partido", "Votos"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Object[]> resultados = sistema.obtenerResultadosPorProvinciaYCanton();
        for (Object[] fila : resultados) {
            modelo.addRow(fila);
        }

        reporteTable.setModel(modelo);
    }
}
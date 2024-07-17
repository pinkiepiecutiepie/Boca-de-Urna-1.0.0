package vista;

import javax.swing.*;

import controlador.SistemaDeVotacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SistemaDeVotacionGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    private SistemaDeVotacion sistema;

    public SistemaDeVotacionGUI(SistemaDeVotacion sistema) {
        this.sistema = sistema;

        setTitle("Sistema de Encuesta a Boca de Urna");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktopPane = new JDesktopPane();
        add(desktopPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu archivoMenu = new JMenu("Archivo");
        JMenuItem salirMenuItem = new JMenuItem("Salir");
        salirMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        archivoMenu.add(salirMenuItem);

        JMenu candidatosMenu = new JMenu("Candidatos");
        JMenuItem prefectosMenuItem = new JMenuItem("Prefectos");
        prefectosMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioPrefectos();
            }
        });
        candidatosMenu.add(prefectosMenuItem);

        JMenu procesoMenu = new JMenu("Proceso");
        JMenuItem bocaDeUrnaMenuItem = new JMenuItem("Boca de urna");
        bocaDeUrnaMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioBocaDeUrna();
            }
        });
        procesoMenu.add(bocaDeUrnaMenuItem);

        JMenu reportesMenu = new JMenu("Reportes");
        JMenuItem reporteProvinciaMenuItem = new JMenuItem("Resultados por cantón");
        reporteProvinciaMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarReportePorProvincia();
            }
        });
        reportesMenu.add(reporteProvinciaMenuItem);

        JMenuItem reporteCantonMenuItem = new JMenuItem("Resultados por provincia");
        reporteCantonMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarReportePorCanton();
            }
        });
        reportesMenu.add(reporteCantonMenuItem);

        menuBar.add(archivoMenu);
        menuBar.add(candidatosMenu);
        menuBar.add(procesoMenu);
        menuBar.add(reportesMenu);

        setJMenuBar(menuBar);
    }

    private boolean hayAlgunFormularioAbierto() {
        return Arrays.stream(desktopPane.getAllFrames()).anyMatch(frame -> frame.isVisible());
    }

    private void mostrarFormularioPrefectos() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioPrefectos formulario = new FormularioPrefectos(sistema);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarFormularioBocaDeUrna() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            FormularioBocaDeUrna formulario = new FormularioBocaDeUrna(sistema);
            desktopPane.add(formulario);
            formulario.setVisible(true);
        }
    }

    private void mostrarReportePorProvincia() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            ReportePorProvinciaFrame reporte = new ReportePorProvinciaFrame(sistema);
            desktopPane.add(reporte);
            reporte.setVisible(true);
        }
    }

    private void mostrarReportePorCanton() {
        if (hayAlgunFormularioAbierto()) {
            JOptionPane.showMessageDialog(this, "Ya hay un formulario abierto.");
        } else {
            ReportePorCantonFrame reporte = new ReportePorCantonFrame(sistema);
            desktopPane.add(reporte);
            reporte.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SistemaDeVotacion sistema = new SistemaDeVotacion();
                new SistemaDeVotacionGUI(sistema).setVisible(true);
            }
        });
    }
}
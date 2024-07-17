package vista;

import modelo.Candidato;
import modelo.Recinto;

import javax.swing.*;

import controlador.SistemaDeVotacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormularioBocaDeUrna extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField cedulaTextField;
    private JComboBox<String> candidatosComboBox;
    private JComboBox<String> provinciaComboBox;
    private JComboBox<String> recintosComboBox;
    private SistemaDeVotacion sistema;
    private Map<String, String[]> recintosPorProvincia;

    public FormularioBocaDeUrna(SistemaDeVotacion sistema) {
        super("Boca de Urna", true, true, true, true);
        this.sistema = sistema;
        setLayout(new GridLayout(5, 2));
        setSize(400, 300);

        recintosPorProvincia = obtenerRecintosPorProvincia();

        JLabel cedulaLabel = new JLabel("Cédula:");
        cedulaTextField = new JTextField();

        JLabel candidatoLabel = new JLabel("Candidato:");
        candidatosComboBox = new JComboBox<>();
        candidatosComboBox.addItem(""); // Placeholder
        for (Candidato candidato : sistema.getCandidatos()) {
            candidatosComboBox.addItem(candidato.getNombre());
        }

        JLabel provinciaLabel = new JLabel("Provincia:");
        provinciaComboBox = new JComboBox<>();
        provinciaComboBox.addItem(""); // Placeholder
        List<String> provinciasConCandidatos = sistema.obtenerProvinciasConCandidatos();
        for (String provincia : provinciasConCandidatos) {
            provinciaComboBox.addItem(provincia);
        }
        provinciaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String provinciaSeleccionada = (String) provinciaComboBox.getSelectedItem();
                actualizarRecintos(provinciaSeleccionada);
            }
        });

        JLabel recintoLabel = new JLabel("Recinto:");
        recintosComboBox = new JComboBox<>();

        JButton registrarButton = new JButton("Registrar Voto");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVoto();
            }
        });

        add(cedulaLabel);
        add(cedulaTextField);
        add(candidatoLabel);
        add(candidatosComboBox);
        add(provinciaLabel);
        add(provinciaComboBox);
        add(recintoLabel);
        add(recintosComboBox);
        add(new JLabel()); // Espacio vacío
        add(registrarButton);
    }

    private void registrarVoto() {
        String cedula = cedulaTextField.getText();
        String candidatoNombre = (String) candidatosComboBox.getSelectedItem();
        String recintoNombre = (String) recintosComboBox.getSelectedItem();

        if (cedula.isEmpty() || candidatoNombre == null || candidatoNombre == "" || recintoNombre == null || recintoNombre == "") {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        Candidato candidato = sistema.getCandidatoPorNombre(candidatoNombre);
        Recinto recinto = sistema.getRecintoPorNombre(recintoNombre, (String) provinciaComboBox.getSelectedItem());

        if (candidato == null || recinto == null) {
            JOptionPane.showMessageDialog(this, "Candidato o recinto no válidos.");
            return;
        }

        try {
            sistema.registrarVoto(cedula, candidato, recinto);
            JOptionPane.showMessageDialog(this, "Voto registrado exitosamente.");
            this.dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void actualizarRecintos(String provincia) {
        recintosComboBox.removeAllItems();
        recintosComboBox.addItem(""); // Placeholder
        String[] recintos = recintosPorProvincia.get(provincia);
        if (recintos != null) {
            for (String recinto : recintos) {
                recintosComboBox.addItem(recinto);
            }
        }
    }

    private Map<String, String[]> obtenerRecintosPorProvincia() {
        Map<String, List<String>> recintos = new HashMap<>();
        for (Recinto recinto : sistema.getRecintos()) {
            recintos.computeIfAbsent(recinto.getProvincia(), k -> new ArrayList<>()).add(recinto.getNombre());
        }
        return recintos.entrySet().stream()
                       .collect(Collectors.toMap(
                           Map.Entry::getKey,
                           e -> e.getValue().toArray(new String[0])
                       ));
    }
}
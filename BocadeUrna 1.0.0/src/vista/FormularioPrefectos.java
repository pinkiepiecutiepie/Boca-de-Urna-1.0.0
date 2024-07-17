package vista;

import modelo.Partido;
import javax.swing.*;

import controlador.SistemaDeVotacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPrefectos extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nombreTextField;
    private JTextField partidoTextField;
    private JComboBox<String> provinciaComboBox;
    private SistemaDeVotacion sistema;

    public FormularioPrefectos(SistemaDeVotacion sistema) {
        super("Registrar Prefecto", true, true, true, true);
        this.sistema = sistema;
        setLayout(new GridLayout(4, 2));
        setSize(400, 200);

        JLabel nombreLabel = new JLabel("Nombre del Prefecto:");
        nombreTextField = new JTextField();

        JLabel partidoLabel = new JLabel("Nombre del Partido:");
        partidoTextField = new JTextField();

        JLabel provinciaLabel = new JLabel("Provincia:");
        provinciaComboBox = new JComboBox<>(obtenerProvinciasConPlaceholder());

        JButton registrarButton = new JButton("Registrar Prefecto");
        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarPrefecto();
            }
        });

        add(nombreLabel);
        add(nombreTextField);
        add(partidoLabel);
        add(partidoTextField);
        add(provinciaLabel);
        add(provinciaComboBox);
        add(new JLabel());  // Empty label for alignment
        add(registrarButton);
    }

    private void registrarPrefecto() {
        String nombre = nombreTextField.getText();
        String nombrePartido = partidoTextField.getText();
        String provincia = (String) provinciaComboBox.getSelectedItem();

        if (nombre.isEmpty() || nombrePartido.isEmpty() || provincia == "" || provincia == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

        Partido partido = new Partido(nombrePartido);
        sistema.agregarPartido(nombrePartido);
        sistema.agregarCandidato(nombre, partido, provincia);

        JOptionPane.showMessageDialog(this, "Prefecto registrado exitosamente.");
        this.dispose(); // Cerrar el formulario después de agregar el prefecto
    }

    private String[] obtenerProvinciasConPlaceholder() {
        String[] provincias = new String[]{
            "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro",
            "Esmeraldas", "Galápagos", "Guayas", "Imbabura", "Loja", "Los Ríos",
            "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", "Pichincha",
            "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua",
            "Zamora Chinchipe"
        };
        // Crear un nuevo array con el marcador de posición
        String[] provinciasConPlaceholder = new String[provincias.length + 1];
        provinciasConPlaceholder[0] = ""; // Marcador de posición
        System.arraycopy(provincias, 0, provinciasConPlaceholder, 1, provincias.length);
        return provinciasConPlaceholder;
    }
}
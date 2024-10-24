import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private SujetoConcreto sujeto;
    private ObservadorConcreto observador1;
    private ObservadorConcreto observador2;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField;
    private JButton botonActualizar;

    public MainFrame() {
        sujeto = new SujetoConcreto();

        // Configuración de la ventana
        setTitle("Patrón Observer - Ejemplo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Crear componentes de la interfaz
        label1 = new JLabel("Observador 1: ");
        label1.setBounds(20, 20, 150, 20);
        add(label1);

        label2 = new JLabel("Observador 2: ");
        label2.setBounds(20, 50, 150, 20);
        add(label2);

        textField = new JTextField();
        textField.setBounds(20, 80, 150, 20);
        add(textField);

        botonActualizar = new JButton("Actualizar");
        botonActualizar.setBounds(20, 110, 150, 20);
        add(botonActualizar);

        // Crear observadores y agregarlos al sujeto
        observador1 = new ObservadorConcreto(label1);
        observador2 = new ObservadorConcreto(label2);
        sujeto.agregarObservador(observador1);
        sujeto.agregarObservador(observador2);

        // Evento del botón para actualizar el valor
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(textField.getText());
                    sujeto.setValor(valor);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}

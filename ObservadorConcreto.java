import javax.swing.JLabel;

public class ObservadorConcreto implements Observador {
    private JLabel label;

    public ObservadorConcreto(JLabel label) {
        this.label = label;
    }

    @Override
    public void actualizar(int valor) {
        label.setText("Valor actualizado: " + valor);
    }
}

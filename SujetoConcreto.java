import java.util.ArrayList;
import java.util.List;

public class SujetoConcreto {
    private List<Observador> observadores;
    private int valor;

    public SujetoConcreto() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setValor(int valor) {
        this.valor = valor;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(valor);
        }
    }
}

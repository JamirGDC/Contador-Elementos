import java.util.ArrayList;
import java.util.List;

public class ContadorElementos<T> {

    private List<T> elementos;
    private List<Integer> repeticiones;

    public ContadorElementos() {
        elementos = new ArrayList<>();
        repeticiones = new ArrayList<>();
    }

    public void count(T elemento) {
        try {
            int index = elementos.indexOf(elemento);
            if (index != -1) {
                repeticiones.set(index, repeticiones.get(index) + 1);
            } else {
                elementos.add(elemento);
                repeticiones.add(1);
            }
        } catch (Exception e) {
            System.err.println("Error al añadir el elemento: " + e.getMessage());
        }
    }

    public void discount(T elemento) {
        try {
            int index = elementos.indexOf(elemento);
            if (index != -1) {
                int contador = repeticiones.get(index);
                if (contador > 1) {
                    repeticiones.set(index, contador - 1);
                } else {
                    elementos.remove(index);
                    repeticiones.remove(index);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al descontar el elemento: " + e.getMessage());
        }
    }

    public void delete(T elemento) {
        try {
            int index = elementos.indexOf(elemento);
            if (index != -1) {
                elementos.remove(index);
                repeticiones.remove(index);
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar el elemento: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < elementos.size(); i++) {
            result.append(elementos.get(i)).append(": ").append(repeticiones.get(i));
            if (i < elementos.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        ContadorElementos<String> contador = new ContadorElementos<>();
        try {
            contador.count("a");
            contador.count("b");
            contador.count("a");
            contador.count("c");
            System.out.println(contador.toString());

            contador.discount("a");
            System.out.println(contador.toString());

            contador.delete("b");
            System.out.println(contador.toString());
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }
}

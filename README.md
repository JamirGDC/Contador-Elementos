# Contador ELementos

* Puede ver el codigo en la siguiente URL: [RepoContador](https://github.com/JamirGDC/Contador-Elementos.git)
* todo el codigo tiene implementado el manejo de excepciones
  
## Declaracion Variables

  Se Declara una lista elementos que almacenara los elementos y una lista repeticiones que almacenara las repeticiones de cada elemento

    ```
    private List<T> elementos;
    private List<Integer> repeticiones;
    ```

## Constructor

  Este es el constructor de la clase. Inicializa las listas 'elementos' y 'repeticiones' como nuevas instancias de 'ArrayList'

    ```
    public ContadorElementos() {
    elementos = new ArrayList<>();
    repeticiones = new ArrayList<>();
    }

    ```
## Metodo Count

  Este metodo toma un elemento como argumento y lo intenta agregar a la lista de elementos elementos, si este ya se encuentra incrementa el contador de repeticiones en 1 pudiendo haber solo 1 elemento, si no existiera el elemento se añadiria a la lista y el contador empezaria en 1

  ```
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
  ```
## Metodo Discount

  Este metodo hace lo contrario al anterior, descuenta en 1 el contador de un elemento si tiene varios, y si solo le queda uno lo elimina de elementos y de repeticiones
  
  ```
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

  ```
## Metodo delete

  Este metodo elimina el elemento de la lista elementos y repeticiones independientemente si le queda 1 o mas.
  
  ```
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


  ```

## Metodo toString

  Este metodo sobreescribe el metodo toString() de la clase object para representar en texto los elementos y sus repeticiones
  
  ```
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

  ```

## Metodo Main

  Este metodo simplemente instancia contador elementos para realizar un ejemplo del programa 

```
ContadorElementos<Integer> camisetas = new ContadorElementos<>();
        try {
            camisetas.count(10);
            camisetas.count(7);
            camisetas.count(10);
            camisetas.count(9);
            System.out.println(camisetas);

            camisetas.discount(10);
            System.out.println(camisetas);

            camisetas.delete(9);
            System.out.println(camisetas);
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }

        ContadorElementos<String> animales = new ContadorElementos<>();
        try {
            animales.count("gato");
            animales.count("perro");
            animales.count("gato");
            animales.count("pato");
            System.out.println(animales);

            animales.discount("gato");
            System.out.println(animales);

            animales.delete("perro");
            System.out.println(animales);
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
```




package UnidosNoMezclados;

import java.util.Random;

public class TresPilas {
    private PilaInt pila1, pila2, pila3;
    private final int tamanio;

    public TresPilas(int tamanio) {
        this.tamanio = tamanio;
        pila1 = new PilaInt(tamanio);
        pila2 = new PilaInt(tamanio);
        pila3 = new PilaInt(tamanio*2);
        cargarPilaOrdenada(pila1);
        cargarPilaOrdenada(pila2);
    }
    
    public void unirSinMezclar(){
        //Cargar la pila3
        while(!pila3.pilaLLena()){ 
            if(!pila1.pilaVacia() && !pila2.pilaVacia()){// este if fue necesario, ya que al vaciarse una pila no podía comparar
                if(pila1.verElemento() < pila2.verElemento()){
                pila3.push(pila1.verElemento());
                pila1.pop();
                }else{
                pila3.push(pila2.verElemento());
                pila2.pop();
                }
            }else if(!pila1.pilaVacia() && pila2.pilaVacia()){
                pila3.push(pila1.verElemento());
                pila1.pop();
            }else if(pila1.pilaVacia() && !pila2.pilaVacia()){
                pila3.push(pila2.verElemento());
                pila2.pop();
            }  
        }
        //vamo a ver como queda QUIZÁ BORRAR LUEGO
        System.out.println("esta es la pila 3");
        pila3.mostrarPila();
        //Pasamos la mitad de la pila3 a la pila2
        pasarDePila(pila3, pila2);
        //Para invertir el orden pasamos el contenido de la pila2 a la pila1
        pasarDePila(pila2, pila1);
        //Pasamos lo que queda de la pila3 a la pila2
        pasarDePila(pila3, pila2);
        //controlando que la pila3 esté realmente vacía
        System.out.println("La pila 3 esta vacia?" + pila3.pilaVacia());
        //ahora a cargar la pila3 con lo que tenemos ordenado en la pila1
        pasarDePila(pila1, pila3);
        //Ahora a ordenar lo de la pila2 en la pila1
        pasarDePila(pila2, pila1);
        //ahora a cargar la pila 3 con lo que tenemos ordenado en la pila1
        pasarDePila(pila1, pila3);
        //Ahora comprobamos
        pila3.mostrarPila();
    }
    
    private void cargarPilaOrdenada(PilaInt pila) {
        int[] array = new int[tamanio];
        Random random = new Random();
        for(int i = 0; i < tamanio; i++){
            int aleatorio = random.nextInt(256);
            array[i] = aleatorio;
        }
        mostrarArray(array); 
        //Ahora ordenamos:
        insertionSort(array);
        mostrarArray(array);
        //Ahora cargamos:
        for(int i = tamanio - 1; i >= 0; i--){// de esta forma los más grandes van al fondo de la pila
            pila.push(array[i]);
        }
        pila.mostrarPila();
    }
    private void pasarDePila(PilaInt origen, PilaInt destino){
        for(int i = 0; i < tamanio; i++){
            destino.push(origen.verElemento());
            origen.pop();
        }
    }
    //IMPORTANTE PARA QUE LAS PILAS INICIALES ESTÉN ORDENADAS
    public void insertionSort(int[] datos) {
        int i, j, aux;
        for (i = 1; i < tamanio; i++) {
            aux = datos[i];
            j = i;
            while (j > 0 && datos[j - 1] > aux) {
                datos[j] = datos[j - 1];
                j = j - 1;
                datos[j] = aux;
            }
        }
    }
    //MÉTODO DESCARTABLE
    public void mostrarArray(int[] array){
        for(int i = 0; i < array.length;i++){
            System.out.println(i + "- " +array[i]);
        }
    }
}

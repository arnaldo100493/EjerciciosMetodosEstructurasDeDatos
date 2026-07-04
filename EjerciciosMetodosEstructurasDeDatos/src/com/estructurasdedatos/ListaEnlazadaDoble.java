package com.estructurasdedatos;

/**
 *
 * @author abarrios
 * @param <E> elemento
 */
public class ListaEnlazadaDoble<E> implements Lista<E> {

   private NodoDoble<E> primero;
   private NodoDoble<E> ultimo;
   private int tamanio;

   public ListaEnlazadaDoble() {
      primero = null;
      ultimo = null;
      tamanio = 0;
   }

   public boolean estaVacia(){
       return primero == null;
   }

   public boolean estaLlena(){
       return new NodoDoble<>() == null;
   }

   public int tamanio(){
       return tamanio;
   }

   public void agregar(E elemento) {
       NodoDoble<E> nuevoNodo = new NodoDoble<>(elemento);
       if (estaVacia()) {
           primero = nuevoNodo;
           ultimo = nuevoNodo;
       } else {
           nuevoNodo.setAnterior(ultimo);
           ultimo.setSiguiente(nuevoNodo);
           ultimo = nuevoNodo;
       }
   }

   public void agregarPrimero(E elemento) {
       NodoDoble<E> nuevoNodo = new NodoDoble<>(elemento);
       if (estaVacia()) {
           primero = nuevoNodo;
           ultimo = nuevoNodo;
       } else {
          nuevoNodo.setSiguiente(primero);
          primero.setAnterior(nuevoNodo);
          primero = nuevoNodo;
       }
   }

   public void agregarUltimo(E elemento) {
      NodoDoble<E> nuevoNodo = new NodoDoble<>(elemento);
         if (estaVacia()) {
           primero = nuevoNodo;
           ultimo = nuevoNodo;
         } else {
             nuevoNodo.setAnterior(ultimo);
             ultimo.setSiguiente(nuevoNodo);
             ultimo = nuevoNodo;
         }
   }

    public E remover() {
       E elemento = null;
         if (!estaVacia()) {
             //Sí solo hay un solo nodo en la lista
           if (primero.getSiguiente() == null) {
               primero = null;
               ultimo = null;
           } else {
               primero = primero.getSiguiente();
               primero.setAnterior(null);
           }
         }
       return elemento;
    }

    public E removerPrimero() {
        E elemento = null;
        if (!estaVacia()) {
            if (primero.getSiguiente() == null) {
                elemento = primero.getElemento();
                primero = null;
                ultimo = null;
            } else {
                elemento = primero.getElemento();
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
        }
        return elemento;
    }

    public E removerUltimo() {
        E elemento = null;
        if (!estaVacia()) {
            if (primero.getSiguiente() == null) {
                elemento = ultimo.getElemento();
                primero = null;
                ultimo = null;
            } else {
                elemento = ultimo.getElemento();
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        }
        return elemento;
    }

    public E primero() {
       E elemento = null;
       if (!estaVacia()) {
           elemento = primero.getElemento();
       }
       return elemento;
    }

   public E ultimo() {
       E elemento = null;
       if (!estaVacia()) {
           elemento = ultimo.getElemento();
       }
       return elemento;
   }

    //Método para recorrer la lista hacia adelante
    public String mostrarAdelante() {
        String s = "";
        NodoDoble<E> actual = primero;
        while (actual != null) {
            s += actual.getElemento() + " <-> ";
            actual = actual.getSiguiente();
        }
        s += "null";
        return s;
    }

    //Método para recorrer la lista hacia atrás
    public String mostrarAtras() {
        String s = "";
        NodoDoble<E> actual = ultimo;
        while (actual != null) {
            s += actual.getElemento() + " <-> ";
            actual = actual.getAnterior();
        }
        s += "null";
        return s;
    }

    //Método para limpiar la lista.
    public void limpiar() {
       if(!estaVacia()){
           remover();
       }
    }
}

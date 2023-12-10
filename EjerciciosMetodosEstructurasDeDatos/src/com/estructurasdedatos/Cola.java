/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructurasdedatos;

/**
 *
 * @author abarrios
 * @param <E> elemento
 */
public class Cola<E> {

    private Nodo<E> primero;
    private Nodo<E> ultimo;
    private int tamanio;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return this.primero == null;
    }

    public int tamanio() {
        return this.tamanio;
    }

    public void agregar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
        this.tamanio++;
    }

    public E remover() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
            this.primero = this.primero.getSiguiente();
            this.tamanio--;
        } else {
            System.out.println("Cola Vacía...!!!");
        }
        return elemento;
    }

    public E obtenerPrimero() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
        }
        return elemento;
    }

    public E obtenerUltimo() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.ultimo.getElemento();
        }
        return elemento;
    }

    //Método imprimir Funciona Perfecto.
    public String imprimir() {
        String s = "";
        Cola<E> colaAuxiliar = new Cola<>();
        while (!this.estaVacia()) {
            E elemento = this.remover();
            s += "\n" + elemento;
            colaAuxiliar.agregar(elemento);
        }
        while (!colaAuxiliar.estaVacia()) {
            this.agregar(colaAuxiliar.remover());
        }
        return s;
    }
    
    //Método para limpiar la cola.
     public void limpiar() {
        while (!this.estaVacia()) {
            this.remover();
        }
    }

    //Método eliminarPrimerElemento Funciona Perfecto.
    public static Cola eliminarPrimerElemento(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.agregar(x.remover());
        }
        y.remover();
        while (!y.estaVacia()) {
            x.agregar(y.remover());
        }
        return x;
    }

    public static void invertirExtremos(Cola x) {
        Object elementoAuxiliar = x.remover();
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.agregar(x.remover());
        }
        x.agregar(elementoAuxiliar);
        elementoAuxiliar = y.remover();
        while (!y.estaVacia()) {
            x.agregar(y.remover());
        }
        x.agregar(elementoAuxiliar);
    }

    //Método copiarCola Funciona Perfecto.
    public static void copiarCola(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.agregar(x.remover());
        }
        while (!y.estaVacia()) {
            System.out.println(y.remover());
        }
    }

    //Método eliminarElementoEspecifico Funciona Perfecto.
    public static void eliminarElementoEspecifico(Cola x, Object elemento) {
        Object elementoAuxiliar = null;
        Cola y = new Cola();
        if (x.estaVacia()) {
            System.out.println("Cola Vacía...!!!");
        } else {
            while (!x.estaVacia()) {
                elementoAuxiliar = x.remover();
                if (elementoAuxiliar.equals(elemento)) {
                    System.out.println("Elemento " + elemento + " Eliminado...!!!");
                    elemento = null;
                } else {
                    y.agregar(elementoAuxiliar);
                }
            }
            while (!y.estaVacia()) {
                x.agregar(y.remover());
            }
        }
    }

    public static void eliminarElementosRepetidosConsecutivos(Cola x) {
        Object elemento = null;
        Pila y = new Pila();
        while (!x.estaVacia()) {
            elemento = x.remover();
            while (elemento.equals(x.obtenerPrimero())) {
                x.remover();
            }
            y.empujar(elemento);
        }
        while (!y.estaVacia()) {
            x.agregar(y.sacar());
        }
    }

    public static Cola invertirElementos(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.agregar(x.remover());
        }
        return y;
    }
}

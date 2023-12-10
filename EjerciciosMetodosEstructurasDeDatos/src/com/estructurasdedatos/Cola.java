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

    public int getTamanio() {
        return this.tamanio;
    }

    public void empujar(E elemento) {
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

    public E sacar() {
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

    public E getPrimero() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
        }
        return elemento;
    }

    public E getUltimo() {
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
            E elemento = this.sacar();
            s += "\n" + elemento;
            colaAuxiliar.empujar(elemento);
        }
        while (!colaAuxiliar.estaVacia()) {
            this.empujar(colaAuxiliar.sacar());
        }
        return s;
    }

    //Método eliminarPrimerElemento Funciona Perfecto.
    public static Cola eliminarPrimerElemento(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        y.sacar();
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
        return x;
    }

    public static void invertirExtremos(Cola x) {
        Object elementoAuxiliar = x.sacar();
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        x.empujar(elementoAuxiliar);
        elementoAuxiliar = y.sacar();
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
        x.empujar(elementoAuxiliar);
    }

    //Método copiarCola Funciona Perfecto.
    public static void copiarCola(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.sacar());
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
                elementoAuxiliar = x.sacar();
                if (elementoAuxiliar.equals(elemento)) {
                    System.out.println("Elemento " + elemento + " Eliminado...!!!");
                    elemento = null;
                } else {
                    y.empujar(elementoAuxiliar);
                }
            }
            while (!y.estaVacia()) {
                x.empujar(y.sacar());
            }
        }
    }

    public static void eliminarElementosRepetidosConsecutivos(Cola x) {
        Object elemento = null;
        Pila y = new Pila();
        while (!x.estaVacia()) {
            elemento = x.sacar();
            while (elemento.equals(x.getPrimero())) {
                x.sacar();
            }
            y.empujar(elemento);
        }
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
    }

    public static Cola invertirElementos(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        return y;
    }
}

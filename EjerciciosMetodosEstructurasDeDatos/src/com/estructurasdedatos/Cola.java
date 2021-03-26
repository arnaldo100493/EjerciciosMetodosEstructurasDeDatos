/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.estructurasdedatos;

/**
 *
 * @author abarrios
 */
public class Cola<E> {

    private Nodo<E> primero;
    private Nodo<E> ultimo;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean estaVacia() {
        return this.primero == null;
    }

    public void poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
    }

    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.primero.getElemento();
            this.primero = this.primero.getSiguiente();
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
            E elemento = this.quitar();
            s += "\n" + elemento;
            colaAuxiliar.poner(elemento);
        }
        while (!colaAuxiliar.estaVacia()) {
            this.poner(colaAuxiliar.quitar());
        }
        return s;
    }

    //Método eliminarPrimerElemento Funciona Perfecto.
    public static Cola eliminarPrimerElemento(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        y.quitar();
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        return x;
    }

    public static void invertirExtremos(Cola x) {
        Object elementoAuxiliar = x.quitar();
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        x.poner(elementoAuxiliar);
        elementoAuxiliar = y.quitar();
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        x.poner(elementoAuxiliar);
    }

    //Método copiarCola Funciona Perfecto.
    public static void copiarCola(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.quitar());
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
                elementoAuxiliar = x.quitar();
                if (elementoAuxiliar.equals(elemento)) {
                    System.out.println("Elemento " + elemento + " Eliminado...!!!");
                    elemento = null;
                } else {
                    y.poner(elementoAuxiliar);
                }
            }
            while (!y.estaVacia()) {
                x.poner(y.quitar());
            }
        }
    }

    public static void eliminarElementosRepetidosConsecutivos(Cola x) {
        Object elemento = null;
        Pila y = new Pila();
        while (!x.estaVacia()) {
            elemento = x.quitar();
            while (elemento.equals(x.getPrimero())) {
                x.quitar();
            }
            y.poner(elemento);
        }
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
    }

    public static Cola invertirElementos(Cola x) {
        Cola y = new Cola();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        return y;
    }
}

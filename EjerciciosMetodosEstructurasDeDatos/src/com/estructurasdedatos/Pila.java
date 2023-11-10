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
public class Pila<E> {

    private Nodo<E> tope;
    private int tamanio;

    public Pila() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return this.tope == null;
    }
    
    public int getTamanio(){
        return this.tamanio;
    }

    public void poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.tope = nuevoNodo;
        } else {
            this.tope.setSiguiente(nuevoNodo);
            this.tope = nuevoNodo;
        }
        this.tamanio++;
    }

    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.tope.getElemento();
            this.tope = this.tope.getSiguiente();
            this.tamanio--;
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }

    public E getCima() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.tope.getElemento();
        }
        return elemento;
    }

    public String imprimir() {
        String s = "";
        Pila<E> pilaAuxiliar = new Pila<>();
        while (!this.estaVacia()) {
            E elemento = this.quitar();
            s += "\n" + elemento;
            pilaAuxiliar.poner(elemento);
        }
        while (!pilaAuxiliar.estaVacia()) {
            this.poner(pilaAuxiliar.quitar());
        }
        return s;
    }

    public static Pila eliminarPrimerElemento(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        y.quitar();
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        return x;
    }

    public static void invertirExtremos(Pila x) {
        Object elementoAuxiliar = x.quitar();
        Pila y = new Pila();
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

    public static void copiarPila(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.quitar());
        }
    }

    public static void eliminarElementoEspecifico(Pila x, Object elemento) {
        Object elementoAuxiliar = null;
        Pila y = new Pila();
        if (x.estaVacia()) {
            System.out.println("Pila Vacía...!!!");
        } else {
            while (!x.estaVacia()) {
                elementoAuxiliar = x.quitar();
                if (elementoAuxiliar.equals(elemento)) {
                    System.out.println("Elemento " + elemento + "Eliminado...!!!");
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

    public static void eliminarElementosRepetidosConsecutivos(Pila x) {
        Object elemento = null;
        Pila y = new Pila();
        while (!x.estaVacia()) {
            elemento = x.quitar();
            while (elemento.equals(x.getCima())) {
                x.quitar();
            }
            y.poner(elemento);
        }
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
    }

    public static Pila invertirElementos(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        return y;
    }
}

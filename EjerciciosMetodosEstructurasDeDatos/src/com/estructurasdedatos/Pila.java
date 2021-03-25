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
    
    public Pila() {
        this.tope = null;
    }
    
    public boolean estaVacia() {
        return this.tope == null;
    }
    
    public void poner(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.tope = nuevoNodo;
        } else {
            this.tope.setSiguiente(nuevoNodo);
            this.tope = nuevoNodo;
        }
    }
    
    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.tope.getElemento();
            this.tope = this.tope.getSiguiente();
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
    
    public Pila<E> eliminarPrimerElemento(Pila<E> x) {
        Pila<E> y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        y.quitar();
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        return x;
    }
    
    public void invertirExtremos(Pila<E> x) {
        E elementoAuxiliar = x.quitar();
        Pila<E> y = new Pila<>();
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
    
    public void copiarPila(Pila<E> x) {
        Pila<E> y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.quitar());
        }
    }
    
    public void eliminarElementoEspecifico(Pila<E> x, E elemento) {
        E elementoAuxiliar = null;
        Pila<E> y = new Pila<>();
        if (x.estaVacia()) {
            System.out.println("Pila Vacía...!!!");
        } else {
            while (!x.estaVacia()) {
                elementoAuxiliar = x.quitar();
                if (elementoAuxiliar.equals(elemento)) {
                    elemento = null;
                    System.out.println("Elemento Eliminado...!!!");
                } else {
                    y.poner(elementoAuxiliar);
                }
            }
            while (!y.estaVacia()) {
                x.poner(y.quitar());
            }
        }
    }
    
    public void eliminarElementosRepetidosConsecutivos(Pila<E> x) {
        E elemento = null;
        Pila<E> y = new Pila<>();
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
    
    public Pila<E> invertirElementos(Pila<E> x) {
        Pila<E> y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        return y;
    }
    
}

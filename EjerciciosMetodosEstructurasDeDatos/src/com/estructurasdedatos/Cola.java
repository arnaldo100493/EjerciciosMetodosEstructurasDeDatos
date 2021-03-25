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

}

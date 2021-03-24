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
    
    public E cima() {
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
    
}

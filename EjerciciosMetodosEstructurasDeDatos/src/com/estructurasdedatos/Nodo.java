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
public class Nodo<E> {

    private Nodo<E> anterior;
    private E elemento;
    private Nodo<E> siguiente;

    public Nodo() {
        this.anterior = null;
        this.elemento = null;
        this.siguiente = null;
    }

    public Nodo(E elemento) {
        this.anterior = null;
        this.elemento = elemento;
        this.siguiente = null;
    }

    public Nodo(Nodo<E> anterior, E elemento, Nodo<E> siguiente) {
        this.anterior = anterior;
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    public boolean tieneAnterior() {
        return this.anterior != null;
    }

    public boolean tieneSiguiente() {
        return this.siguiente != null;
    }

    /**
     * @return the anterior
     */
    public Nodo<E> getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the elemento
     */
    public E getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the siguiente
     */
    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }
}

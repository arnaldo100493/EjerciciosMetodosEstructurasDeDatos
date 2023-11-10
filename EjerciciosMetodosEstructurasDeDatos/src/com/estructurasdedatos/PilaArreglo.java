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
public class PilaArreglo<E> {

    private E[] listadoElementos;
    private int tope;
    private int maximo;

    public PilaArreglo() {
        this.maximo = 100;
        this.listadoElementos = (E[]) new Object[this.maximo];
        this.tope = -1;
    }

    public PilaArreglo(int maximo) {
        this.maximo = 100;
        this.listadoElementos = (E[]) new Object[maximo];
        this.tope = -1;
    }

    public boolean estaVacia() {
        return this.tope == -1;
    }

    public boolean estaLlena() {
        return this.tope == this.maximo - 1;
    }

    public void poner(E elemento) {
        if (!this.estaLlena()) {
            this.listadoElementos[this.tope] = elemento;
            this.tope++;
        } else {
            System.out.println("Pila Llena...!!!");
        }
    }

    public E quitar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.tope];
            this.tope--;
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }

    public E getCima() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.tope];
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }
}

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
    private int cima;
    private int maximo;

    public PilaArreglo() {
        this.maximo = 100;
        this.listadoElementos = (E[]) new Object[this.maximo];
        this.cima = -1;
    }

    public PilaArreglo(int maximo) {
        this.listadoElementos = (E[]) new Object[maximo];
        this.cima = -1;
    }

    public boolean estaVacia() {
        return this.cima == -1;
    }

    public boolean estaLlena() {
        return this.cima == this.maximo - 1;
    }

    public void empujar(E elemento) {
        if (!this.estaLlena()) {
            this.listadoElementos[this.cima] = elemento;
            this.cima++;
        } else {
            System.out.println("Pila Llena...!!!");
        }
    }

    public E sacar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.cima];
            this.cima--;
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }

    public E cima() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.cima];
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }

    //Método para limpiar la pila
    public void limpiar() {
        while (!this.estaVacia()) {
            this.sacar();
        }
    }

}

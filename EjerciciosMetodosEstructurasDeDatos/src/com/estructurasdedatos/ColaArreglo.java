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
public class ColaArreglo<E> {

    private E[] listadoElementos;
    private int primero;
    private int ultimo;
    private int maximo;
    private int tamanio;

    public ColaArreglo() {
        this.maximo = 100;
        this.listadoElementos = (E[]) new Object[this.maximo];
        this.primero = -1;
        this.ultimo = -1;
    }

    public ColaArreglo(int maximo) {
        this.maximo = 100;
        this.listadoElementos = (E[]) new Object[maximo];
        this.primero = -1;
        this.ultimo = -1;
    }

    public boolean estaVacia() {
        return this.primero == -1;
    }

    public boolean estaLlena() {
        return this.primero == this.maximo - 1;
    }
    
    public int tamanio(){
        return this.tamanio;
    }

    public void agregar(E elemento) {
        if (!this.estaLlena()) {
            this.listadoElementos[this.ultimo] = elemento;
            this.ultimo++;
            this.tamanio++;
        } else {
            System.out.println("Cola Llena...!!!");
        }
    }

    public E remover() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.primero];
            this.primero--;
            this.tamanio--;
        } else {
            System.out.println("Cola Vacía...!!!");
        }
        return elemento;
    }

    public E obtenerPrimero() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.primero];
        } else {
            System.out.println("Cola Vacía...!!!");
        }
        return elemento;
    }

    public E obtenerUltimo() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.listadoElementos[this.ultimo];
        } else {
            System.out.println("Cola Vacía...!!!");
        }
        return elemento;
    }
}

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
public class Lista<E> {

    private Nodo<E> listaPositivos;
    private Nodo<E> listaNegativos;
    private int tamanio;

    public Lista() {
        this.listaPositivos = this.listaNegativos = null;
    }

    public boolean estaVacia() {
        return listaPositivos == null && listaNegativos == null;
    }
    
    public int obtenerTamanio(){
        return this.tamanio;
    }

    public void insertar(int dato) {
        if (dato > 0) {
            Nodo positivo = new Nodo(dato);
            if (estaVacia()) {
                listaPositivos = positivo;
                this.tamanio++;
                System.out.println("El numero " + dato + " es positivo y se ha insertado correctamente a la lista de valores positivos...!!!");
            } else {
                listaPositivos.setSiguiente(positivo);
                listaPositivos = positivo;
                this.tamanio++;
                System.out.println("El numero " + dato + " es positivo y se ha insertado correctamente a la lista de valores positivos...!!!");
            }
        } else {
            Nodo negativo = new Nodo(dato);
            if (estaVacia()) {
                listaNegativos = negativo;
                System.out.println("El numero " + dato + " es negativo y se ha insertado correctamente a la lista de valores negativos...!!!");
            } else {
                listaNegativos.setSiguiente(negativo);
                listaNegativos = negativo;
                System.out.println("El numero " + dato + " es negativo y se ha insertado correctamente a la lista de valores negativos...!!!");
            }
        }
    }
}

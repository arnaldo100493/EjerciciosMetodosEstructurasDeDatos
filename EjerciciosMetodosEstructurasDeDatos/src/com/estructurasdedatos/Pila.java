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
public class Pila<E> {

    private Nodo<E> cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.cima == null;
    }

    public int tamanio() {
        return this.tamanio;
    }

    public void empujar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (this.estaVacia()) {
            this.cima = nuevoNodo;
        } else {
            this.cima.setSiguiente(nuevoNodo);
            this.cima = nuevoNodo;
        }
        this.tamanio++;
    }

    public E sacar() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.cima.getElemento();
            this.cima = this.cima.getSiguiente();
            this.tamanio--;
        } else {
            System.out.println("Pila Vacía...!!!");
        }
        return elemento;
    }

    public E cima() {
        E elemento = null;
        if (!this.estaVacia()) {
            elemento = this.cima.getElemento();
        }
        return elemento;
    }

    public String imprimir() {
        String s = "";
        Pila<E> pilaAuxiliar = new Pila<>();
        while (!this.estaVacia()) {
            E elemento = this.sacar();
            s += "\n" + elemento;
            pilaAuxiliar.empujar(elemento);
        }
        while (!pilaAuxiliar.estaVacia()) {
            this.empujar(pilaAuxiliar.sacar());
        }
        return s;
    }

    public static Pila eliminarPrimerElemento(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        y.sacar();
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
        return x;
    }

    public static void invertirExtremos(Pila x) {
        Object elementoAuxiliar = x.sacar();
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        x.empujar(elementoAuxiliar);
        elementoAuxiliar = y.sacar();
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
        x.empujar(elementoAuxiliar);
    }

    public static void copiarPila(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.sacar());
        }
    }

    public static void eliminarElementoEspecifico(Pila x, Object elemento) {
        Object elementoAuxiliar = null;
        Pila y = new Pila();
        if (x.estaVacia()) {
            System.out.println("Pila Vacía...!!!");
        } else {
            while (!x.estaVacia()) {
                elementoAuxiliar = x.sacar();
                if (elementoAuxiliar.equals(elemento)) {
                    System.out.println("Elemento " + elemento + "Eliminado...!!!");
                    elemento = null;
                } else {
                    y.empujar(elementoAuxiliar);
                }
            }
            while (!y.estaVacia()) {
                x.empujar(y.sacar());
            }
        }
    }

    public static void eliminarElementosRepetidosConsecutivos(Pila x) {
        Object elemento = null;
        Pila y = new Pila();
        while (!x.estaVacia()) {
            elemento = x.sacar();
            while (elemento.equals(x.cima())) {
                x.sacar();
            }
            y.empujar(elemento);
        }
        while (!y.estaVacia()) {
            x.empujar(y.sacar());
        }
    }

    public static Pila invertirElementos(Pila x) {
        Pila y = new Pila();
        while (!x.estaVacia()) {
            y.empujar(x.sacar());
        }
        return y;
    }
}

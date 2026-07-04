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
public class ArbolBinario<E> {

    private NodoArbolBinario<E> raiz;
    private int tamanio;

    public ArbolBinario() {
        raiz = null;
        tamanio = 0;
    }

    public ArbolBinario(NodoArbolBinario<E> raiz) {
        this.raiz = raiz;
        tamanio++;
    }

    /**
     * @return the raiz
     */
    public NodoArbolBinario<E> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the siguiente to set
     */
    public void setRaiz(NodoArbolBinario<E> raiz) {
        this.raiz = raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public int tamanio() {
        return tamanio;
    }

    // RECORRIDO PREORDEN DE UN ÁRBOL BINARIO
    private String preorden(NodoArbolBinario<E> raiz, String s) {
        if (raiz != null) {
            s += " " + raiz.getElemento();
            s = preorden(raiz.getHijoIzquierdo(), s);
            s = preorden(raiz.getHijoDerecho(), s);
        }
        return s;
    }

    public String preorden() {
        return "RECORRIDO PREORDEN: " + preorden(raiz, "");
    }

    // RECORRIDO POSTORDEN DE UN ÁRBOL BINARIO
    private String postorden(NodoArbolBinario<E> raiz, String s) {
        if (raiz != null) {
            s = postorden(raiz.getHijoIzquierdo(), s);
            s = postorden(raiz.getHijoDerecho(), s);
            s += " " + raiz.getElemento();
        }
        return s;

    }

    public String postorden() {
        return "RECORRIDO POSTORDEN: " + postorden(raiz, "");
    }

    // RECORRIDO INORDEN DE UN ÁRBOL BINARIO
    private String inorden(NodoArbolBinario<E> raiz, String s) {
        if (raiz != null) {
            s = inorden(raiz.getHijoIzquierdo(), s);
            s += " " + raiz.getElemento();
            s = inorden(raiz.getHijoDerecho(), s);
        }
        return s;
    }

    public String inorden() {
        return "RECORRIDO INORDEN: " + inorden(raiz, "");
    }

    // BUSCAR EL NODO DE UN ÁRBOL BINARIO
    private Boolean buscar(NodoArbolBinario<E> raiz, E elemento) {
        if (raiz != null) {
            if (raiz.getElemento().equals(elemento)) {
                return true;
            }
            Boolean ok1 = buscar(raiz.getHijoIzquierdo(), elemento);
            Boolean ok2 = buscar(raiz.getHijoDerecho(), elemento);

            if (ok1 || ok2) {
                return true;
            }
        }

        return false;
    }

    public String buscar(E elemento) {
        if (buscar(raiz, elemento)) {
            return "Elemento " + elemento + " Encontrado.";
        }
        return "Elemento " + elemento + " No Encontrado.";
    }

    // CONTAR LOS NODOS DE UN ÁRBOL BINARIO
    private Integer contar(NodoArbolBinario<E> raiz) {
        if (raiz == null) {
            return 0;
        }
        Integer c1 = contar(raiz.getHijoIzquierdo());
        Integer c2 = contar(raiz.getHijoDerecho());
        Integer c3 = c1 + c2 + 1;
        return c3;

    }

    public String contar() {
        Integer cantidad = contar(raiz);
        return "El árbol tiene " + cantidad + " nodos.";
    }

    // SUMAR LOS NODOS DE UN ÁRBOL BINARIO
    private Integer sumar(NodoArbolBinario<E> raiz) {
        if (raiz == null) {
            return 0;
        }
        Integer c1 = sumar(raiz.getHijoIzquierdo());
        Integer c2 = sumar(raiz.getHijoDerecho());
        Integer e = (Integer) raiz.getElemento();
        Integer c3 = c1 + c2 + e;
        return c3;
    }

    public String sumar() {
        Integer cantidad = sumar(raiz);
        return "La suma de los nodos del árbol es: " + cantidad;
    }

    // CALCULAR LA ALTURA DE UN ÁRBOL BINARIO
    private Integer calcularAltura(NodoArbolBinario<E> raiz) {
        if (raiz == null) {
            return 0;
        }
        Integer h1 = calcularAltura(raiz.getHijoIzquierdo());
        Integer h2 = calcularAltura(raiz.getHijoDerecho());
        if (h1 > h2) {
            return h1 + 1;
        }
        return h2 + 1;
    }

    public String calcularAltura() {
        Integer altura = calcularAltura(raiz);
        return "La altura del árbol es: " + altura;
    }

    // BUSCAR EL NODO DE MAYOR VALOR DE UN ÁRBOL BINARIO
    private Integer buscarMayor(NodoArbolBinario<E> raiz) {
        if (raiz == null) {
            return 0;
        }
        Integer m1 = buscarMayor(raiz.getHijoIzquierdo());
        Integer m2 = buscarMayor(raiz.getHijoDerecho());
        Integer e = (Integer) raiz.getElemento();
        Integer m3 = e;

        if (m1 >= m2 && m1 >= m3) {
            return m1;
        }
        if (m2 >= m1 && m2 >= m3) {
            return m2;
        }
        return m3;
    }

    public String buscarMayor() {
        Integer mayor = buscarMayor(raiz);
        return "El Elemento de mayor valor es: " + mayor;
    }
}

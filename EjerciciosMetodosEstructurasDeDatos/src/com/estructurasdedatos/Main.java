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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila p = new Pila();
        /*p.poner("7");
        p.poner("9");
        p.poner("4");
        p.poner("4");
        p.poner("7");*/
        p.poner(1);
        p.poner(2);
        p.poner(3);
        p.poner(4);
        p.poner(5);

        /*while (!p.estaVacia()) {
            System.out.println(p.quitar());
        }*/
        System.out.println(imprimir(p));
    }

    public static String imprimir(Pila x) {
        String s = "";
        Pila y = new Pila<>();
        while (!x.estaVacia()) {
            Object elemento = x.quitar();
            s += "\n" + elemento;
            y.poner(elemento);
        }
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        return s;
    }

    public static Pila eliminarPrimerElemento(Pila x) {
        Pila y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        y.quitar();
        while (!y.estaVacia()) {
            x.poner(y.quitar());
        }
        return x;
    }

    public static void invertirExtremos(Pila x) {
        Object elementoAuxiliar = x.quitar();
        Pila y = new Pila<>();
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

    public static void copiarPila(Pila x) {
        Pila y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        while (!y.estaVacia()) {
            System.out.println(y.quitar());
        }
    }

    public static void eliminarElementoEspecifico(Pila x, Object elemento) {
        Object elementoAuxiliar = null;
        Pila y = new Pila<>();
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

    public static void eliminarElementosRepetidosConsecutivos(Pila x) {
        Object elemento = null;
        Pila y = new Pila<>();
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

    public static Pila invertirElementos(Pila x) {
        Pila y = new Pila<>();
        while (!x.estaVacia()) {
            y.poner(x.quitar());
        }
        return y;
    }
}

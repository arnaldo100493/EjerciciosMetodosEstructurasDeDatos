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
        Cola<Integer> lista = new Cola<>();
        lista.poner(1);
        lista.poner(2);
        lista.poner(3);
        lista.poner(4);
        lista.poner(5);

        System.out.println(lista.imprimir());
        
    }
 
}

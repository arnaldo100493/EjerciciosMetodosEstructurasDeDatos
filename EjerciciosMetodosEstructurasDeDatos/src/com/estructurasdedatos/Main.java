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
        lista.empujar(1);
        lista.empujar(2);
        lista.empujar(3);
        lista.empujar(4);
        lista.empujar(5);

        System.out.println(lista.imprimir());
        
    }
 
}

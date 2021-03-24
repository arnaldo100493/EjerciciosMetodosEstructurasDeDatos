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
        Pila<Integer> lista = new Pila<>();
        lista.poner(1);
        lista.poner(2);

        Integer cima = lista.cima();
        
        System.out.println(cima);

        //System.out.println(lista.imprimir());

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import java.util.Scanner;


/**
 *
 * @author daniel
 */
public class MetodoPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("holaaaa");
    }
     public static String retornar(){
        String entradaTeclado= "sdasda";
        System.out.println ("Por favor introduzca una cadena por teclado:");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        return entradaTeclado;
    }
     public static char[] concatenar(String mensaje){
         int largo = mensaje.length();
         char[] cadena = new char[largo]; 
         for(int i =0 ;i<largo;i++){
             
         
         }
         return cadena;
     }
}

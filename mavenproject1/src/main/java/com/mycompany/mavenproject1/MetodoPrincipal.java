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
        opciones();
    }
    public static void opciones(){
        String entradaTexto= "";
        System.out.println ("Escriba una '1' para encriptar y '2' para desencriptar");
        Scanner entradaEscaner = new Scanner (System.in); 
        entradaTexto = entradaEscaner.nextLine ();
        int valor = Integer.parseInt(entradaTexto);
        if (valor == 1){
            opcionEncriptar();
        }else{
            if(valor == 2){
                opcionDesencriptar();
            }else{
                System.out.println ("Opcion no valida");
                System.out.println (entradaTexto);
            }
        }
    }
     public static void opcionEncriptar(){
        String palabra= retornarTexto();
        int valor =1;
        int largo = palabra.length();
        int[] cadena = new int[largo];
        char[] cadenaChar = new char[largo];
        cadena= concatenar(palabra);
        valor = retornarClave();
        int[] mensajeEncriptado = encriptar(cadena,valor);
        cadenaChar = generadorChar(mensajeEncriptado);
        palabra = cadenaChar.toString();
        System.out.println ("el texto encriptado es:"); 
        System.out.println (cadenaChar); 
     }
     public static void opcionDesencriptar(){
         String palabra= retornarTexto();
        int valor =1;
        int largo = palabra.length();
        int[] cadena = new int[largo];
        char[] cadenaChar = new char[largo];
        cadena= concatenar(palabra);
        valor = retornarClave();
        int[] mensajeEncriptado = desencriptar(cadena,valor);
        cadenaChar = generadorChar(mensajeEncriptado);
        palabra = cadenaChar.toString();
        System.out.println ("el texto desencriptado es:");
        System.out.println (cadenaChar);
     }
    
     public static String retornarTexto(){
        String entradaTexto= "";
        System.out.println ("Por favor introduzca una cadena por teclado:");
        Scanner entradaEscaner = new Scanner (System.in); 
        entradaTexto = entradaEscaner.nextLine ();
        return entradaTexto;
    }
     public static Integer retornarClave(){
        String clave;
        int clav;
        Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println ("Por favor introduzca la clave:");
        
        clave = entradaEscaner.nextLine();
        clav = Integer.parseInt(clave);
        return clav;
    }
     public static int[] concatenar(String mensaje){
         int largo = mensaje.length();
         char[] cadena = new char[largo];
         int[] cadenaNumerica = new int[largo];
         cadena = mensaje.toCharArray();
         for(int i =0 ;i<largo;i++){
             cadenaNumerica[i] = Integer.valueOf(cadena[i]);
             //System.out.println (cadenaNumerica[i]);
         }
         return cadenaNumerica;
     }
     public static void ingresoNovalido(){
         System.out.println ("Ingreso no valido");
     }
     public static int[] encriptar(int[] cadenaNumerica , int clave){
         int largo = cadenaNumerica.length;
         int[] mensajeEncriptado = cadenaNumerica;
         int valor=0;
         for(int i = 0 ; i<largo;i++){
             valor = (cadenaNumerica[i])+clave;
             mensajeEncriptado[i]=valor;
         }
         return mensajeEncriptado;
     }
     public static int[] desencriptar(int[] cadenaNumerica , int clave){
         int largo = cadenaNumerica.length;
         int[] mensajeDesencriptado = cadenaNumerica;
         int valor=0;
         for(int i = 0 ; i<largo;i++){
             valor = (cadenaNumerica[i])-clave;
             mensajeDesencriptado[i]=valor;
         }
         return mensajeDesencriptado;
     }
     public static char[] generadorChar(int[] cadenaNumerica){
         int largo = cadenaNumerica.length;
         char[] mensajeEncriptado = new char[largo];
         for(int i = 0 ; i<largo;i++){
             mensajeEncriptado[i]= (char)cadenaNumerica[i];
         }
         return mensajeEncriptado;
     }
}

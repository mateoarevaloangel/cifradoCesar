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
        /**
         * La funcion opcion pide al usuario que acceda a una opcion
         */
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
    /**
     * pone a correr el encriptado y imprime el mensaje encriptado
     */
     public static void opcionEncriptar(){
        String palabra= retornarTexto();
        int valor =0;
        int largo = palabra.length();
        int[] cadena = new int[largo];
        char[] cadenaChar = new char[largo];
        cadena= concatenar(palabra);
        valor = retornarClave();
        valor = validacion(valor);
        int[] mensajeEncriptado = encriptar(cadena,valor);
        cadenaChar = generadorChar(mensajeEncriptado);
        palabra = cadenaChar.toString();
        System.out.println ("el texto encriptado es:"); 
        System.out.println (cadenaChar); 
     }
     public static int validacion(int valor){
         if(valor >128){
             valor = valor%128;
         }else{
             if(valor<-128){
                 valor = (-1*valor)%128;
            }
         }
         System.out.println ("ESTE ES VALOR INGRESADO"+valor);
         return valor;
     }
     /**
     * pone a correr el desencriptado y imprime el mensaje desencriptado
     */
     public static void opcionDesencriptar(){
         String palabra= retornarTexto();
        int valor =1;
        int largo = palabra.length();
        int[] cadena = new int[largo];
        char[] cadenaChar = new char[largo];
        cadena= concatenar(palabra);
        valor = retornarClave();
        valor = validacion(valor);
        int[] mensajeEncriptado = desencriptar(cadena,valor);
        cadenaChar = generadorChar(mensajeEncriptado);
        palabra = cadenaChar.toString();
        System.out.println ("el texto desencriptado es:");
        System.out.println (cadenaChar);
     }
     /**
      * 
      * @return retorna un string con la entrada que ingreso el usuario como texto a encriptar o des encriptar
      */
     public static String retornarTexto(){
        String entradaTexto= "";
        System.out.println ("Por favor introduzca una cadena por teclado:");
        Scanner entradaEscaner = new Scanner (System.in); 
        entradaTexto = entradaEscaner.nextLine ();
        return entradaTexto;
    }
     /**
      * 
      * @return retorna un int con la entrada que ingreso el usuario como clave a encriptar o des encriptar
      */
     public static Integer retornarClave(){
        String clave;
        int clav;
        Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println ("Por favor introduzca la clave:");
        clave = entradaEscaner.nextLine();
        clav = Integer.parseInt(clave);
        return clav;
    }
     /**
      * comvertir el string de ingreso en un array de int
      * @param mensaje
      * @return un array de int con los numero que representan el mensaje ingresado
      */
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
     /**
      * encripta el mensaje 
      * @param cadenaNumerica
      * @param clave
      * @return el mensaje encriptado en una array int
      */
     public static int[] encriptar(int[] cadenaNumerica , int clave){
         int largo = cadenaNumerica.length;
         int[] mensajeEncriptado = cadenaNumerica;
         int valor=0;
         for(int i = 0 ; i<largo;i++){
             valor = (cadenaNumerica[i])+clave;
             System.out.println (valor);
             if(valor>128){
                 valor=valor %128;
             }
             mensajeEncriptado[i]=valor;
         }
         return mensajeEncriptado;
     }
     /**
      * 
      * @param cadenaNumerica
      * @param clave
      * @return el mensaje encriptado en una array int
      */
     public static int[] desencriptar(int[] cadenaNumerica , int clave){
         int largo = cadenaNumerica.length;
         int[] mensajeDesencriptado = cadenaNumerica;
         int valor=0;
         for(int i = 0 ; i<largo;i++){
             valor = (cadenaNumerica[i])-clave;
             if(valor<0){
                 valor=128+valor;
             }
             mensajeDesencriptado[i]=valor;
         }
         return mensajeDesencriptado;
     }
     /**
      * comvertir el array int de entrada en un array char
      * @param cadenaNumerica
      * @return retorna un array 
      */
     public static char[] generadorChar(int[] cadenaNumerica){
         int largo = cadenaNumerica.length;
         char[] mensajeEncriptado = new char[largo];
         for(int i = 0 ; i<largo;i++){
             mensajeEncriptado[i]= (char)cadenaNumerica[i];
         }
         return mensajeEncriptado;
     }
}

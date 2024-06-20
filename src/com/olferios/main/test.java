package com.olferios.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class test {
    public static void main(String[] args) {
        juego();
    }
    public static void juego(){
        List<String> palabras=Arrays.asList("Spiderman","Capitan America","capitan Veneco");
        int i=0;
        while (i<palabras.size()){
            System.out.println(palabras.get(i));
            i++;
        }
        Random rand=new Random();
        String palabraJuego = palabras.get(rand.nextInt(palabras.size()));
        System.out.println("La palabra a adivinar es: "+palabraJuego);

        List<Character> jugadores=new ArrayList<>();
        System.out.println();

        int intentos = 0;
        while(true)
        {
            if(intentos>=6){
                JOptionPane.showMessageDialog(null,"perdiste :(");
                break;
            }
            impresionPalabras(palabraJuego,jugadores);
            if (!jugando(palabraJuego,jugadores)){
                intentos++;
                
            }
            
            impresionPalabras(palabraJuego,jugadores);
            if (impresionPalabras(palabraJuego,jugadores)){
                JOptionPane.showMessageDialog(null,"Ganaste PErro :D");
                break;
            }
            //String tmp=JOptionPane.showMessageDialog("si sabe la palabra digala perro");
        }
    }

    private static boolean jugando(String palabraJuego,List<Character>jugadores){
        String letra= JOptionPane.showInputDialog("Digite una palabra");
        jugadores.add(letra.charAt(0));
        return palabraJuego.contains(letra);
    }
    private static boolean impresionPalabras(String palabraJuego,List<Character>jugadores){
        String concatena="";
        int correctas=0;
        for(int i=0; i<palabraJuego.length(); i++)
        {
            if(jugadores.contains(palabraJuego.charAt(i))){
                concatena=concatena+palabraJuego.charAt(i);
                correctas++;
            }else{
                concatena=concatena+"_";
            }
           

        }
        JOptionPane.showMessageDialog(null,concatena);
        return(palabraJuego.length()==correctas);

    }
}

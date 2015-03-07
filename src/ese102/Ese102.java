/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese102;
import complexnumber.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Giulio Paparelli
 */
public class Ese102 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
        public static void main(String[] args) throws IOException {

        ComplexNumber cn = new ComplexNumber();
        ComplexNumber addendo = new ComplexNumber();
        String type = "";
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        String line = "";
        float tipo;
        double re,im;
        double mod,arg;
        re = 0.0;
        im = 0.0;
        mod = 0.0;
        arg = 0.0;
        boolean vValido = false;

        System.out.println("Ti serve un programma per la gestione dei numeri complessi?");
        System.out.println("La Paparellium Corporation ha la soluzione.");
        System.out.println("Scrivi '1' per inserire modulo e argomento");
        System.out.println("Scrivi '2' per inserire coordinate gaussiane");
        type = tastiera.readLine();
        tipo=(Float.valueOf(type).floatValue());

        if(tipo == 1){
            while (!vValido){
                System.out.println("inserisci il modulo");
                line = tastiera.readLine();
                try{
                    mod=(Float.valueOf(line).floatValue());
                    vValido = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("riprova");
                }
            }
        vValido = false;
            while (!vValido){
                System.out.println("inserisci l'argomento");
                line = tastiera.readLine();
                try{
                    arg = (Float.valueOf(line).floatValue());
                    vValido = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("riprova");
                }   
            }
            cn.setPolar(mod, arg);
            System.out.print("real :  "+cn.getReal());
            System.out.print("\n\n");
            System.out.print("immaginary :  "+cn.getImmaginary());
            System.out.print("\n\n");
        }
        else if (tipo == 2){
            while (!vValido){
                System.out.println("Inserisci la parte reale di un numero complesso");
                line = tastiera.readLine();
                try{
                    re=(Float.valueOf(line).floatValue());
                    vValido = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("riprova");
                }

            }
            vValido = false;
            while (!vValido){
                System.out.println("Inserisci la parte immaginaria di un numero complesso");
                line = tastiera.readLine();
                try{
                    im = (Float.valueOf(line).floatValue());
                    vValido = true;
                }
                catch(NumberFormatException ex){
                    System.out.println("riprova");
                }   
            }
            cn.setRectangular(im, re);
            System.out.print("argument:  "+cn.getArgument());
            System.out.print("\n\n");
            System.out.print("modulus:  "+cn.getModulus());
            System.out.print("\n\n");
        }
    }
}

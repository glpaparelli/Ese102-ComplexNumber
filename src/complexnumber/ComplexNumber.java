/**
*
* Non sono presenti costruttori perche riceverebbe due campi di tipo double.
* la classe gestice coordinate rettangolari che polari
* Sono presenti solo 2 metodi Setter lavorano in coppia 
* Sono presenti 4 metodi Getter poichè un metodo deve ritornare un solo valore.
* 
*/

package complexnumber;
import static java.lang.Math.*;

public class ComplexNumber {
    private double re;
    private double im;
    
    public String formatComplexNumber() {
        String r = this.getRe() + "+(" + this.getIm() + ")i";
        return r;
    
    }
    /**
     * @return the re
     * metodo per la lettura della parte reale 
     * di un numero compless o
     */
    public double getRe() {
        return re;
    }
    
    /**
     * @return the im
     *metodo per la lettura della parte immaginaria
     * di un numero complesso. 
     */
    public double getIm() {
        return im;
    }  
    /**
     * 
     * @return
     * ritorna un valore di tipo double
     * 
     */
    
    public double getModulus(){    
        return (Math.sqrt((Math.pow(this.re,2))+(Math.pow(this.im,2))));
    }
    /**
     * 
     * @return
     * metodo che ritorna un valore espresso in gradi 
     * e non in radianti.
     */
    
    
    public double getArgument(){
      
        double r = 0;

        if(re==0 && im==0) 
            r=0;

        else if ((re < 0 && im > 0) || (re < 0 && im <= 0))
                r = Math.toDegrees((Math.atan(im / re))) + 180; // 2^ e 3^
        
        else if (re >= 0 && im < 0)
                r = Math.toDegrees((Math.atan(im / re))) + 360; // 4^
       
        else if (re >= 0 && im >= 0)
                r = Math.toDegrees((Math.atan(im / re))); // 1^ quadrante del
        
        return r;
    }
    /**
     * 
     * @return
     * metodi non indispensabili ma rendono 
     * più user friendly la classe
     * 
     */
    public double getReal(){
        return this.re;
    }
    
    public double getImmaginary(){
        return this.im;
    }
    
    /**
     * 
     * @param im
     * @param re
     * entrambi di tipo double
     * il metodo è necessario per scrivere 
     * nei campi dell'oggetto quando si usano le 
     * coordinate rettangolari
     */
    public void setRectangular(double im, double re){
        this.re=re;
        this.im=im;
    }
    /**
     * 
     * @param argument
     * @param modulus
     * entrambi di tipo double
     * metodo necessario per per scrivere le coordinate 
     * polari nei campi re e im.
     */
    
    
    public void setPolar(double argument, double modulus){
//       this. re =  cos((argument*PI)/180)*modulus;
//        this.im =  sin((argument*PI)/180)*modulus;
         if (argument == 90 || argument == 270)
            this.re = 0;
        else
            this.re = modulus * (Math.cos((argument) * Math.PI / 180));
        
        if (argument == 180 || argument == 360)
            this.im = 0;
        else  
            this.im = modulus * (Math.sin((argument) * Math.PI / 180));
    }
    
//    public void setPolars(double mod,double arg){
//        this.re = mod;
//        this.im = arg;
//    }
}


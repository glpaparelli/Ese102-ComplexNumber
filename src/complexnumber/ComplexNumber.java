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
        return ((Math.atan(this.im / this.re)*180)/Math.PI); 
    }
    /**
     * 
     * @return
     * metodi che ritornano parte reale e immaginaria 
     * (non indispensabili ma UF)
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
            
        this.re = modulus * (Math.cos((argument) * Math.PI / 180));
        this.im = modulus * (Math.sin((argument) * Math.PI / 180));
    }
    
    public ComplexNumber add(ComplexNumber operand){
        
        ComplexNumber somma = new ComplexNumber();
        
        double re = 0;
        double im = 0;
        
        re = this.re + somma.getRe();
        im = this.im + somma.getIm();
        somma.setRectangular(im, re);
        return somma;
    }
    
     public ComplexNumber subtration (ComplexNumber operand){
        
        ComplexNumber sub = new ComplexNumber();
        
        double re = 0;
        double im = 0;
        
        re = this.re - sub.getRe();
        im = this.im - sub.getIm();
        sub.setRectangular(im, re);
        return sub;
    }
     
    public ComplexNumber moltiplication (ComplexNumber operand){
        
        ComplexNumber mul = new ComplexNumber();
        
        double re = 0;
        double im = 0;
        
        re = this.getModulus() * mul.getModulus();
        im = this.getArgument() + mul.getArgument();
        mul.setPolar(im, re);
        return mul;
    }
    
    public ComplexNumber division (ComplexNumber operand){
        
        ComplexNumber div = new ComplexNumber();
        
        double re = 0;
        double im = 0;
        
        re = this.getModulus() / div.getModulus();
        im = this.getArgument() + div.getArgument();
        div.setPolar(re, im);
        return div;
    }
    
    public ComplexNumber getConjugate(){
        
        ComplexNumber r = new ComplexNumber();
        this.re = r.getRe();
        this.im = r.getIm();
        
        this.re *= -1;
        r.setRectangular(im, re);
        return r; 
    }
}


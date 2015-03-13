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
    
    static private double initRe;
    static private double initIm;
    
    static private StringFormat initFormat;
    private double re;
    private double im;
    private StringFormat format;
    
    
    /**
     * vengono definiti i valori che possono essere 
     * assunti da una variabile di tipo StringFormat
     */
      static public enum  StringFormat{
        RECTANGULAR,
        POLAR
    }
    
    public void setStringFormat(StringFormat format) {
	this.format = format;
    }  
      
      
    /**
     * si inizializzano i campi initre, initim e il formato di 
     * rappresentazione
     * @param re
     * @param im 
     */  
      
    static public void setInitRectangular(double re, double im) {
        initRe = re;
        initIm = im;
    }
    
    
    public ComplexNumber() {
        this.re = initRe;
        this.im = initIm;
        this.format= initFormat;
    }
    
    
    /**
     * si inizializzano i campi initre, initim e il formato di 
     * rappresentazione
     * @param modulus
     * @param argument
     */  
    static public void setInitPolar(double modulus, double argument){
        if (modulus < 0 )
            throw new IllegalArgumentException("il modulo deve essere 0 o maggiore");
        initRe = modulus*Math.cos(argument);
        initIm = modulus*Math.sin(argument);
        initFormat = StringFormat.RECTANGULAR;
    }

    
    public String formatComplexNumber() {
        String r = this.getRe() + "+(" + this.getIm() + ")i";
        return r;
    
    }
    
    public String formatComplexNumberpolar() {
        String r = this.getArgument()+ "+(" + this.getModulus()+ ")i";
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
        double argument = 0;
            if(re == 0 || im == 0){
                argument = 0;
                    if(im > 0)
			argument = 90;
                    else if(im < 0)
			argument = 270;
            }
            else{
		argument = Math.toDegrees(Math.atan(this.im/this.re));
		if (re < 0 && im > 0 || re < 0 && im < 0)
                        argument =argument + 180;
                    else if (re > 0 && im < 0)
			argument =argument + 360;
		}
    return argument;
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
     public void setPolar(double modulus, double argument){
        if(modulus >= 0){
            this.re = Math.cos(argument*Math.PI/180)*modulus;
	    if(argument == 180)
	        this.im = 0;
	    else
	       	this.im = Math.sin(argument*Math.PI/180)*modulus;
        }
        else
            throw new IllegalArgumentException("INSERISCI UN VALORE MAGGIORE DI 0");
    }
    
    /**
     * operazione di somma
     * @param operand1
     * @param operand2
     * @return 
     */
    
    public static ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2) {
        ComplexNumber r = new ComplexNumber();
        r.setRectangular(operand1.getRe()+operand2.getRe(), operand1.getIm() + operand2.getIm());
        return r;
    }
    
    /**
     * operazione di sottrazione
     * @param operand1
     * @param operand2
     * @return 
     */
     static public  ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber r= new ComplexNumber();
        r.setRectangular(operand1.getRe()-operand2.getRe(),operand1.getIm() - operand2.getIm());
        return r;
    }
    
    /**
     * operazione di moltiplicazione
     * @param operand1
     * @param operand2
     * @return 
     */ 
    static public  ComplexNumber multiply(ComplexNumber operand1,ComplexNumber operand2){
        ComplexNumber r = new ComplexNumber();
        r.setPolar(operand1.getModulus()*operand2.getModulus(),operand1.getArgument()+operand2.getArgument());
        return r;
    }
     
    /**
     * operazione di divisione
     * @param operand1
     * @param operand2
     * @return 
     */
    static public ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2){
        ComplexNumber r= new ComplexNumber();
        r.setPolar(operand1.getModulus()/operand2.getModulus(), operand1.getArgument()-operand2.getArgument());
        return r;
    }
    
    /** cambia di segno la parte immaginaria
     * @return 
     */
    
    public ComplexNumber getConjugate(){
        
        ComplexNumber r = new ComplexNumber();
        this.re = r.getRe();
        this.im = r.getIm();
        
        this.im *= -1;
        r.setRectangular(im, re);
        return r; 
    }
    
     public String toString(StringFormat format) {
        String r = new String();
        switch(format) {
		case RECTANGULAR:
			r = this.re + "+(" + this.im + ")i";
			break;
		case POLAR:
			r = this.getModulus() + "*exp(i*" + this.getArgument() +")";
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return r;
    }
    
    @Override public String toString(){
        return toString(this.format);
    }
}


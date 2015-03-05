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
     */
    public double getRe() {
        return re;
    }
    
    /**
     * @return the im
     */
    public double getIm() {
        return im;
    }  
    
    public double getModulus(){    
        return (Math.sqrt((Math.pow(this.re,2))+(Math.pow(this.im,2))));
    }
    
    public double getArgument(){
        double arg=-1;
        if(this.im!=0 || this.re!=0){
            arg = Math.atan((((this.im  / this.re )*180)/Math.PI));
             
        }
        return (arg);
    }
    
    public double getReal(){
        return this.re;
    }
    
    public double getImmaginary(){
        return this.im;
    }
    
    public void setRectangular(double im, double re){
        this.re=re;
        this.im=im;
    }
    
    public void setPolar(double argument, double modulus){
//       this. re =  cos((argument*PI)/180)*modulus;
//        this.im =  sin((argument*PI)/180)*modulus;
        argument *= (PI/180);
        
        this.re = Math.cos((argument))*modulus;
        this.im = Math.sin((argument))*modulus;
    }
    
//    public void setPolars(double mod,double arg){
//        this.re = mod;
//        this.im = arg;
//    }
}


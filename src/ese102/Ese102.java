package ese102;

import complexnumber.*;
import complexnumber.ComplexNumber.StringFormat;

public class Ese102
{
	public static void main(String[] args)
	{
		ComplexNumber.setInitRectangular(0, 0);
		ComplexNumber c1 = new ComplexNumber();
		ComplexNumber.setInitRectangular(1, 1);
		ComplexNumber c2 = new ComplexNumber();
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("Addiction: " + c1.add(c2));
		ComplexNumber r = c1.add(c2);
		r.setStringFormat(ComplexNumber.StringFormat.POLAR);
		System.out.println("Addiction (polar): " + r);
		System.out.println("Subtraction: " + c1.sub(c2));
		/* Domanda: come posso controllare il formato della
		 * rappresentazione a stringa del risultato dell'operazione, senza dover assegnare
		 * il risultato ad una variabile?
		 */
		System.out.println("Subtraction (polar): " + c1.sub(c2));
    }
}
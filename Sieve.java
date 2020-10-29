/** 
 * implements an algorithm 
 * for generating prime numbers.
 * 
 * @author Mingi Lee with the assistance of Shervin Hajiamini 
 * Email leemingi@grinnell.edu
 * Date September 15 2020
*/

public class Sieve {

    /**
     * declaration for two fields
     * source is a reference to the another field in Sieve.
     * factor is a number whose multiples it is trying to block.  
     */
    private Sieve source;
    private int factor;
    
    /**
     *  constructs a base Sieve. 
     */
    public Sieve() {
    	/*initialize instance fields */
      this.source = null;
      this.factor = 1;
    }
    
    /** 
     * constructs a Sieve using a prime number
     * and a predecessor sieve 
     * @param divisor prime number.
     * @param predecessor sieve.
     */
    public Sieve(int divisor, Sieve predecessor) {
      /* TODO: initialize instance fields */
      this.factor = divisor;
      this.source = predecessor;
    }
    
    /**
     * returns the next integer in the ascending. 
     * order. This integer is either the next 
     * prime number or divisible by factor.
     * @return the next integer . 
     */

    public int next() {
    	if(this.source == null) {
    		/* increments the current integer 
    		 * and returns it. 
    		 */
        //the next method in base sieve will do the work of generating the integers in ascending order
        this.factor++; 
        return this.factor;
    	} else {
        int candidate = 0;

        //get candidate by calling next() recursively.
        candidate = source.next();
        
        //if candidate is divisible by factor, call next() recursively.
        if (candidate % factor == 0)
        candidate = source.next();

        return candidate;
        
    		}
    }

    public static void main(String[] args) {
        Sieve sifter = new Sieve(); // creating base Sieve and assigning to sifter.
        /* generate the first 500 prime numbers.
         */
        for(int count = 0; count < 500; count++) {
          
          int prime = sifter.next(); // get the next prime number by calling next
          Sieve prevSieve = sifter; // prevSieve is the the Sieve currently stored in sifter
          
          System.out.print(String.format("%7d",prime));	 // print the prime number
          
          //in every ten prime, print a new line
          if(count % 10 == 9) {
           System.out.println();	  
          }
          
          //assign new Sieve with new prime
          sifter = new Sieve(prime, prevSieve);

        }
	}
}

/* Copyright 2020 Shervin Hajiamini 
   I am indebted to my colleague, John  Stone, for assistance with this file. 
 */

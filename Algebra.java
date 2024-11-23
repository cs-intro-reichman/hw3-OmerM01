// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    // System.out.println(plus(2,3));   // 2 + 3
	    // System.out.println(minus(7,2));  // 7 - 2
   		// System.out.println(minus(2,7));  // 2 - 7
 		// System.out.println(times(3,4));  // 3 * 4
   		// System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		// System.out.println(pow(5,3));      // 5^3
   		// System.out.println(pow(3,5));      // 3^5
   		// System.out.println(div(12,3));   // 12 / 3    
   		// System.out.println(div(5,5));    // 5 / 5  
   		// System.out.println(div(25,7));   // 25 / 7
   		// System.out.println(mod(25,7));   // 25 % 7
   		// System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
   		// System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 < 0){
			for (int i = 0; i < Math.abs(x2); i++) {
				x1--;
			}
		} else{
			for(int i = 0; i < x2; i++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if(x2 < 0){
			return plus(x1, Math.abs(x2));
		}
		for(int i = 0; i < x2; i++){
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		if(x1 == 0 || x2 == 0){
			return 0;
		}

		boolean isNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0); // checked whether one of the variebles are negative
		x2 = Math.abs(x2);
		x1 = Math.abs(x1);
		int result = 0;

		for(int i = 0; i < x2 ; i++){
				result = plus(result, x1);
		}

		if (isNegative) {
			result = minus(0, result); // here i used the minus function to flip the sign
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// firts, handle the '0' and '1' end cases
		if(x == 0) return 0;
		if(n == 0) return 1;
		if (n == 1) return x;

		//check if n is odd or even
		int counter = 0;
		while(counter < n){
			counter = plus(counter, 2);
		}
		boolean is_n_Even = (counter == n);

		boolean is_x_Negative = (x < 0); //check if x is negative

		//do the real power action
		x = Math.abs(x);
		int result = x;
   		for (int i = 0; i < n - 1; i++) {
        	result = times(result, x); 
    	}

		//uses the bolleanes we've created to fix the sign of the realust (negative values)
    	if (is_x_Negative && !is_n_Even) {
        	result = minus(0, result); // Flip the sign
    	}

    	return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x1 == 0) return 0;
		if(x2 == 0) return -1;

		boolean isNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0); 
		x1 = Math.abs(x1);
    	x2 = Math.abs(x2);

		int div = 0;
		while(div * x2 <= x1){
			div++;
		}
		div--; //becuase if 7/2 for example, we need to lower div by 1 becuase at the last iteration it will be 4. (7/2=3)

		if(isNegative) return minus(0, div);
		return div;
	}
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if(x1 == 0) return 0;
		if(x2 == 0) return x1;

		//does the remainder calculation 
		int div = div(x1, x2);
		int remainder = minus(x1,times(div, x2));

		//checkes end test cases
		if(remainder < 0 && x2 > 0){
			remainder = plus(remainder, x2);
		} else if(remainder > 0 && x2 < 0){
			remainder = minus(remainder, x2);
		}

		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if(x == 0) return 0;
		if(x == 1) return 1;
		if(x < 0) return -1;
		
		int sqrt = 1;
		while(sqrt <= div(x, sqrt)){
			sqrt ++;
		}
		sqrt--;
		return sqrt;
	}	  	  
}
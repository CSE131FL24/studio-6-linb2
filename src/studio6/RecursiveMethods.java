package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {
	public static final int radiouse= 1;
	
	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum( int n) {
		if (n == 0) { // base case
			return 0;
		}
		return 1 / Math.pow(2, n) + geometricSum(n - 1); // recursive step
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		if (radius < radiusMinimumDrawingThreshold) {
			return;
		} else {
			StdDraw.circle(xCenter, yCenter, radius);
			// reduce the radius in each recursive call
			circlesUponCircles(xCenter, yCenter + radius, radius / 2, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter, yCenter - radius, radius / 2, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter + radius, yCenter, radius / 2, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius / 2, radiusMinimumDrawingThreshold);
		}
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but in reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reverseArray = new int[array.length];
		return HelpertoReversed(array, reverseArray, 0);
	}

	// Helper method to recursively reverse the array
	public static int[] HelpertoReversed(int[] original, int[] reversed, int index) {
		if (index == original.length) { // base case
			return reversed;
		} else { // recursive case
			reversed[index] = original[original.length - 1 - index];
			return HelpertoReversed(original, reversed, index + 1); // correctly increment the index
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor for the two
	 * input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0) { // base case
			return p;
		} else { // recursive case
			return gcd(q, p % q);
		}
	}
}


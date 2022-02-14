package com.ylisuutala.mortgageplan;

public class Math {
    public static double pow(double n, int exponent) {
	double result = 1.0;
	if (exponent < 0)
	    return 1 / Math.pow(n, -1 * exponent);
	for (int i = 0; i < exponent; i++) {
	    result *= n;
	}
	return result;
    }
    
    public static double roundHundredths(double n) {
	double decimals = n % 0.01;
	if (decimals < 0.005) {
	    return n - decimals;
	} else {
	    return n - decimals + 0.01;
	}
    }
}

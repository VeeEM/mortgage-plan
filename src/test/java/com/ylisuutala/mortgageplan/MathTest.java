package com.ylisuutala.mortgageplan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    public void powerOfZero() {
	assertEquals(1.0, Math.pow(3, 0));
	assertEquals(1.0, Math.pow(13, 0));
	assertEquals(1.0, Math.pow(-4, 0));
    }
    
    @Test
    public void negativePowers() {
	assertEquals(0.25, Math.pow(4, -1));
	assertEquals(0.03125, Math.pow(2, -5));
	assertEquals(-0.03125, Math.pow(-2, -5));
    }
    
    @Test
    public void positivePowers() {
	assertEquals(25, Math.pow(5, 2));
	assertEquals(27, Math.pow(3, 3));
	assertEquals(-2197, Math.pow(-13, 3));
    }
    
    @Test
    public void roundHundredths() {
	assertEquals(0.12, Math.roundHundredths(0.12345));
	assertEquals(0.13, Math.roundHundredths(0.12567));
    }
}

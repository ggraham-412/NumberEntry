package com.widgetmath.handycalculator.utils;

import java.math.BigDecimal;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestNumberEntry_Fractional extends TestCase {
    
    public void setUp() {
    }

    public void tearDown() {
    }

    public void testAddDigit0() {
        System.out.println("@Test - testAddDigit0");
        INumberEntry number = new NumberEntry_Fractional();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit1() {
        System.out.println("@Test - testAddDigit1");
        INumberEntry number = new NumberEntry_Fractional();
        number.addDigit(1);
        number.addDigit(2);
        number.pushDot(8);
        number.addDigit(6);
        Assert.assertEquals("12.75", number.getValue().toString());
        number.negate();
        Assert.assertEquals("-12.75", number.getValue().toString());
    }

    public void testAddDigit2() {
        System.out.println("@Test - testAddDigit2");
        INumberEntry number = new NumberEntry_Fractional();
        number.addDigit(4);
        number.addDigit(5);
        number.addDigit(2);
        number.negate();
        number.pushDot(16);
        number.addDigit(1);
        number.addDigit(1);
        Assert.assertEquals("-452.6875", number.getValue().toString());
        number.negate();
        Assert.assertEquals("452.6875", number.getValue().toString());
    }

    public void testNegate() {
        System.out.println("@Test - testNegate");
        INumberEntry number = new NumberEntry_Fractional();
        number.negate();
        Assert.assertEquals(false, number.isNegative());
        number.addDigit(1);
        Assert.assertEquals(false, number.isNegative());
        number.negate();
        Assert.assertEquals(true, number.isNegative());
        number.negate();
        Assert.assertEquals(false, number.isNegative());
    }

    public void testDotPush() {
        System.out.println("@Test - testDotPush");
        INumberEntry number = new NumberEntry_Fractional();
        Assert.assertEquals(false, number.isDotPushed());
        number.addDigit(1);
        Assert.assertEquals(false, number.isDotPushed());
        number.pushDot(16);
        Assert.assertEquals(true, number.isDotPushed());
        number.addDigit(4);
        Assert.assertEquals(true, number.isDotPushed());        
    }

    public void testSetValue1() {
        System.out.println("@Test - testSetValue1");
        INumberEntry number = new NumberEntry_Fractional();
        number.setValue(new BigDecimal("123.6875"),16);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(false, number.isNegative());
        Assert.assertEquals("123", number.getIntegerPart().toString());
        Assert.assertEquals("11", number.getFractionalPart().toString());
        Assert.assertEquals("0", number.getRemainder().toString());
        number.clear();
        Assert.assertEquals(false, number.isDotPushed());        
        number.setValue(new BigDecimal("-123.6875"), 16);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(true, number.isNegative());
        Assert.assertEquals("123", number.getIntegerPart().toString());
        Assert.assertEquals("11", number.getFractionalPart().toString());
        Assert.assertEquals("0", number.getRemainder().toString());
        number.setValue(new BigDecimal("123"), 16);
        Assert.assertEquals(false, number.isDotPushed());        
        number.setValue(new BigDecimal("123.00"), 16);
        Assert.assertEquals(false, number.isDotPushed());        
    }

    public void testSetValue2() {
        System.out.println("@Test - testSetValue1");
        INumberEntry number = new NumberEntry_Fractional();
        number.setValue(new BigDecimal("33.75"), 2);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(false, number.isNegative());
        Assert.assertEquals("33", number.getIntegerPart().toString());
        Assert.assertEquals("1", number.getFractionalPart().toString());
        Assert.assertEquals("0.25", number.getRemainder().toString());

        number.setValue(new BigDecimal("-33.75"), 2);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(true, number.isNegative());
        Assert.assertEquals("33", number.getIntegerPart().toString());
        Assert.assertEquals("1", number.getFractionalPart().toString());
        Assert.assertEquals("0.25", number.getRemainder().toString());
    }

}
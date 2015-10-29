package com.widgetmath.handycalculator.utils;

import java.math.BigDecimal;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestNumberEntry_Decimal extends TestCase {
    
    public void setUp() {
    }

    public void tearDown() {
    }

    public void testAddDigit0() {
        System.out.println("@Test - testAddDigit0");
        INumberEntry number = new NumberEntry_Decimal();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit1() {
        System.out.println("@Test - testAddDigit1");
        INumberEntry number = new NumberEntry_Decimal();
        number.addDigit(1);
        number.addDigit(5);
        number.addDigit(2);
        number.pushDot(0);
        number.addDigit(1);
        number.addDigit(1);
        Assert.assertEquals("152.11", number.getValue().toString());
    }

    public void testAddDigit2() {
        System.out.println("@Test - testAddDigit2");
        INumberEntry number = new NumberEntry_Decimal();
        number.addDigit(4);
        number.addDigit(5);
        number.addDigit(2);
        number.negate();
        number.pushDot(0);
        number.addDigit(1);
        number.addDigit(1);
        Assert.assertEquals("-452.11", number.getValue().toString());
        number.negate();
        number.addDigit(6);
        Assert.assertEquals("452.116", number.getValue().toString());
    }

    public void testAddDigit3() {
        System.out.println("@Test - testAddDigit3");
        INumberEntry number = new NumberEntry_Decimal();
        number.addDigit(4);
        number.addDigit(5);
        number.addDigit(2);
        number.pushDot(0);
        number.addDigit(1);
        number.addDigit(1);
        number.clear();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit4() {
        System.out.println("@Test - testAddDigit4");
        INumberEntry number = new NumberEntry_Decimal();
        number.negate();
        Assert.assertEquals("0", number.getValue().toString());
        number.addDigit(0);
        number.addDigit(0);
        number.addDigit(0);
        Assert.assertEquals("0", number.getValue().toString());
        number.pushDot(0);
        number.addDigit(0);
        number.addDigit(0);
        Assert.assertEquals("0", number.getValue().toString());
        number.addDigit(7);
        Assert.assertEquals("0.007", number.getValue().toString());
    }

    public void testNegate() {
        System.out.println("@Test - testNegate");
        INumberEntry number = new NumberEntry_Decimal();
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
        INumberEntry number = new NumberEntry_Decimal();
        Assert.assertEquals(false, number.isDotPushed());
        number.addDigit(1);
        Assert.assertEquals(false, number.isDotPushed());
        number.pushDot(0);
        Assert.assertEquals(true, number.isDotPushed());
        number.addDigit(4);
        Assert.assertEquals(true, number.isDotPushed());        
    }

    public void testSetValue1() {
        System.out.println("@Test - testSetValue1");
        INumberEntry number = new NumberEntry_Decimal();
        number.setValue(new BigDecimal("123.456"),0);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(false, number.isNegative());
        Assert.assertEquals("123", number.getIntegerPart().toString());
        Assert.assertEquals("456", number.getFractionalPart().toString());
        number.clear();
        Assert.assertEquals(false, number.isDotPushed());        
        number.setValue(new BigDecimal("-123.456"),0);
        Assert.assertEquals(true, number.isDotPushed());        
        Assert.assertEquals(true, number.isNegative());
        Assert.assertEquals("123", number.getIntegerPart().toString());
        Assert.assertEquals("456", number.getFractionalPart().toString());
        number.setValue(new BigDecimal("123"),0);
        Assert.assertEquals(false, number.isDotPushed());        
        Assert.assertEquals("123", number.getIntegerPart().toString());
        Assert.assertEquals("0", number.getFractionalPart().toString());
        number.setValue(new BigDecimal("123.00"),0);
        Assert.assertEquals(false, number.isDotPushed());        
    }

}
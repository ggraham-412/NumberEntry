package com.widgetmath.handycalculator.utils;

import java.math.BigDecimal;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestNumberEntry_Wrapper extends TestCase {
    
    public void setUp() {
    }

    public void tearDown() {
    }

    public void testAddDigit0_frac() {
        System.out.println("@Test - testAddDigit0_frac");
        INumberEntry number = new NumberEntry_Wrapper();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit1_frac() {
        System.out.println("@Test - testAddDigit1_frac");
        INumberEntry number = new NumberEntry_Wrapper();
        number.addDigit(1);
        number.addDigit(2);
        number.pushDot(8);
        number.addDigit(6);
        Assert.assertEquals("12.75", number.getValue().toString());
        number.negate();
        Assert.assertEquals("-12.75", number.getValue().toString());
    }

    public void testAddDigit2_frac() {
        System.out.println("@Test - testAddDigit2_frac");
        INumberEntry number = new NumberEntry_Wrapper();
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

    public void testNegate_frac() {
        System.out.println("@Test - testNegate_frac");
        INumberEntry number = new NumberEntry_Wrapper();
        number.negate();
        Assert.assertEquals(false, number.isNegative());
        number.addDigit(1);
        Assert.assertEquals(false, number.isNegative());
        number.negate();
        Assert.assertEquals(true, number.isNegative());
        number.negate();
        Assert.assertEquals(false, number.isNegative());
    }

    public void testDotPush_frac() {
        System.out.println("@Test - testDotPush_frac");
        INumberEntry number = new NumberEntry_Wrapper();
        Assert.assertEquals(false, number.isDotPushed());
        number.addDigit(1);
        Assert.assertEquals(false, number.isDotPushed());
        number.pushDot(16);
        Assert.assertEquals(true, number.isDotPushed());
        number.addDigit(4);
        Assert.assertEquals(true, number.isDotPushed());        
    }

    public void testSetValue1_frac() {
        System.out.println("@Test - testSetValue1_frac");
        INumberEntry number = new NumberEntry_Wrapper();
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

    public void testSetValue2_frac() {
        System.out.println("@Test - testSetValue2_frac");
        INumberEntry number = new NumberEntry_Wrapper();
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

    public void testAddDigit0_dec() {
        System.out.println("@Test - testAddDigit0_dec");
        INumberEntry number = new NumberEntry_Wrapper();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit1_dec() {
        System.out.println("@Test - testAddDigit1_dec");
        INumberEntry number = new NumberEntry_Wrapper();
        number.addDigit(1);
        number.addDigit(5);
        number.addDigit(2);
        number.pushDot(0);
        number.addDigit(1);
        number.addDigit(1);
        Assert.assertEquals("152.11", number.getValue().toString());
    }

    public void testAddDigit2_dec() {
        System.out.println("@Test - testAddDigit2_dec");
        INumberEntry number = new NumberEntry_Wrapper();
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

    public void testAddDigit3_dec() {
        System.out.println("@Test - testAddDigit3_dec");
        INumberEntry number = new NumberEntry_Wrapper();
        number.addDigit(4);
        number.addDigit(5);
        number.addDigit(2);
        number.pushDot(0);
        number.addDigit(1);
        number.addDigit(1);
        number.clear();
        Assert.assertEquals("0", number.getValue().toString());
    }

    public void testAddDigit4_dec() {
        System.out.println("@Test - testAddDigit4_dec");
        INumberEntry number = new NumberEntry_Wrapper();
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

    public void testNegate_dec() {
        System.out.println("@Test - testNegate_dec");
        INumberEntry number = new NumberEntry_Wrapper();
        number.negate();
        Assert.assertEquals(false, number.isNegative());
        number.addDigit(1);
        Assert.assertEquals(false, number.isNegative());
        number.negate();
        Assert.assertEquals(true, number.isNegative());
        number.negate();
        Assert.assertEquals(false, number.isNegative());
    }

    public void testDotPush_dec() {
        System.out.println("@Test - testDotPush_dec");
        INumberEntry number = new NumberEntry_Wrapper();
        Assert.assertEquals(false, number.isDotPushed());
        number.addDigit(1);
        Assert.assertEquals(false, number.isDotPushed());
        number.pushDot(0);
        Assert.assertEquals(true, number.isDotPushed());
        number.addDigit(4);
        Assert.assertEquals(true, number.isDotPushed());        
    }

    public void testSetValue1_dec() {
        System.out.println("@Test - testSetValue1_dec");
        INumberEntry number = new NumberEntry_Wrapper();
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
## NumberEntry 

#### Introduction

This package contains some basic classes to allow for numeric input in the style of 
a hand calculator.  For example, to represent the number "123.456" one would invoke a
sequence of methods like this: addDigit(1); addDigit(2); addDigit(3), pushDot(0); 
addDigit(4); addDigit(5); addDigit(6).  The class is intended to control data entry 
from an application that mimics a hand calculator.

The implementation uses BigDecimal to avoid problems with finite 
numeric precision of float/double.

Check the JUnit test cases for usage examples.



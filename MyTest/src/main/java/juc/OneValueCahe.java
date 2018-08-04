package juc;

import java.math.BigInteger;

public class OneValueCahe {

	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;

	public OneValueCahe(BigInteger i, BigInteger[] b ){
		lastNumber = i;
		lastFactors = b;
	}
	
	
}

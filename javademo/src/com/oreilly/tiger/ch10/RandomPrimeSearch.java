package com.oreilly.tiger.ch10;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.Callable;

public class RandomPrimeSearch implements Callable<BigInteger> {

	private static final Random prng = new SecureRandom();
	private int bitSize;

	public RandomPrimeSearch(int bitSize) {
		this.bitSize = bitSize;
	}

	public BigInteger call() {
		return BigInteger.probablePrime(bitSize, prng);
	}
}
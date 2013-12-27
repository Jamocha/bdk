/*
 * Copyright 2013 saden.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jamocha.bdk.core.math;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BigIntegerBuilder {

    public NumBitsBuilder numBits(int numBits) {
        return new NumBitsBuilder(numBits);
    }

    public BitLengthBuilder bitLength(int bitLength, int certainty) {
        return new BitLengthBuilder(bitLength, certainty);
    }

    public StringBuilder value(String value) {
        return new StringBuilder(value);
    }

    public static abstract class RandomBuilder<T> implements Builder<BigInteger> {

        private static final Random DEFAULT_RANDOM = new SecureRandom();
        protected Random random = DEFAULT_RANDOM;

        @Optional("SecureRandom")
        public T random(Random random) {
            this.random = random;

            return (T) this;
        }
    }

    public static class NumBitsBuilder extends RandomBuilder<NumBitsBuilder> {

        private final Integer numBits;

        private NumBitsBuilder(Integer numBits) {
            this.numBits = numBits;
        }

        @Override
        public BigInteger build() {
            return new BigInteger(numBits, random);
        }
    }

    public static class BitLengthBuilder extends RandomBuilder<BitLengthBuilder> {

        private final Integer bitLength;
        private final Integer certainty;

        private BitLengthBuilder(Integer bitLength, Integer certainty) {
            this.bitLength = bitLength;
            this.certainty = certainty;
        }

        @Override
        public BigInteger build() {
            return new BigInteger(bitLength, certainty, random);
        }
    }

    public static class StringBuilder implements Builder<BigInteger> {

        public static final Integer DEFAULT_RADIX = 10;

        private final String value;
        private Integer radix = DEFAULT_RADIX;

        private StringBuilder(String value) {
            this.value = value;
        }

        @Optional("10")
        public StringBuilder radix(int radix) {
            this.radix = radix;

            return this;
        }

        @Override
        public BigInteger build() {
            return new BigInteger(value, radix);
        }

    }
}

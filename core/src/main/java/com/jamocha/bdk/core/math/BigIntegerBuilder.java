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
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BigIntegerBuilder {

    public NumBitsBuilder numBitsBuilder() {
        return new NumBitsBuilder();
    }

    public BitLengthBuilder bitLengthBuilder() {
        return new BitLengthBuilder();
    }

    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }

    public static abstract class BaseBuilder implements Builder<BigInteger> {
    }

    public static abstract class RandomBuilder<T> extends BaseBuilder {

        private static final Random DEFAULT_RANDOM = new SecureRandom();
        protected Random random = DEFAULT_RANDOM;

        public T random(Random random) {
            this.random = random;

            return (T) this;
        }
    }

    public static class NumBitsBuilder extends RandomBuilder<NumBitsBuilder> {

        private Integer numBits;

        public NumBitsBuilder numBits(int numBits) {
            this.numBits = numBits;

            return this;
        }

        @Override
        public BigInteger build() {
            return new BigInteger(numBits, random);
        }
    }

    public static class BitLengthBuilder extends RandomBuilder<BitLengthBuilder> {

        private Integer bitLength;
        private Integer certainty;

        public BitLengthBuilder bitLength(int bitLength) {
            this.bitLength = bitLength;

            return this;
        }

        public BitLengthBuilder certainty(int certainty) {
            this.certainty = certainty;

            return this;
        }

        @Override
        public BigInteger build() {
            return new BigInteger(bitLength, certainty, random);
        }
    }

    public static class StringBuilder extends BaseBuilder {

        public static final Integer DEFAULT_RADIX = 10;

        private String value;
        private Integer radix = DEFAULT_RADIX;

        public StringBuilder value(String value) {
            this.value = value;

            return this;
        }

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

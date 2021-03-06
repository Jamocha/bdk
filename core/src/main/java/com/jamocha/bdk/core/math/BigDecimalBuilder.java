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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BigDecimalBuilder {

    public StringBuilder value(String value) {
        return new StringBuilder(value);
    }

    public CharsBuilder value(char[] value) {
        return new CharsBuilder(value);
    }

    public IntegerBuilder value(int value) {
        return new IntegerBuilder(value);
    }

    public LongBuilder value(long value) {
        return new LongBuilder(value);
    }

    public DoubleBuilder value(double value) {
        return new DoubleBuilder(value);
    }

    public BigIntegerBuilder value(BigInteger value) {
        return new BigIntegerBuilder(value);
    }

    public static abstract class ContextBuilder implements Builder<BigDecimal> {

        MathContext context;

        public ContextBuilder context(MathContext context) {
            this.context = context;

            return this;
        }
    }

    public static class StringBuilder extends ContextBuilder {

        private final String value;

        private StringBuilder(String value) {
            this.value = value;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class IntegerBuilder extends ContextBuilder {

        private final Integer value;

        private IntegerBuilder(int value) {
            this.value = value;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class LongBuilder extends ContextBuilder {

        private final Long value;

        private LongBuilder(long value) {
            this.value = value;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class DoubleBuilder extends ContextBuilder {

        private final Double value;

        private DoubleBuilder(double value) {
            this.value = value;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class BigIntegerBuilder extends ContextBuilder {

        private final BigInteger value;

        private BigIntegerBuilder(BigInteger value) {
            this.value = value;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class CharsBuilder extends ContextBuilder {

        public static final Integer DEFAULT_OFFSET = 0;

        private final char[] value;
        private Integer offset = DEFAULT_OFFSET;
        private Integer length;

        private CharsBuilder(char[] value) {
            this.value = value;
        }

        @Optional
        public CharsBuilder offset(int offset) {
            this.offset = offset;

            return this;
        }

        @Optional
        public CharsBuilder length(int length) {
            this.length = length;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (length == null) {
                length = value.length;
            }

            if (context == null) {
                return new BigDecimal(value, offset, length);
            }

            return new BigDecimal(value, offset, length, context);
        }
    }

}

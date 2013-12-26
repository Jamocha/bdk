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
import com.jamocha.bdk.api.annotation.Required;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BigDecimalBuilder {

    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }

    public CharsBuilder charsBuilder() {
        return new CharsBuilder();
    }

    public IntegerBuilder intBuilder() {
        return new IntegerBuilder();
    }

    public LongBuilder longBuilder() {
        return new LongBuilder();
    }

    public DoubleBuilder doubleBuilder() {
        return new DoubleBuilder();
    }

    public BigIntegerBuilder bigIntBuilder() {
        return new BigIntegerBuilder();
    }

    public static abstract class BaseBuilder implements Builder<BigDecimal> {

        MathContext context;

        public BaseBuilder context(MathContext context) {
            this.context = context;

            return this;
        }
    }

    public static class StringBuilder extends BaseBuilder {

        private String value;

        @Required
        public StringBuilder value(String value) {
            this.value = value;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class IntegerBuilder extends BaseBuilder {

        private Integer value;

        @Required
        public IntegerBuilder value(Integer value) {
            this.value = value;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class LongBuilder extends BaseBuilder {

        private Long value;

        @Required
        public LongBuilder value(Long value) {
            this.value = value;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class DoubleBuilder extends BaseBuilder {

        private Double value;

        @Required
        public DoubleBuilder value(Double value) {
            this.value = value;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class BigIntegerBuilder extends BaseBuilder {

        private BigInteger value;

        @Required
        public BigIntegerBuilder value(BigInteger value) {
            this.value = value;

            return this;
        }

        @Override
        public BigDecimal build() {
            if (context == null) {
                return new BigDecimal(value);
            }

            return new BigDecimal(value, context);
        }
    }

    public static class CharsBuilder extends BaseBuilder {

        public static final Integer DEFAULT_OFFSET = 0;

        private char[] value;
        private Integer offset = DEFAULT_OFFSET;
        private Integer length;

        @Required
        public CharsBuilder value(char[] value) {
            this.value = value;

            return this;
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

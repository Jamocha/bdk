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
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Required;
import static com.jamocha.bdk.utils.Throws.illegalState;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 *
 * @author saden
 */
public class BigDecimalNumberBuilder implements Builder<BigDecimal> {

    private Number value;
    private MathContext mathContext;

    @Required
    @Alternate
    public BigDecimalNumberBuilder setValue(Number value) {
        this.value = value;

        return this;
    }

    public BigDecimalNumberBuilder setMathContext(MathContext mathContext) {
        this.mathContext = mathContext;

        return this;
    }

    @Override
    public BigDecimal build() throws Exception {
        if (mathContext == null) {
            if (value instanceof Integer) {
                return new BigDecimal((Integer) value);
            } else if (value instanceof Long) {
                return new BigDecimal((Long) value);
            } else if (value instanceof Double) {
                return new BigDecimal((Double) value);
            } else if (value instanceof BigInteger) {
                return new BigDecimal((BigInteger) value);
            }
        }

        if (value instanceof Integer) {
            return new BigDecimal((Integer) value, mathContext);
        } else if (value instanceof Long) {
            return new BigDecimal((Long) value, mathContext);
        } else if (value instanceof Double) {
            return new BigDecimal((Double) value, mathContext);
        } else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger) value, mathContext);
        }

        illegalState("value [%s] type [%s] is not supported",
                value, value.getClass().getName());

        //never reached
        return null;
    }

}

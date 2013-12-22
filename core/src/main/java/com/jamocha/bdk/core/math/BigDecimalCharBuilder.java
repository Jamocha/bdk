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
import com.jamocha.bdk.api.annotation.Derived;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author saden
 */
public class BigDecimalCharBuilder implements Builder<BigDecimal> {

    public static final Integer DEFAULT_OFFSET = 0;
    private char[] value;
    private MathContext mathContext;
    private Integer offset = DEFAULT_OFFSET;
    private Integer length;

    @Required
    @Alternate
    public BigDecimalCharBuilder setValue(String value) {
        this.value = value.toCharArray();

        return this;
    }

    @Required
    @Alternate
    public BigDecimalCharBuilder setValue(char[] value) {
        this.value = value;

        return this;
    }

    @Optional
    public BigDecimalCharBuilder setOffset(int offset) {
        this.offset = offset;

        return this;
    }

    @Derived("value")
    public BigDecimalCharBuilder setLength(int length) {
        this.length = length;

        return this;
    }

    public BigDecimalCharBuilder setMathContext(MathContext mathContext) {
        this.mathContext = mathContext;

        return this;
    }

    @Override
    public BigDecimal build() throws Exception {
        if (length == null) {
            length = value.length;
        }

        if (mathContext == null) {
            return new BigDecimal(value, offset, length);
        }

        return new BigDecimal(value, offset, length, mathContext);
    }

}

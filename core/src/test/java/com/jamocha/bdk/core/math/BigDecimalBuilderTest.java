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

import java.math.BigDecimal;
import java.math.BigInteger;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BigDecimalBuilderTest {

    public static String EXPECTED = "1979";

    @Test
    public void verifyIntBuilder() {
        BigDecimal result = new BigDecimalBuilder().intBuilder()
                .value(1_979)
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyLongBuilder() {
        BigDecimal result = new BigDecimalBuilder().longBuilder()
                .value(1_979L)
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyDoubleBuilder() {
        BigDecimal result = new BigDecimalBuilder().doubleBuilder()
                .value(1979d)
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyBigIntBuilder() {
        BigDecimal result = new BigDecimalBuilder().bigIntBuilder()
                .value(new BigInteger(EXPECTED))
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyStringBuilder() {
        BigDecimal result = new BigDecimalBuilder().stringBuilder()
                .value(EXPECTED)
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyCharBuilder() {
        BigDecimal result = new BigDecimalBuilder().charsBuilder()
                .value(EXPECTED.toCharArray())
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED);
    }

    @Test
    public void verifyCharOffsetBuilder() {
        BigDecimal result = new BigDecimalBuilder().charsBuilder()
                .value(EXPECTED.toCharArray())
                .offset(1)
                .length(2)
                .build();

        assertThat(result)
                .isEqualByComparingTo(EXPECTED.substring(1, 3));
    }

}

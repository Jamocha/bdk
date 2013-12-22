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
import com.jamocha.bdk.api.annotation.Exclusive;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import static com.jamocha.bdk.utils.Checks.areExclusive;
import static com.jamocha.bdk.utils.Throws.illegalState;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author saden
 */
public class BigIntegerRandomBuilder implements Builder<BigInteger> {

    private static final Random DEFAULT_RANDOM = new SecureRandom();

    private Integer bitLength;
    private Integer numBits;
    private Random random = DEFAULT_RANDOM;

    @Required
    @Exclusive
    public BigIntegerRandomBuilder setNumBits(int numBits) {
        this.numBits = numBits;

        return this;
    }

    @Required
    @Exclusive
    public BigIntegerRandomBuilder setBitLength(int bitLength) {
        this.bitLength = bitLength;

        return this;
    }

    @Optional
    public BigIntegerRandomBuilder setRandom(Random random) {
        this.random = random;

        return this;
    }

    @Override
    public BigInteger build() {
        if (!areExclusive(bitLength, numBits)) {
            illegalState("bitLength [%s] and numBits [%s] are mutually exclusive",
                    bitLength, numBits);
        }

        if (bitLength == null) {
            return new BigInteger(numBits, random);
        }

        return new BigInteger(bitLength, random);
    }

}

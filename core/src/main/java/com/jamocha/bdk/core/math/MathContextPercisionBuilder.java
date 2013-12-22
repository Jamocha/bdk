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
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author saden
 */
public class MathContextPercisionBuilder implements Builder<MathContext> {

    public static final RoundingMode DEFAULT_MODE = RoundingMode.HALF_UP;

    private Integer precision;
    private RoundingMode mode = DEFAULT_MODE;

    public MathContextPercisionBuilder setPrecision(Integer precision) {
        this.precision = precision;

        return this;
    }

    public MathContextPercisionBuilder setMode(RoundingMode mode) {
        this.mode = mode;

        return this;
    }

    @Override
    public MathContext build() {
        return new MathContext(precision, mode);
    }

}

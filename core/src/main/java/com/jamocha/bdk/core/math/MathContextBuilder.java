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
import com.jamocha.bdk.api.annotation.Required;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class MathContextBuilder {

    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }

    public PercisionBuilder percisionBuilder() {
        return new PercisionBuilder();
    }

    public static abstract class BaseBuilder implements Builder<MathContext> {
    }

    public static class StringBuilder extends BaseBuilder {

        private String value;

        @Required
        public StringBuilder value(String value) {
            this.value = value;

            return this;
        }

        @Override
        public MathContext build() {
            return new MathContext(value);
        }
    }

    public static class PercisionBuilder extends BaseBuilder {

        public static final RoundingMode DEFAULT_MODE = RoundingMode.HALF_UP;

        private Integer precision;
        private RoundingMode mode = DEFAULT_MODE;

        public PercisionBuilder precision(Integer precision) {
            this.precision = precision;

            return this;
        }

        public PercisionBuilder mode(RoundingMode mode) {
            this.mode = mode;

            return this;
        }

        @Override
        public MathContext build() {
            return new MathContext(precision, mode);
        }

    }
}

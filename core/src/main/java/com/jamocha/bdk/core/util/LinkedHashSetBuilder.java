/*
 * Copyright 2013 Sharmarke Aden <www.github.com/saden1>.
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
package com.jamocha.bdk.core.util;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class LinkedHashSetBuilder implements Builder<LinkedHashSet> {

    public ElementsBuilder elements(Collection elements) {
        return new ElementsBuilder(elements);
    }

    public CapacityBuilder capacity(int capacity) {
        return new CapacityBuilder(capacity);
    }

    @Override
    public LinkedHashSet build() {
        return new LinkedHashSet();
    }

    public static class ElementsBuilder implements Builder<LinkedHashSet> {

        private final Collection elements;

        private ElementsBuilder(Collection elements) {
            this.elements = elements;
        }

        @Override
        public LinkedHashSet build() {
            return new LinkedHashSet(elements);

        }

    }

    public static class CapacityBuilder implements Builder<LinkedHashSet> {

        public static final Float DEFAULT_FACTOR = 0.75f;
        private final int capacity;
        private Float factor = DEFAULT_FACTOR;

        private CapacityBuilder(int capacity) {
            this.capacity = capacity;
        }

        @Optional("0.75")
        public CapacityBuilder factor(float factor) {
            this.factor = factor;

            return this;
        }

        @Override
        public LinkedHashSet build() {
            return new LinkedHashSet(capacity, factor);
        }
    }

}

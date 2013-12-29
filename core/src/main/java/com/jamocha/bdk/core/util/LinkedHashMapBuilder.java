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
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class LinkedHashMapBuilder implements Builder<LinkedHashMap> {

    public EntriesBuilder entries(Map entries) {
        return new EntriesBuilder(entries);
    }

    public CapacityBuilder capacity(int capacity) {
        return new CapacityBuilder(capacity);
    }

    @Override
    public LinkedHashMap build() {
        return new LinkedHashMap();
    }

    public static class EntriesBuilder implements Builder<LinkedHashMap> {

        private final Map entries;

        private EntriesBuilder(Map entries) {
            this.entries = entries;
        }

        @Override
        public LinkedHashMap build() {
            return new LinkedHashMap(entries);
        }

    }

    public static class CapacityBuilder implements Builder<LinkedHashMap> {

        public static final Float DEFAULT_FACTOR = 0.75f;
        public static final Boolean DEFAULT_ORDERING = false;

        private final int capacity;
        private Float factor = DEFAULT_FACTOR;
        private Boolean ordering = DEFAULT_ORDERING;

        private CapacityBuilder(int capacity) {
            this.capacity = capacity;
        }

        @Optional("0.75")
        public CapacityBuilder factor(float factor) {
            this.factor = factor;

            return this;
        }

        @Optional("false")
        public CapacityBuilder ordered() {
            this.ordering = true;

            return this;
        }

        @Override
        public LinkedHashMap build() {
            return new LinkedHashMap(capacity, factor, ordering);
        }
    }
}

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
package com.jamocha.bdk.core.util.concurrent;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ArrayBlockingQueueBuilder {

    public CapacityBuilder capacity(int capacity) {
        return new CapacityBuilder(capacity);
    }

    public static class CapacityBuilder implements Builder<ArrayBlockingQueue> {

        public static final boolean DEFAULT_FAIR = false;
        private final Integer capacity;
        private boolean fair = DEFAULT_FAIR;
        private Collection elements;

        private CapacityBuilder(Integer capacity) {
            this.capacity = capacity;
        }

        @Optional
        public CapacityBuilder fair() {
            this.fair = true;

            return this;
        }

        @Optional
        public CapacityBuilder elements(Collection elements) {
            this.elements = elements;

            return this;
        }

        @Override
        public ArrayBlockingQueue build() {
            if (elements == null) {
                return new ArrayBlockingQueue(capacity, fair);
            }

            return new ArrayBlockingQueue(capacity, fair, elements);
        }

    }

}

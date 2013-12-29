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
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PriorityBlockingQueueBuilder implements Builder<PriorityBlockingQueue> {

    public CapacityBuilder capacity(int capacity) {
        return new CapacityBuilder(capacity);
    }

    @Override
    public PriorityBlockingQueue build() {
        return new PriorityBlockingQueue();
    }

    public static class ElementsBuilder implements Builder<PriorityBlockingQueue> {

        private final Collection elements;

        private ElementsBuilder(Collection elements) {
            this.elements = elements;
        }

        @Override
        public PriorityBlockingQueue build() {
            return new PriorityBlockingQueue(elements);
        }

    }

    public static class CapacityBuilder implements Builder<PriorityBlockingQueue> {

        private final Integer capacity;
        private Comparator comparator;

        private CapacityBuilder(Integer capacity) {
            this.capacity = capacity;
        }

        @Optional
        public CapacityBuilder comparator(Comparator comparator) {
            this.comparator = comparator;

            return this;
        }

        @Override
        public PriorityBlockingQueue build() {
            return new PriorityBlockingQueue(capacity, comparator);
        }

    }

}

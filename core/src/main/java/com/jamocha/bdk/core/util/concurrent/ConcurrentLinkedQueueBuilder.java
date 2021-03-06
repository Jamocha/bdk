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
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ConcurrentLinkedQueueBuilder implements Builder<ConcurrentLinkedQueue> {

    public ElementsBuilder elements(Collection elements) {
        return new ElementsBuilder(elements);
    }

    @Override
    public ConcurrentLinkedQueue build() {
        return new ConcurrentLinkedQueue();
    }

    public static class ElementsBuilder implements Builder<ConcurrentLinkedQueue> {

        private final Collection elements;

        private ElementsBuilder(Collection elements) {
            this.elements = elements;
        }

        @Override
        public ConcurrentLinkedQueue build() {
            return new ConcurrentLinkedQueue(elements);
        }

    }
}

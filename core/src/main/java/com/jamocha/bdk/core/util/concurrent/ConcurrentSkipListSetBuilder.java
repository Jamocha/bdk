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
package com.jamocha.bdk.core.util.concurrent;

import com.jamocha.bdk.api.Builder;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ConcurrentSkipListSetBuilder implements Builder<ConcurrentSkipListSet> {

    public ElementsBuilder elements(Collection elements) {
        return new ElementsBuilder(elements);
    }

    public SortedBuilder elements(SortedSet elements) {
        return new SortedBuilder(elements);
    }

    public ComparatorBuilder comparator(Comparator comparator) {
        return new ComparatorBuilder(comparator);
    }

    @Override
    public ConcurrentSkipListSet build() {
        return new ConcurrentSkipListSet();
    }

    public class ElementsBuilder implements Builder<ConcurrentSkipListSet> {

        private final Collection elements;

        private ElementsBuilder(Collection elements) {
            this.elements = elements;
        }

        @Override
        public ConcurrentSkipListSet build() {
            return new ConcurrentSkipListSet(elements);
        }

    }

    public class SortedBuilder implements Builder<ConcurrentSkipListSet> {

        private final SortedSet elements;

        private SortedBuilder(SortedSet elements) {
            this.elements = elements;
        }

        @Override
        public ConcurrentSkipListSet build() {
            return new ConcurrentSkipListSet(elements);
        }

    }

    public class ComparatorBuilder implements Builder<ConcurrentSkipListSet> {

        private final Comparator comparator;

        private ComparatorBuilder(Comparator comparator) {
            this.comparator = comparator;
        }

        @Override
        public ConcurrentSkipListSet build() {
            return new ConcurrentSkipListSet(comparator);
        }

    }
}

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
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ConcurrentSkipListMapBuilder implements Builder<ConcurrentSkipListMap> {

    public EntriesBuilder entries(Map entries) {
        return new EntriesBuilder(entries);
    }

    public SortedBuilder entries(SortedMap entries) {
        return new SortedBuilder(entries);
    }

    public ComparatorBuilder comparator(Comparator comparator) {
        return new ComparatorBuilder(comparator);
    }

    @Override
    public ConcurrentSkipListMap build() {
        return new ConcurrentSkipListMap();
    }

    public class EntriesBuilder implements Builder<ConcurrentSkipListMap> {

        private final Map entries;

        private EntriesBuilder(Map entries) {
            this.entries = entries;
        }

        @Override
        public ConcurrentSkipListMap build() {
            return new ConcurrentSkipListMap(entries);
        }

    }

    public class SortedBuilder implements Builder<ConcurrentSkipListMap> {

        private final SortedMap entries;

        private SortedBuilder(SortedMap entries) {
            this.entries = entries;
        }

        @Override
        public ConcurrentSkipListMap build() {
            return new ConcurrentSkipListMap(entries);
        }

    }

    public class ComparatorBuilder implements Builder<ConcurrentSkipListMap> {

        private final Comparator comparator;

        private ComparatorBuilder(Comparator comparator) {
            this.comparator = comparator;
        }

        @Override
        public ConcurrentSkipListMap build() {
            return new ConcurrentSkipListMap(comparator);
        }

    }
}

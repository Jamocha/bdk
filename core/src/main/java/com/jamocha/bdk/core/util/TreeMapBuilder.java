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
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class TreeMapBuilder implements Builder<TreeMap> {

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
    public TreeMap build() {
        return new TreeMap();
    }

    public class EntriesBuilder implements Builder<TreeMap> {

        private final Map entries;

        private EntriesBuilder(Map entries) {
            this.entries = entries;
        }

        @Override
        public TreeMap build() {
            return new TreeMap(entries);
        }

    }

    public class SortedBuilder implements Builder<TreeMap> {

        private final SortedMap entries;

        private SortedBuilder(SortedMap entries) {
            this.entries = entries;
        }

        @Override
        public TreeMap build() {
            return new TreeMap(entries);
        }

    }

    public class ComparatorBuilder implements Builder<TreeMap> {

        private final Comparator comparator;

        private ComparatorBuilder(Comparator comparator) {
            this.comparator = comparator;
        }

        @Override
        public TreeMap build() {
            return new TreeMap(comparator);
        }

    }

}

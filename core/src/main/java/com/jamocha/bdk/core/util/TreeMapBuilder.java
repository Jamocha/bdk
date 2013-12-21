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
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class TreeMapBuilder implements Builder<TreeMap> {

    private Map entries;
    private Comparator comparator;
    private SortedMap sortedEntries;

    @Alternate
    @Optional
    public TreeMapBuilder setEntries(Map entries) {
        this.entries = entries;

        return this;
    }

    @Alternate
    @Optional
    public TreeMapBuilder setSortedElements(SortedMap entries) {
        this.sortedEntries = entries;

        return this;
    }

    @Optional
    public TreeMapBuilder setComparator(Comparator comparator) {
        this.comparator = comparator;

        return this;
    }

    @Override
    public TreeMap build() {
        if (entries != null) {
            return new TreeMap(entries);
        }

        if (sortedEntries != null) {
            return new TreeMap(sortedEntries);
        }

        return new TreeMap(comparator);
    }

}

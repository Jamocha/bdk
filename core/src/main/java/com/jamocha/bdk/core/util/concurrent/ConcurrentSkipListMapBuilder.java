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
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ConcurrentSkipListMapBuilder implements Builder<ConcurrentSkipListMap> {

    private Map entries;
    private Comparator comparator;
    private SortedMap sortedEntries;

    @Alternate
    @Optional
    public ConcurrentSkipListMapBuilder entries(Map entries) {
        this.entries = entries;

        return this;
    }

    @Alternate
    @Optional
    public ConcurrentSkipListMapBuilder entries(SortedMap entries) {
        this.sortedEntries = entries;

        return this;
    }

    @Optional
    public ConcurrentSkipListMapBuilder comparator(Comparator comparator) {
        this.comparator = comparator;

        return this;
    }

    @Override
    public ConcurrentSkipListMap build() {
        if (entries != null) {
            return new ConcurrentSkipListMap(entries);
        }

        if (sortedEntries != null) {
            return new ConcurrentSkipListMap(sortedEntries);
        }

        return new ConcurrentSkipListMap(comparator);
    }

}

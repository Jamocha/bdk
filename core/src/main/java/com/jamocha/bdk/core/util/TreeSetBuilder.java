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
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class TreeSetBuilder implements Builder<TreeSet> {

    private Collection elements;
    private Comparator comparator;
    private SortedSet sortedElements;

    @Alternate
    @Optional
    public TreeSetBuilder setElements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Alternate
    @Optional
    public TreeSetBuilder setSortedElements(SortedSet elements) {
        this.sortedElements = elements;

        return this;
    }

    @Optional
    public TreeSetBuilder setComparator(Comparator comparator) {
        this.comparator = comparator;

        return this;
    }

    @Override
    public TreeSet build() {
        if (elements != null) {
            return new TreeSet<>(elements);
        }

        if (sortedElements != null) {
            return new TreeSet<>(sortedElements);
        }

        return new TreeSet(comparator);
    }

}

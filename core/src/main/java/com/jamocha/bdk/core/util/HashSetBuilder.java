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
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class HashSetBuilder implements Builder<HashSet> {

    public static final Integer DEFAULT_CAPACITY = 16;
    public static final Float DEFAULT_FACTOR = 0.75f;
    private Collection elements;
    private Integer capacity = DEFAULT_CAPACITY;
    private Float factor = DEFAULT_FACTOR;

    @Optional
    public HashSetBuilder elements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Optional
    public HashSetBuilder capacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Optional
    public HashSetBuilder factor(float factor) {
        this.factor = factor;

        return this;
    }

    @Override
    public HashSet build() {
        if (elements == null) {
            return new HashSet(capacity, factor);
        }

        return new HashSet<>(elements);
    }

}

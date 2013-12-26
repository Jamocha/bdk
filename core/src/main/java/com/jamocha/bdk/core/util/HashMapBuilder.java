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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class HashMapBuilder implements Builder<HashMap> {

    public static final Integer DEFAULT_CAPACITY = 16;
    public static final Float DEFAULT_FACTOR = 0.75f;

    private Map entries;
    private Integer capacity = DEFAULT_CAPACITY;
    private Float factor = DEFAULT_FACTOR;

    @Optional
    public HashMapBuilder entries(Map entries) {
        this.entries = entries;

        return this;
    }

    @Optional
    public HashMapBuilder capacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Optional
    public HashMapBuilder factor(float factor) {
        this.factor = factor;

        return this;
    }

    @Override
    public HashMap build() {
        if (entries == null) {
            return new HashMap(capacity, factor);
        }

        return new HashMap<>(entries);
    }

}

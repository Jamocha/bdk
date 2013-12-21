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
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ArrayListBuilder implements Builder<ArrayList> {

    public static final Integer DEFAULT_CAPACITY = 10;
    private Collection elements;
    private Integer capacity = DEFAULT_CAPACITY;

    @Optional
    public ArrayListBuilder setElements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Optional
    public ArrayListBuilder setCapacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Override
    public ArrayList build() {
        if (elements == null) {
            return new ArrayList(capacity);
        }

        return new ArrayList<>(elements);
    }

}

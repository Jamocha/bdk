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
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author saden
 */
public class LinkedBlockingDequeBuilder implements Builder<LinkedBlockingDeque> {

    public static final Integer DEFAULT_CAPACITY = Integer.MAX_VALUE;
    private Integer capacity = DEFAULT_CAPACITY;
    private Collection elements;

    @Optional
    public LinkedBlockingDequeBuilder setCapacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Optional
    public LinkedBlockingDequeBuilder setElements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public LinkedBlockingDeque build() {
        if (elements == null) {
            return new LinkedBlockingDeque(capacity);
        }

        return new LinkedBlockingDeque(elements);
    }

}

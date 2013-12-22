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
import com.jamocha.bdk.api.annotation.Required;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author saden
 */
public class ArrayBlockingQueueBuilder implements Builder<ArrayBlockingQueue> {

    public static final Boolean DEFAULT_FAIR = false;
    private Integer capacity;
    private Boolean fair = DEFAULT_FAIR;
    private Collection elements;

    @Required
    public ArrayBlockingQueueBuilder setCapacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Optional
    public ArrayBlockingQueueBuilder setFair(boolean fair) {
        this.fair = fair;

        return this;
    }

    @Optional
    public ArrayBlockingQueueBuilder setElements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public ArrayBlockingQueue build() {
        if (elements == null) {
            return new ArrayBlockingQueue(capacity, fair, elements);
        }

        return new ArrayBlockingQueue(capacity, fair);
    }

}

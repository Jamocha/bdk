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
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class LinkedBlockingQueueBuilder implements Builder<LinkedBlockingQueue> {

    public static final Integer DEFAULT_CAPACITY = Integer.MAX_VALUE;
    private Integer capacity = DEFAULT_CAPACITY;
    private Collection elements;

    @Optional
    public LinkedBlockingQueueBuilder capacity(int capacity) {
        this.capacity = capacity;

        return this;
    }

    @Optional
    public LinkedBlockingQueueBuilder elements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public LinkedBlockingQueue build() {
        if (elements == null) {
            return new LinkedBlockingQueue(capacity);
        }

        return new LinkedBlockingQueue(elements);
    }

}

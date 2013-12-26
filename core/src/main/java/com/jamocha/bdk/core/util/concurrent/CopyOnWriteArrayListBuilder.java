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
import com.jamocha.bdk.api.annotation.Optional;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class CopyOnWriteArrayListBuilder implements Builder<CopyOnWriteArrayList> {

    private Object[] elements;

    @Optional
    public CopyOnWriteArrayListBuilder elements(Collection elements) {
        this.elements = elements.toArray();

        return this;
    }

    @Optional
    public CopyOnWriteArrayListBuilder elements(Object[] elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public CopyOnWriteArrayList build() {
        if (elements == null) {
            return new CopyOnWriteArrayList();
        }

        return new CopyOnWriteArrayList<>(elements);
    }

}

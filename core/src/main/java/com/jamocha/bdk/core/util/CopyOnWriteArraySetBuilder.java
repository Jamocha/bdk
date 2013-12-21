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
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class CopyOnWriteArraySetBuilder implements Builder<CopyOnWriteArraySet> {

    private Collection elements;

    @Optional
    public CopyOnWriteArraySetBuilder setElements(Collection elements) {
        this.elements = elements;

        return this;
    }

    @Override
    public CopyOnWriteArraySet build() {
        if (elements == null) {
            return new CopyOnWriteArraySet();
        }

        return new CopyOnWriteArraySet<>(elements);
    }

}

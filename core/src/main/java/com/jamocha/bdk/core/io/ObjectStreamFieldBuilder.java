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
package com.jamocha.bdk.core.io;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.io.ObjectStreamField;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ObjectStreamFieldBuilder implements Builder<ObjectStreamField> {

    public static final Boolean DEFAULT_UNSHARED = Boolean.FALSE;
    private String name;
    private Class<?> type;
    private Boolean unshared = DEFAULT_UNSHARED;

    @Required
    public ObjectStreamFieldBuilder name(String name) {
        this.name = name;

        return this;
    }

    @Required
    public ObjectStreamFieldBuilder type(Class<?> type) {
        this.type = type;

        return this;
    }

    @Optional
    public ObjectStreamFieldBuilder unshared() {
        this.unshared = true;

        return this;
    }

    @Override
    public ObjectStreamField build() {
        return new ObjectStreamField(name, type, unshared);
    }

}

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
import java.io.ObjectStreamField;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ObjectStreamFieldBuilder {

    public FieldBuilder field(String name, Class<?> type) {
        return new FieldBuilder(name, type);
    }

    public static class FieldBuilder implements Builder<ObjectStreamField> {

        private final String name;
        private final Class<?> type;

        private FieldBuilder(String name, Class<?> type) {
            this.name = name;
            this.type = type;
        }

        @Optional("false")
        public UnsharedBuilder unshared() {
            return new UnsharedBuilder(name, type, true);
        }

        @Override
        public ObjectStreamField build() {
            return new ObjectStreamField(name, type);
        }

    }

    public static class UnsharedBuilder implements Builder<ObjectStreamField> {

        private final String name;
        private final Class<?> type;
        private final Boolean unshared;

        private UnsharedBuilder(String name, Class<?> type, Boolean unshared) {
            this.name = name;
            this.type = type;
            this.unshared = unshared;
        }

        @Override
        public ObjectStreamField build() {
            return new ObjectStreamField(name, type, unshared);
        }
    }

}

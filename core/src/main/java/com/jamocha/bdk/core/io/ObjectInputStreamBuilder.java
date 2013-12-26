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
import com.jamocha.bdk.api.annotation.Required;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ObjectInputStreamBuilder
        implements Builder<ObjectInputStream> {

    private InputStream inputStream;

    @Required
    public ObjectInputStreamBuilder input(InputStream inputStream) {
        this.inputStream = inputStream;

        return this;
    }

    @Override
    public ObjectInputStream build() throws IOException {
        return new ObjectInputStream(inputStream);
    }

}

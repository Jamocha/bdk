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
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author saden
 */

public class ObjectOutputStreamBuilder
        implements Builder<ObjectOutputStream> {

    private OutputStream outputStream;

    @Required
    public ObjectOutputStreamBuilder setOutput(OutputStream outputStream) {
        this.outputStream = outputStream;

        return this;
    }

    public ObjectOutputStream build() throws Exception {
        return new ObjectOutputStream(outputStream);
    }

}

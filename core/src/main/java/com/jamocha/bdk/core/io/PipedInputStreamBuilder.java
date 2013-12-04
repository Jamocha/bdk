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
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author saden
 */
public class PipedInputStreamBuilder implements Builder<PipedInputStream> {

    public static final Integer DEFAULT_SIZE = 1024;
    private PipedOutputStream output;
    private Integer size = DEFAULT_SIZE;

    @Required
    public PipedInputStreamBuilder setOutput(PipedOutputStream output) {
        this.output = output;

        return this;
    }

    @Optional
    public PipedInputStreamBuilder setSize(Integer size) {
        this.size = size;

        return this;
    }

    public PipedInputStream build() throws Exception {
        if (output == null) {
            return new PipedInputStream(size);
        }

        return new PipedInputStream(output, size);
    }

}
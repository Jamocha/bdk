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
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *
 * @author saden
 */
public class PipedReaderBuilder implements Builder<PipedReader> {

    public static final Integer DEFAULT_SIZE = 1024;
    private PipedWriter writer;
    private Integer size = DEFAULT_SIZE;

    @Required
    public PipedReaderBuilder setWriter(PipedWriter writer) {
        this.writer = writer;

        return this;
    }

    @Optional
    public PipedReaderBuilder setSize(Integer size) {
        this.size = size;

        return this;
    }

    public PipedReader build() throws Exception {
        if (writer == null) {
            return new PipedReader(size);
        }

        return new PipedReader(writer, size);
    }

}

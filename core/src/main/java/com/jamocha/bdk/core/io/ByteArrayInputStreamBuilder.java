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
import com.jamocha.bdk.api.annotation.Derived;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.io.ByteArrayInputStream;

/**
 *
 * @author saden
 */

public class ByteArrayInputStreamBuilder
        implements Builder<ByteArrayInputStream> {

    public static final Integer DEFAULT_OFFSET = 0;
    private byte[] buffer;
    private Integer offset = DEFAULT_OFFSET;
    private Integer length;

    @Required
    public ByteArrayInputStreamBuilder setBuffer(byte[] buffer) {
        this.buffer = buffer;

        return this;
    }

    @Optional
    public ByteArrayInputStreamBuilder setOffset(int offset) {
        this.offset = offset;

        return this;
    }

    @Derived("buffer.length")
    @Optional
    public ByteArrayInputStreamBuilder setLength(int length) {
        this.length = length;

        return this;
    }

    public ByteArrayInputStream build() throws Exception {
        if (length == null) {
            length = buffer.length;
        }

        return new ByteArrayInputStream(buffer, offset, length);
    }

}

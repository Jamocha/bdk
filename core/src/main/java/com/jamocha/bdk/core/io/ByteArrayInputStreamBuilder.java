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
import java.io.ByteArrayInputStream;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ByteArrayInputStreamBuilder {

    public BufferBuilder buffer(byte[] buffer) {
        return new BufferBuilder(buffer);
    }

    public BufferBuilder buffer(String buffer) {
        return new BufferBuilder(buffer.getBytes());
    }

    public static class BufferBuilder implements Builder<ByteArrayInputStream> {

        private final byte[] buffer;

        private BufferBuilder(byte[] buffer) {
            this.buffer = buffer;
        }

        @Optional("0")
        public OffsetBuilder offset(int offset) {
            return new OffsetBuilder(buffer, offset);
        }

        @Override
        public ByteArrayInputStream build() {
            return new ByteArrayInputStream(buffer);
        }

    }

    public static class OffsetBuilder implements Builder<ByteArrayInputStream> {

        private final byte[] buffer;
        private final int offset;
        private Integer length;

        private OffsetBuilder(byte[] buffer, int offset) {
            this.buffer = buffer;
            this.offset = offset;
        }

        @Optional
        @Derived("buffer.length")
        public OffsetBuilder length(int length) {
            this.length = length;

            return this;

        }

        @Override
        public ByteArrayInputStream build() {
            if (length == null) {
                length = buffer.length;
            }

            return new ByteArrayInputStream(buffer, offset, length);
        }

    }

}

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
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PipedInputStreamBuilder implements Builder<PipedInputStream> {

    public OutputBuilder connect(PipedOutputStream output) {
        return new OutputBuilder(output);
    }

    public SizeBuilder size(int size) {
        return new SizeBuilder(size);
    }

    @Override
    public PipedInputStream build() throws IOException {
        return new PipedInputStream();
    }

    public static class SizeBuilder implements Builder<PipedInputStream> {

        private final Integer size;
        private PipedOutputStream output;

        private SizeBuilder(int size) {
            this.size = size;
        }

        @Optional("unconnected")
        public SizeBuilder connect(PipedOutputStream output) {
            this.output = output;

            return this;
        }

        @Override
        public PipedInputStream build() throws IOException {
            if (output == null) {
                return new PipedInputStream(size);
            }

            return new PipedInputStream(output, size);
        }

    }

    public static class OutputBuilder implements Builder<PipedInputStream> {

        public static final Integer DEFAULT_SIZE = 1_024;

        private final PipedOutputStream output;
        private Integer size = DEFAULT_SIZE;

        private OutputBuilder(PipedOutputStream output) {
            this.output = output;
        }

        @Optional("1024")
        public OutputBuilder size(int size) {
            this.size = size;

            return this;
        }

        @Override
        public PipedInputStream build() throws IOException {
            return new PipedInputStream(output, size);
        }

    }

}

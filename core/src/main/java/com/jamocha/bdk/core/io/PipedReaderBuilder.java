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
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PipedReaderBuilder implements Builder<PipedReader> {

    public WriterBuilder connect(PipedWriter writer) {
        return new WriterBuilder(writer);
    }

    public SizeBuilder size(int size) {
        return new SizeBuilder(size);
    }

    public static abstract class BaseBuilder implements Builder<PipedReader> {

    }

    public static class SizeBuilder extends BaseBuilder {

        private final Integer size;
        private PipedWriter writer;

        private SizeBuilder(int size) {
            this.size = size;
        }

        @Optional("unconnected")
        public SizeBuilder connect(PipedWriter writer) {
            this.writer = writer;

            return this;
        }

        @Override
        public PipedReader build() throws IOException {
            if (writer == null) {
                return new PipedReader(size);
            }

            return new PipedReader(writer, size);
        }

    }

    public static class WriterBuilder extends BaseBuilder {

        public static final Integer DEFAULT_SIZE = 1_024;

        private final PipedWriter writer;
        private Integer size = DEFAULT_SIZE;

        private WriterBuilder(PipedWriter writer) {
            this.writer = writer;
        }

        @Optional("1024")
        public WriterBuilder size(int size) {
            this.size = size;

            return this;
        }

        @Override
        public PipedReader build() throws IOException {
            return new PipedReader(writer, size);
        }

    }

    @Override
    public PipedReader build() throws IOException {
        return new PipedReader();
    }

}

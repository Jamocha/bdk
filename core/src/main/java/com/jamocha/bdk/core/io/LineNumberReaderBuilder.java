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
import java.io.LineNumberReader;
import java.io.Reader;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class LineNumberReaderBuilder {

    public ReaderBuilder reader(Reader reader) {
        return new ReaderBuilder(reader);
    }

    public static class ReaderBuilder implements Builder<LineNumberReader> {

        private final Reader reader;

        private ReaderBuilder(Reader reader) {
            this.reader = reader;
        }

        @Optional
        public SizeBuilder size(int size) {
            return new SizeBuilder(reader, size);
        }

        @Override
        public LineNumberReader build() {
            return new LineNumberReader(reader);
        }

    }

    public static class SizeBuilder implements Builder<LineNumberReader> {

        private final Reader reader;
        private final Integer size;

        public SizeBuilder(Reader reader, Integer size) {
            this.reader = reader;
            this.size = size;
        }

        @Override
        public LineNumberReader build() {
            return new LineNumberReader(reader, size);
        }
    }

}

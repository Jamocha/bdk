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
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class BufferedOutputStreamBuilder {

    public OutputBuilder output(OutputStream output) {
        return new OutputBuilder(output);
    }

    public static class OutputBuilder implements Builder<BufferedOutputStream> {

        private final OutputStream output;

        private OutputBuilder(OutputStream output) {
            this.output = output;
        }

        @Optional("8192")
        public SizeBuilder size(int size) {
            return new SizeBuilder(output, size);
        }

        @Override
        public BufferedOutputStream build() {
            return new BufferedOutputStream(output);
        }

    }

    public static class SizeBuilder implements Builder<BufferedOutputStream> {

        private final OutputStream output;
        private final Integer size;

        private SizeBuilder(OutputStream output, int size) {
            this.output = output;
            this.size = size;
        }

        @Override
        public BufferedOutputStream build() {
            return new BufferedOutputStream(output, size);
        }

    }

}

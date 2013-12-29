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
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Optional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PrintStreamBuilder {

    public FileBuilder file(File file) {
        return new FileBuilder(file);
    }

    public FileBuilder file(String name) {
        return new FileBuilder(new File(name));
    }

    public OutputBuilder output(OutputStream output) {
        return new OutputBuilder(output);
    }

    public static class OutputBuilder implements Builder<PrintStream> {

        public static final Boolean DEFAULT_AUTOFLUSH = false;

        private final OutputStream output;
        private Boolean autoflush = DEFAULT_AUTOFLUSH;

        private OutputBuilder(OutputStream output) {
            this.output = output;
        }

        @Optional("false")
        public OutputBuilder autoFlush() {
            this.autoflush = true;

            return this;
        }

        @Override
        public PrintStream build() {
            return new PrintStream(output, autoflush);
        }
    }

    public static class FileBuilder implements Builder<PrintStream> {

        private final File file;
        private String charset = defaultCharset().name();

        private FileBuilder(File file) {
            this.file = file;
        }

        @Optional("jvm")
        @Alternate
        public FileBuilder charset(Charset charset) {
            this.charset = charset.name();

            return this;
        }

        @Optional("jvm")
        @Alternate
        public FileBuilder charset(String charset) {
            this.charset = charset;

            return this;
        }

        @Override
        public PrintStream build() throws FileNotFoundException,
                UnsupportedEncodingException {
            return new PrintStream(file, charset);
        }
    }

}

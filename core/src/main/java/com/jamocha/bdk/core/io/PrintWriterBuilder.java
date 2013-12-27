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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PrintWriterBuilder {

    public static final Boolean DEFAULT_AUTOFLUSH = false;

    public WriterBuilder writer(Writer writer) {
        return new WriterBuilder(writer);
    }

    public FileBuilder file(File file) {
        return new FileBuilder(file);
    }

    public FileBuilder file(String name) {
        return new FileBuilder(new File(name));
    }

    public StreamBuilder output(OutputStream output) {
        return new StreamBuilder(output);
    }

    public static class WriterBuilder implements Builder<PrintWriter> {

        private Boolean autoflush = DEFAULT_AUTOFLUSH;
        private final Writer writer;

        private WriterBuilder(Writer writer) {
            this.writer = writer;
        }

        @Optional("false")
        public WriterBuilder autoFlush() {
            this.autoflush = true;

            return this;
        }

        @Override
        public PrintWriter build() {
            return new PrintWriter(writer, autoflush);
        }
    }

    public static class StreamBuilder implements Builder<PrintWriter> {

        private final OutputStream output;
        private Boolean autoflush = DEFAULT_AUTOFLUSH;

        private StreamBuilder(OutputStream output) {
            this.output = output;
        }

        @Optional("false")
        public StreamBuilder autoFlush() {
            this.autoflush = true;

            return this;
        }

        @Override
        public PrintWriter build() {
            return new PrintWriter(output, autoflush);
        }
    }

    public static class FileBuilder implements Builder<PrintWriter> {

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
        public PrintWriter build() throws FileNotFoundException,
                UnsupportedEncodingException {
            return new PrintWriter(file, charset);
        }
    }
}

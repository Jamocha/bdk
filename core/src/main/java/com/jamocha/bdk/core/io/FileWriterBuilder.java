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
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class FileWriterBuilder {

    public FileBuilder name(String name) {
        return new FileBuilder(new File(name));
    }

    public FileBuilder file(File file) {
        return new FileBuilder(file);
    }

    public DescriptorBuilder descriptor(FileDescriptor descriptor) {
        return new DescriptorBuilder(descriptor);
    }

    public static class FileBuilder implements Builder<FileWriter> {

        private final File file;

        private FileBuilder(File file) {
            this.file = file;
        }

        @Optional
        public AppendBuilder append() {
            return new AppendBuilder(file, true);
        }

        @Override
        public FileWriter build() throws Exception {
            return new FileWriter(file);
        }

    }

    public static class DescriptorBuilder implements Builder<FileWriter> {

        private final FileDescriptor descriptor;

        private DescriptorBuilder(FileDescriptor descriptor) {
            this.descriptor = descriptor;
        }

        @Override
        public FileWriter build() {
            return new FileWriter(descriptor);
        }

    }

    public static class AppendBuilder implements Builder<FileWriter> {

        private final File file;
        private final Boolean append;

        private AppendBuilder(File file, Boolean append) {
            this.file = file;
            this.append = append;
        }

        @Override
        public FileWriter build() throws IOException {
            return new FileWriter(file, append);
        }
    }

}

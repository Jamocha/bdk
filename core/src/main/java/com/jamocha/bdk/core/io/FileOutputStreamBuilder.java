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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class FileOutputStreamBuilder {

    public FileBuilder name(String name) {
        return new FileBuilder(new File(name));
    }

    public FileBuilder file(File file) {
        return new FileBuilder(file);
    }

    public DescriptorBuilder descriptor(FileDescriptor descriptor) {
        return new DescriptorBuilder(descriptor);
    }

    public static class FileBuilder implements Builder<FileOutputStream> {

        private final File file;

        private FileBuilder(File file) {
            this.file = file;
        }

        @Optional
        public AppendBuilder append() {
            return new AppendBuilder(file, true);
        }

        @Override
        public FileOutputStream build() throws Exception {
            return new FileOutputStream(file);
        }

    }

    public static class DescriptorBuilder implements Builder<FileOutputStream> {

        private final FileDescriptor descriptor;

        private DescriptorBuilder(FileDescriptor descriptor) {
            this.descriptor = descriptor;
        }

        @Override
        public FileOutputStream build() {
            return new FileOutputStream(descriptor);
        }

    }

    public static class AppendBuilder implements Builder<FileOutputStream> {

        private final File file;
        private final Boolean append;

        private AppendBuilder(File file, Boolean append) {
            this.file = file;
            this.append = append;
        }

        @Override
        public FileOutputStream build() throws FileNotFoundException {
            return new FileOutputStream(file, append);
        }
    }
}

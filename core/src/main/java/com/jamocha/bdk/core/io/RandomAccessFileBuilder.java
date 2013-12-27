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
import com.jamocha.bdk.api.annotation.Required;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * TODO: enhance actions permissions
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class RandomAccessFileBuilder {

    public static final String DEFAULT_MODE = "r";

    @Required
    @Alternate
    public NameBuilder name(String name) {
        return new NameBuilder(name);
    }

    @Required
    @Alternate
    public FileBuilder file(File file) {
        return new FileBuilder(file);
    }

    public static class NameBuilder implements Builder<RandomAccessFile> {

        private final String name;
        private final String mode = DEFAULT_MODE;

        private NameBuilder(String name) {
            this.name = name;
        }

        @Optional("r")
        public ModeBuilder mode() {
            return new ModeBuilder(new File(name));
        }

        @Override
        public RandomAccessFile build() throws FileNotFoundException {
            return new RandomAccessFile(name, mode);
        }

    }

    public static class FileBuilder implements Builder<RandomAccessFile> {

        private final File file;
        private final String mode = DEFAULT_MODE;

        private FileBuilder(File file) {
            this.file = file;
        }

        @Optional("r")
        public ModeBuilder mode() {
            return new ModeBuilder(file);
        }

        @Override
        public RandomAccessFile build() throws FileNotFoundException {
            return new RandomAccessFile(file, mode);
        }

    }

    public static class ModeBuilder {

        private final File file;

        private ModeBuilder(File file) {
            this.file = file;
        }

        public FileModeBuilder readOnly() {
            return new FileModeBuilder(file, "r");
        }

        public FileModeBuilder readWrite() {
            return new FileModeBuilder(file, "rw");
        }

        public FileModeBuilder updateContent() {
            return new FileModeBuilder(file, "rwd");
        }

        public FileModeBuilder updateMetadata() {
            return new FileModeBuilder(file, "rws");
        }
    }

    public static class FileModeBuilder implements Builder<RandomAccessFile> {

        private final File file;
        private final String mode;

        private FileModeBuilder(File file, String mode) {
            this.file = file;
            this.mode = mode;
        }

        @Override
        public RandomAccessFile build() throws FileNotFoundException {
            return new RandomAccessFile(file, mode);
        }
    }

}

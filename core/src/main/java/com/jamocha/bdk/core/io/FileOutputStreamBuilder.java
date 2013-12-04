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
import java.io.FileDescriptor;
import java.io.FileOutputStream;

/**
 *
 * @author saden
 */

public class FileOutputStreamBuilder
        implements Builder<FileOutputStream> {

    private static final Boolean DEFAULT_APPEND = Boolean.FALSE;
    private File file;
    private FileDescriptor descriptor;
    private Boolean append = DEFAULT_APPEND;

    @Alternate
    public FileOutputStreamBuilder setFile(String name) {
        this.file = new File(name);

        return this;
    }

    @Alternate
    public FileOutputStreamBuilder setFile(File file) {
        this.file = file;

        return this;
    }

    @Alternate
    public FileOutputStreamBuilder setDescriptor(FileDescriptor descriptor) {
        this.descriptor = descriptor;

        return this;
    }

    @Optional
    public FileOutputStreamBuilder setAppend(boolean append) {
        this.append = append;

        return this;
    }

    public FileOutputStream build() throws Exception {
        if (descriptor == null) {
            return new FileOutputStream(file, append);
        }

        return new FileOutputStream(descriptor);
    }

}
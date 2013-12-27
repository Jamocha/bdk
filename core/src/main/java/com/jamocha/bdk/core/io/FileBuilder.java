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
import com.jamocha.bdk.api.annotation.Required;
import java.io.File;
import java.net.URI;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class FileBuilder implements Builder<File> {

    private String pathname;

    public NameBuilder name(String name) {
        return new NameBuilder(name);
    }

    public UriBuilder uri(URI uri) {
        return new UriBuilder(uri);
    }

    public PathBuilder path(String parent, String child) {
        return new PathBuilder(new File(parent), child);
    }

    public PathBuilder path(File parent, String child) {
        return new PathBuilder(parent, child);
    }

    @Required
    public FileBuilder path(String pathname) {
        this.pathname = pathname;

        return this;
    }

    @Override
    public File build() {
        return new File(pathname);
    }

    public static class PathBuilder implements Builder<File> {

        private final File file;
        private final String child;

        private PathBuilder(File file, String child) {
            this.file = file;
            this.child = child;
        }

        @Override
        public File build() {
            return new File(file, child);
        }
    }

    public static class NameBuilder implements Builder<File> {

        private final String name;

        private NameBuilder(String name) {
            this.name = name;
        }

        @Override
        public File build() {
            return new File(name);
        }

    }

    public static class UriBuilder implements Builder<File> {

        private final URI uri;

        private UriBuilder(URI uri) {
            this.uri = uri;
        }

        @Override
        public File build() {
            return new File(uri);
        }

    }

}

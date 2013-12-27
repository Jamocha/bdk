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
package com.jamocha.bdk.core.lang;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import static com.jamocha.bdk.utils.Checks.isNullOrEmpty;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ThreadBuilder implements Builder<Thread> {

    private static final Long DEFAULT_SIZE = 0L;

    public NameBuilder name(String name) {
        return new NameBuilder(name);
    }

    public RunnableBuilder runnable(Runnable runnable) {
        return new RunnableBuilder(runnable);
    }

    @Override
    public Thread build() {
        return new Thread();
    }

    public static class NameBuilder implements Builder<Thread> {

        private final String name;
        private Runnable runnable;

        private NameBuilder(String name) {
            this.name = name;
        }

        @Optional
        public NameBuilder runnable(Runnable runnable) {
            this.runnable = runnable;

            return this;
        }

        @Optional
        public GroupBuilder group(ThreadGroup group) {
            return new GroupBuilder(runnable, name);
        }

        @Override
        public Thread build() {
            return new Thread(runnable, name);
        }

    }

    public static class RunnableBuilder implements Builder<Thread> {

        private final Runnable runnable;
        private String name;

        private RunnableBuilder(Runnable runnable) {
            this.runnable = runnable;
        }

        @Optional
        public GroupBuilder name(String name) {
            return new GroupBuilder(runnable, name);
        }

        @Override
        public Thread build() {
            if (isNullOrEmpty(name)) {
                return new Thread(runnable);
            }

            return new Thread(runnable, name);
        }
    }

    public static class GroupBuilder implements Builder<Thread> {

        private final Runnable runnable;
        private final String name;
        private ThreadGroup group;
        private Long size = DEFAULT_SIZE;

        private GroupBuilder(Runnable runnable, String name) {
            this.runnable = runnable;
            this.name = name;
        }

        @Optional("parent")
        public GroupBuilder group(ThreadGroup group) {
            this.group = group;

            return this;
        }

        @Optional("0")
        public GroupBuilder size(long size) {
            this.size = size;

            return this;
        }

        @Override
        public Thread build() {
            return new Thread(group, runnable, name, size);
        }
    }
}

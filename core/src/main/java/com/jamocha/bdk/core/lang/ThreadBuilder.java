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
import com.jamocha.bdk.api.annotation.Required;
import static com.jamocha.bdk.utils.Checks.isNullOrEmpty;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ThreadBuilder implements Builder<Thread> {

    private static final Long DEFAULT_SIZE = 0L;
    private static final String DEFAULT_NAME = "Thread";
    private final AtomicInteger threadCount = new AtomicInteger();
    private Runnable runnable;
    private ThreadGroup threadGroup;
    private String name;
    private Long size = DEFAULT_SIZE;

    @Required
    public ThreadBuilder runnable(Runnable runnable) {
        this.runnable = runnable;

        return this;
    }

    @Optional
    public ThreadBuilder group(ThreadGroup threadGroup) {
        this.threadGroup = threadGroup;

        return this;
    }

    @Optional
    public ThreadBuilder name(String name) {
        this.name = name;

        return this;
    }

    @Optional
    public ThreadBuilder size(long size) {
        this.size = size;

        return this;
    }

    @Override
    public Thread build() {
        if (isNullOrEmpty(name)) {
            name = DEFAULT_NAME + "-" + threadCount.getAndIncrement();
        }

        return new Thread(threadGroup, runnable, name, size);
    }

}

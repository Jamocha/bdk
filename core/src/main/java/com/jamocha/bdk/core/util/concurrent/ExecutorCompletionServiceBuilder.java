/*
 * Copyright 2013 saden.
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
package com.jamocha.bdk.core.util.concurrent;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ExecutorCompletionServiceBuilder implements Builder<ExecutorCompletionService> {

    private Executor executor;
    private BlockingQueue queue;

    @Required
    public ExecutorCompletionServiceBuilder executor(Executor executor) {
        this.executor = executor;

        return this;
    }

    @Optional
    public ExecutorCompletionServiceBuilder queue(BlockingQueue queue) {
        this.queue = queue;

        return this;
    }

    @Override
    public ExecutorCompletionService build() throws Exception {
        if (queue == null) {
            return new ExecutorCompletionService(executor);
        }

        return new ExecutorCompletionService(executor, queue);
    }

}

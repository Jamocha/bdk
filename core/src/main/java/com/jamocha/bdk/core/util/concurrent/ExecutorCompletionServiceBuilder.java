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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ExecutorCompletionServiceBuilder {

    public ExecutorBuilder executor(Executor executor) {
        return new ExecutorBuilder(executor);
    }

    public static class ExecutorBuilder implements Builder<ExecutorCompletionService> {

        private final Executor executor;

        private ExecutorBuilder(Executor executor) {
            this.executor = executor;
        }

        public QueueBuilder queue(BlockingQueue queue) {
            return new QueueBuilder(executor, queue);
        }

        @Override
        public ExecutorCompletionService build() {
            return new ExecutorCompletionService(executor);
        }

    }

    public static class QueueBuilder implements Builder<ExecutorCompletionService> {

        private final Executor executor;
        private final BlockingQueue queue;

        private QueueBuilder(Executor executor, BlockingQueue queue) {
            this.executor = executor;
            this.queue = queue;
        }

        @Override
        public ExecutorCompletionService build() {
            return new ExecutorCompletionService(executor, queue);
        }

    }

}

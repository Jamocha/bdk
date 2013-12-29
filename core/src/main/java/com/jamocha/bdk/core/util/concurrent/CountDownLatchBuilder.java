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
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class CountDownLatchBuilder {

    public CountBuilder count(int count) {
        return new CountBuilder(count);
    }

    public static class CountBuilder implements Builder<CountDownLatch> {

        private final Integer count;

        private CountBuilder(Integer count) {
            this.count = count;
        }

        @Override
        public CountDownLatch build() {
            return new CountDownLatch(count);
        }

    }

}

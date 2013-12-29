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
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class CyclicBarrierBuilder {

    public PartiesBuilder parties(int parties) {
        return new PartiesBuilder(parties);
    }

    public static class PartiesBuilder implements Builder<CyclicBarrier> {

        private final int parties;

        private PartiesBuilder(int parties) {
            this.parties = parties;
        }

        public ActionBuilder action(Runnable action) {
            return new ActionBuilder(parties, action);
        }

        @Override
        public CyclicBarrier build() {
            return new CyclicBarrier(parties);
        }

    }

    public static class ActionBuilder implements Builder<CyclicBarrier> {

        private final int parties;
        private final Runnable action;

        private ActionBuilder(int parties, Runnable action) {
            this.parties = parties;
            this.action = action;
        }

        @Override
        public CyclicBarrier build() {
            return new CyclicBarrier(parties, action);
        }
    }

}

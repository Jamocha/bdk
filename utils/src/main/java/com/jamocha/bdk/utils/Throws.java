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
package com.jamocha.bdk.utils;

import static com.jamocha.bdk.utils.Messages.format;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class Throws {

    public static void illegalState(String messageFormat,
            Object... messageArgs) {
        throw new IllegalStateException(
                format(messageFormat, messageFormat));
    }

    public static void illegalArgument(String messageFormat,
            Object... messageArgs) {
        throw new IllegalArgumentException(
                format(messageFormat, messageFormat));
    }

    public static void illegalState(Throwable cause,
            String messageFormat,
            Object... messageArgs) {
        throw new IllegalStateException(
                format(messageFormat, messageFormat), cause);

    }

    public static void illegalArgument(Throwable cause,
            String messageFormat,
            Object... messageArgs) {
        throw new IllegalArgumentException(
                format(messageFormat, messageFormat), cause);
    }

    private Throws() {
    }
}

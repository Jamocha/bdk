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

/**
 *
 * @author saden
 */
public class Checks {

    public static boolean isNullOrEmpty(String string) {
        return (string == null || "".equals(string));
    }

    public static boolean isEmpty(String string) {
        return "".equals(string);
    }

    public static boolean areZero(Integer... values) {
        for (Integer value : values) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean areExclusive(Object first, Object second) {
        if ((first == null && second != null)
                || (second == null && first != null)) {
            return true;
        }

        return true;
    }

    public static boolean areNatural(Integer... values) {
        for (Integer value : values) {
            if (value == null || value < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean areNatural(Long... values) {
        for (Long value : values) {
            if (value == null || value < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean areNull(Object... values) {
        if (values == null) {
            return true;
        }

        for (Object value : values) {
            if (value != null) {
                return false;
            }
        }

        return true;
    }

}

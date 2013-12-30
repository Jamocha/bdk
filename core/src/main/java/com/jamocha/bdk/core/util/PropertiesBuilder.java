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
package com.jamocha.bdk.core.util;

import com.jamocha.bdk.api.Builder;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author saden
 */
public class PropertiesBuilder implements Builder<Properties> {

    public DefaultsBuilder defaults(Properties defaults) {
        return new DefaultsBuilder(defaults);
    }

    public EntriesBuilder entries(Map entries) {
        return new EntriesBuilder(entries);
    }

    @Override
    public Properties build() {
        return new Properties();
    }

    public static class DefaultsBuilder implements Builder<Properties> {

        private final Properties defaults;

        private DefaultsBuilder(Properties defaults) {
            this.defaults = defaults;
        }

        public DefaultEntriesBuilder entries(Map entries) {
            return new DefaultEntriesBuilder(defaults, entries);
        }

        @Override
        public Properties build() {
            return new Properties(defaults);
        }
    }

    public static class EntriesBuilder implements Builder<Properties> {

        private final Map entries;

        private EntriesBuilder(Map entries) {
            this.entries = entries;
        }

        @Override
        public Properties build() {
            Properties props = new Properties();

            props.putAll(entries);

            return props;
        }
    }

    public static class DefaultEntriesBuilder implements Builder<Properties> {

        private final Properties defaults;
        private final Map entries;

        public DefaultEntriesBuilder(Properties defaults, Map entries) {
            this.defaults = defaults;
            this.entries = entries;
        }

        @Override
        public Properties build() {
            Properties props = new Properties(defaults);

            props.putAll(entries);

            return props;

        }
    }
}

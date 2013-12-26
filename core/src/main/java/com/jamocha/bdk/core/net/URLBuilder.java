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
package com.jamocha.bdk.core.net;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class URLBuilder {

    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }

    public ComponentBuilder componentBuilder() {
        return new ComponentBuilder();
    }

    public static abstract class BaseBuilder implements Builder<URL> {

    }

    public static class StringBuilder extends BaseBuilder {

        private String value;
        private URL context;
        private URLStreamHandler handler;

        @Required
        public StringBuilder value(String value) {
            this.value = value;

            return this;
        }

        @Optional
        public StringBuilder context(URL context) {
            this.context = context;

            return this;
        }

        @Optional
        public StringBuilder handler(URLStreamHandler handler) {
            this.handler = handler;

            return this;
        }

        @Override
        public URL build() throws MalformedURLException {
            return new URL(context, value, handler);
        }
    }

    public static class ComponentBuilder extends BaseBuilder {

        public static final Integer DEFAULT_PORT = -1;
        private String protocol;
        private String host;
        private int port = DEFAULT_PORT;
        private String file;
        private URLStreamHandler handler;

        @Required
        public ComponentBuilder protocol(String protocol) {
            this.protocol = protocol;

            return this;
        }

        @Required
        public ComponentBuilder host(String host) {
            this.host = host;

            return this;
        }

        @Optional
        public ComponentBuilder port(int port) {
            this.port = port;

            return this;
        }

        @Required
        public ComponentBuilder file(String file) {
            this.file = file;

            return this;
        }

        @Optional
        public ComponentBuilder handler(URLStreamHandler handler) {
            this.handler = handler;

            return this;
        }

        @Override
        public URL build() throws MalformedURLException {
            return new URL(protocol, host, port, file, handler);
        }

    }

}

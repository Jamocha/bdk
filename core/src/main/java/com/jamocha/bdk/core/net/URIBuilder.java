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
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class URIBuilder {

    public StringBuilder stringBuilder() {
        return new StringBuilder();
    }

    public SchemaBuilder schemaBuilder(String scheme) {
        return new SchemaBuilder(scheme);
    }

    public static abstract class BaseBuilder<T> implements Builder<URI> {

    }

    public static class StringBuilder extends BaseBuilder {

        private String value;

        @Required
        public StringBuilder value(String value) {
            this.value = value;

            return this;
        }

        @Override
        public URI build() throws URISyntaxException {
            return new URI(value);
        }
    }

    public static class SpecificBuilder extends BaseBuilder<SpecificBuilder> {

        private final String scheme;
        private String part;
        private String fragment;

        private SpecificBuilder(String scheme) {
            this.scheme = scheme;
        }

        @Required
        public SpecificBuilder part(String part) {
            this.part = part;

            return this;
        }

        @Required
        public SpecificBuilder fragment(String fragment) {
            this.fragment = fragment;

            return this;
        }

        @Override
        public URI build() throws URISyntaxException {
            return new URI(scheme, part, fragment);
        }

    }

    public static class ComponentBuilder extends BaseBuilder<ComponentBuilder> {

        public static final Integer DEFAULT_PORT = -1;
        private final String scheme;

        private String userInfo;
        private String host;
        private int port = DEFAULT_PORT;
        private String path;
        private String query;
        private String fragment;

                private ComponentBuilder(String scheme) {
                    this.scheme = scheme;
                }

                @Optional
        public ComponentBuilder userInfo(String userInfo) {
            this.userInfo = userInfo;

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
        public ComponentBuilder path(String path) {
            this.path = path;

            return this;
        }

        @Optional
        public ComponentBuilder query(String query) {
            this.query = query;

            return this;
        }

        @Required
        public ComponentBuilder fragment(String fragment) {
            this.fragment = fragment;

            return this;
        }

        @Override
        public URI build() throws URISyntaxException {
            return new URI(scheme, userInfo, host, port, path, query, fragment);

        }

    }

    public static class AuthorityBuilder extends BaseBuilder<AuthorityBuilder> {

        private final String scheme;
        private String authority;
        private String path;
        private String query;
        private String fragment;

        private AuthorityBuilder(String scheme) {
            this.scheme = scheme;
        }

        @Required
        public AuthorityBuilder authority(String authority) {
            this.authority = authority;

            return this;
        }

        @Optional
        public AuthorityBuilder path(String path) {
            this.path = path;

            return this;
        }

        @Optional
        public AuthorityBuilder query(String query) {
            this.query = query;

            return this;
        }

        @Optional
        public AuthorityBuilder fragment(String fragment) {
            this.fragment = fragment;

            return this;
        }

        @Override
        public URI build() throws URISyntaxException {
            return new URI(scheme, authority, path, query, fragment);
        }
    }

    public static class SchemaBuilder {

        private final String scheme;

        private SchemaBuilder(String scheme) {
            this.scheme = scheme;
        }

        public SpecificBuilder sepecific() {
            return new SpecificBuilder(scheme);
        }

        public ComponentBuilder component() {
            return new ComponentBuilder(scheme);
        }

        public AuthorityBuilder authority() {
            return new AuthorityBuilder(scheme);
        }
    }

}

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
public class URISyntaxBuilder implements Builder<URI> {

    public static final Integer DEFAULT_PORT = -1;
    private String scheme;
    private String userInfo;
    private String host;
    private int port = DEFAULT_PORT;
    private String path;
    private String query;
    private String fragment;

    @Required
    public URISyntaxBuilder setScheme(String scheme) {
        this.scheme = scheme;

        return this;
    }

    @Optional
    public URISyntaxBuilder setUserInfo(String userInfo) {
        this.userInfo = userInfo;

        return this;
    }

    @Required
    public URISyntaxBuilder setHost(String host) {
        this.host = host;

        return this;
    }

    @Optional
    public URISyntaxBuilder setPort(int port) {
        this.port = port;

        return this;
    }

    @Required
    public URISyntaxBuilder setPath(String path) {
        this.path = path;

        return this;
    }

    @Optional
    public URISyntaxBuilder setQuery(String query) {
        this.query = query;

        return this;
    }

    @Required
    public URISyntaxBuilder setFragment(String fragment) {
        this.fragment = fragment;

        return this;
    }

    @Override
    public URI build() throws URISyntaxException {
        return new URI(scheme, userInfo, host, port, path, query, fragment);

    }

}

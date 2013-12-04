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
import com.jamocha.bdk.api.annotation.Required;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class URIAuthorityBuilder implements Builder<URI> {

    private String scheme;
    private String authority;
    private String path;
    private String query;
    private String fragment;

    @Required
    public URIAuthorityBuilder setScheme(String scheme) {
        this.scheme = scheme;

        return this;
    }

    @Required
    public URIAuthorityBuilder setAuthority(String authority) {
        this.authority = authority;

        return this;
    }

    @Required
    public URIAuthorityBuilder setPath(String path) {
        this.path = path;

        return this;
    }

    @Required
    public URIAuthorityBuilder setQuery(String query) {
        this.query = query;

        return this;
    }

    @Required
    public URIAuthorityBuilder setFragment(String fragment) {
        this.fragment = fragment;

        return this;
    }

    @Override
    public URI build() throws URISyntaxException {
        return new URI(scheme, authority, path, query, fragment);
    }
}

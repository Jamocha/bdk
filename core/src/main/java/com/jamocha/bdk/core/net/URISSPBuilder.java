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
 * @author saden
 */
public class URISSPBuilder implements Builder<URI> {

    private String scheme;
    private String ssp;
    private String fragment;

    @Required
    public URISSPBuilder setScheme(String scheme) {
        this.scheme = scheme;

        return this;
    }

    @Required
    public URISSPBuilder setSSP(String ssp) {
        this.ssp = ssp;

        return this;
    }

    @Required
    public URISSPBuilder setFragment(String fragment) {
        this.fragment = fragment;

        return this;
    }

    public URI build() throws URISyntaxException {
        return new URI(scheme, ssp, fragment);
    }
}

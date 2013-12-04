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
public class URLBuilder implements Builder<URL> {

    private String spec;
    private URL context;
    private URLStreamHandler handler;

    @Required
    public URLBuilder setSpec(String spec) {
        this.spec = spec;

        return this;
    }

    @Optional
    public URLBuilder setContext(URL context) {
        this.context = context;

        return this;
    }

    @Optional
    public URLBuilder setHandler(URLStreamHandler handler) {
        this.handler = handler;

        return this;
    }

    @Override
    public URL build() throws MalformedURLException {
        return new URL(context, spec, handler);
    }

}

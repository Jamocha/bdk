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
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class URLClassLoaderBuilder implements Builder<URLClassLoader> {

    private URL[] urls;
    private ClassLoader parent;
    private URLStreamHandlerFactory factory;

    @Required
    public URLClassLoaderBuilder urls(URL[] urls) {
        this.urls = urls;

        return this;
    }

    @Optional
    public URLClassLoaderBuilder parent(ClassLoader parent) {
        this.parent = parent;

        return this;
    }

    @Optional
    public URLClassLoaderBuilder factory(URLStreamHandlerFactory factory) {
        this.factory = factory;

        return this;
    }

    @Override
    public URLClassLoader build() {
        if (parent == null && factory == null) {
            return new URLClassLoader(urls);
        }

        return new URLClassLoader(urls, parent, factory);
    }

}

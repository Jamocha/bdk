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
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class URLClassLoaderBuilder {

    private URL[] urls;
    private ClassLoader loader;
    private URLStreamHandlerFactory factory;

    public UrlsBuilder urls(URL[] urls) {
        return new UrlsBuilder(urls);
    }

    public static class UrlsBuilder implements Builder<URLClassLoader> {

        private final URL[] urls;

        private UrlsBuilder(URL[] urls) {
            this.urls = urls;
        }

        @Optional
        public LoaderBuilder loader(ClassLoader loader) {
            return new LoaderBuilder(urls, loader);
        }

        @Override
        public URLClassLoader build() {
            return new URLClassLoader(urls);
        }

    }

    public static class LoaderBuilder implements Builder<URLClassLoader> {

        private final URL[] urls;
        private final ClassLoader loader;
        private URLStreamHandlerFactory factory;

        private LoaderBuilder(URL[] urls, ClassLoader loader) {
            this.urls = urls;
            this.loader = loader;
        }

        @Optional
        public LoaderBuilder factory(URLStreamHandlerFactory factory) {
            this.factory = factory;

            return this;
        }

        @Override
        public URLClassLoader build() {
            if (factory == null) {
                return new URLClassLoader(urls, loader);
            }

            return new URLClassLoader(urls, loader, factory);
        }
    }

}

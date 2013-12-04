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
public class URLSyntaxBuilder implements Builder<URL> {

    private String protocol;
    private String host;
    private int port = -1;
    private String file;
    private URLStreamHandler handler;

    @Required
    public URLSyntaxBuilder setProtocol(String protocol) {
        this.protocol = protocol;

        return this;
    }

    @Required
    public URLSyntaxBuilder setHost(String host) {
        this.host = host;

        return this;
    }

    @Optional
    public URLSyntaxBuilder setPort(int port) {
        this.port = port;

        return this;
    }

    @Required
    public URLSyntaxBuilder setFile(String file) {
        this.file = file;

        return this;
    }

    @Optional
    public URLSyntaxBuilder setHandler(URLStreamHandler handler) {
        this.handler = handler;

        return this;
    }

    @Override
    public URL build() throws MalformedURLException {
        return new URL(protocol, host, port, file, handler);
    }

}

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
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class SocketBuilder implements Builder<Socket> {

    private Integer port;
    private InetAddress address;
    private String host;

    @Alternate
    @Required
    public SocketBuilder setAddress(InetAddress address) {
        this.address = address;

        return this;
    }

    @Alternate
    @Required
    public SocketBuilder setHost(String host) {
        this.host = host;

        return this;
    }

    @Required
    @Optional
    public SocketBuilder setPort(int port) {
        this.port = port;

        return this;
    }

    @Override
    public Socket build() throws IOException {
        if ((address == null || host == null)
                && port == null) {
            return new Socket();
        }

        if (host != null) {
            address = InetAddress.getByName(host);
        }

        return new Socket(address, port);

    }

}

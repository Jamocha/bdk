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
public class SocketConnectionBuilder implements Builder<Socket> {

    private Integer localPort;
    private InetAddress localAddress;
    private String localHost;

    private Integer remotePort;
    private InetAddress remoteAddress;
    private String remoteHost;

    @Alternate
    @Required
    public SocketConnectionBuilder setRemoteAddress(InetAddress address) {
        this.remoteAddress = address;

        return this;
    }

    @Alternate
    @Required
    public SocketConnectionBuilder setRemoteHost(String host) {
        this.remoteHost = host;

        return this;
    }

    @Required
    @Optional
    public SocketConnectionBuilder setRemotePort(int port) {
        this.remotePort = port;

        return this;
    }

    @Alternate
    @Required
    public SocketConnectionBuilder setLocalAddress(InetAddress address) {
        this.localAddress = address;

        return this;
    }

    @Alternate
    @Required
    public SocketConnectionBuilder setLocalHost(String host) {
        this.localHost = host;

        return this;
    }

    @Required
    @Optional
    public SocketConnectionBuilder setLocalPort(int port) {
        this.localPort = port;

        return this;
    }

    @Override
    public Socket build() throws IOException {
        if (localHost != null) {
            localAddress = InetAddress.getByName(localHost);
        }

        if (remoteHost != null) {
            remoteAddress = InetAddress.getByName(remoteHost);
        }

        return new Socket(remoteAddress, remotePort, localAddress, localPort);
    }

}

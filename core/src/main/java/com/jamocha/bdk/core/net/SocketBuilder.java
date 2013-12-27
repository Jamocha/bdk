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
import java.io.IOException;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class SocketBuilder implements Builder<Socket> {

    @Override
    public Socket build() {
        return new Socket();
    }

    public PortBuilder port(int port) {
        return new PortBuilder(port);
    }

    public ProxyBuilder proxy(Proxy proxy) {
        return new ProxyBuilder(proxy);
    }

    public static class ProxyBuilder implements Builder<Socket> {

        private final Proxy proxy;

        private ProxyBuilder(Proxy proxy) {
            this.proxy = proxy;
        }

        @Override
        public Socket build() {
            return new Socket(proxy);
        }
    }

    public static class HostBuilder implements Builder<Socket> {

        final String host;
        final Integer port;

        private HostBuilder(String host, Integer port) {
            this.port = port;
            this.host = host;
        }

        @Optional
        public HostBinderBuilder bind(InetAddress address, int port) {
            return new HostBinderBuilder(host, this.port, address, port);
        }

        @Override
        public Socket build() throws IOException {
            return new Socket(host, port);
        }
    }

    public static class HostBinderBuilder extends HostBuilder {

        private final InetAddress localAddress;
        private final Integer localPort;

        private HostBinderBuilder(String host,
                Integer port,
                InetAddress localAddress,
                Integer localPort) {
            super(host, port);
            this.localAddress = localAddress;
            this.localPort = localPort;
        }

        @Override
        public Socket build() throws IOException {
            return new Socket(host, port, localAddress, localPort);
        }
    }

    public static class InetBuilder implements Builder<Socket> {

        final InetAddress address;
        final Integer port;

        private InetBuilder(InetAddress address, Integer port) {
            this.address = address;
            this.port = port;
        }

        @Optional
        public BoundInetBuilder bind(InetAddress address, int port) {
            return new BoundInetBuilder(this.address, this.port, address, port);
        }

        @Override
        public Socket build() throws IOException {
            return new Socket(address, port);
        }
    }

    public static class BoundInetBuilder extends InetBuilder {

        private final InetAddress localAddress;
        private final Integer localPort;

        private BoundInetBuilder(InetAddress address,
                Integer port,
                InetAddress localAddress,
                Integer localPort) {
            super(address, port);
            this.localAddress = localAddress;
            this.localPort = localPort;
        }

        @Override
        public Socket build() throws IOException {
            return new Socket(address, port, localAddress, localPort);
        }
    }

    public static class PortBuilder {

        private final Integer port;

        private PortBuilder(Integer port) {
            this.port = port;
        }

        public HostBuilder host(String host) {
            return new HostBuilder(host, port);
        }

        public InetBuilder inet(InetAddress address) {
            return new InetBuilder(address, port);
        }
    }

}

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
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class DatagramSocketBuilder implements Builder<DatagramSocket> {

    public SocketBuilder socket(SocketAddress address) {
        return new SocketBuilder(address);
    }

    public InetBuilder inet(int port) {
        return new InetBuilder(port);
    }

    @Override
    public DatagramSocket build() throws SocketException {
        return new DatagramSocket();
    }

    public static abstract class BaseBuilder implements Builder<DatagramSocket> {

    }

    public static class SocketBuilder extends BaseBuilder {

        private final SocketAddress address;

        private SocketBuilder(SocketAddress address) {
            this.address = address;
        }

        @Override
        public DatagramSocket build() throws SocketException {
            return new DatagramSocket(address);
        }

    }

    public static class InetBuilder extends BaseBuilder {

        private InetAddress address;
        private final Integer port;

        private InetBuilder(Integer port) {
            this.port = port;
        }

        @Optional
        public InetBuilder address(InetAddress address) {
            this.address = address;

            return this;
        }

        @Override
        public DatagramSocket build() throws SocketException {
            return new DatagramSocket(port, address);
        }

    }

}

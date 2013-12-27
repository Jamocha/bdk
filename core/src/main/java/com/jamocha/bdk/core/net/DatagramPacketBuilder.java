/*
 * Copyright 2013 saden.
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
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class DatagramPacketBuilder {

    public static BufferBuilder buffer() {
        return new BufferBuilder();
    }

    public SocketBuilder socket(SocketAddress address) {
        return new SocketBuilder(address);
    }

    public InetBuilder inet(InetAddress address, int port) {
        return new InetBuilder(address, port);
    }

    public static abstract class BaseBufferBuilder<T> implements Builder<DatagramPacket> {

        public static final Integer DEFAULT_OFFSET = 0;
        byte[] buffer;
        Integer offset = DEFAULT_OFFSET;
        Integer length;

        @Required
        public T buffer(byte[] buffer) {
            this.buffer = buffer;

            return (T) this;
        }

        @Required
        public T length(int length) {
            this.length = length;

            return (T) this;
        }

        @Optional
        public T offset(int offset) {
            this.offset = offset;

            return (T) this;
        }
    }

    public static class BufferBuilder extends BaseBufferBuilder<BufferBuilder> {

        @Override
        public DatagramPacket build() throws Exception {
            return new DatagramPacket(buffer, offset, length);
        }
    }

    public static class InetBuilder extends BaseBufferBuilder<InetBuilder> {

        private final InetAddress address;
        private final Integer port;

        private InetBuilder(InetAddress address, Integer port) {
            this.address = address;
            this.port = port;
        }

        @Override
        public DatagramPacket build() throws Exception {
            return new DatagramPacket(buffer, offset, length, address, port);
        }
    }

    public static class SocketBuilder extends BaseBufferBuilder<SocketBuilder> {

        private final SocketAddress address;

        private SocketBuilder(SocketAddress address) {
            this.address = address;
        }

        @Override
        public DatagramPacket build() throws SocketException {
            return new DatagramPacket(buffer, offset, length, address);
        }
    }
}

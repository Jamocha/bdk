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
import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class DatagramPacketInetBuilder implements Builder<DatagramPacket> {

    public static final Integer DEFAULT_OFFSET = 0;
    private byte[] buffer;
    private Integer offset = DEFAULT_OFFSET;
    private Integer length;
    private InetAddress address;
    private Integer port;

    @Required
    public DatagramPacketInetBuilder setBuffer(byte[] buffer) {
        this.buffer = buffer;

        return this;
    }

    @Required
    public DatagramPacketInetBuilder setLength(int length) {
        this.length = length;

        return this;
    }

    @Required
    public DatagramPacketInetBuilder setAddress(InetAddress address) {
        this.address = address;

        return this;
    }

    @Required
    public DatagramPacketInetBuilder setPort(int port) {
        this.port = port;

        return this;
    }

    @Optional
    public DatagramPacketInetBuilder setOffset(int offset) {
        this.offset = offset;

        return this;
    }

    @Override
    public DatagramPacket build() {
        return new DatagramPacket(buffer, offset, length, address, port);
    }

}

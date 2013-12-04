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
import java.io.IOException;
import java.net.MulticastSocket;
import java.net.SocketAddress;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class MulticastSocketBuilder implements Builder<MulticastSocket> {

    public static final Integer DEFAULT_PORT = 0;

    private Integer port = DEFAULT_PORT;
    private SocketAddress address;

    @Alternate
    public MulticastSocketBuilder setPort(Integer port) {
        this.port = port;

        return this;
    }

    @Alternate
    public MulticastSocketBuilder setAddress(SocketAddress address) {
        this.address = address;

        return this;
    }

    @Override
    public MulticastSocket build() throws IOException {
        if (address == null) {
            return new MulticastSocket(port);
        }

        return new MulticastSocket(address);
    }

}

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
import java.net.InetSocketAddress;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class InetSocketAddressBuilder implements Builder<InetSocketAddress> {

    private Integer port;
    private InetAddress address;
    private String host;

    @Required
    public InetSocketAddressBuilder setPort(int port) {
        this.port = port;

        return this;
    }

    @Alternate
    @Optional
    public InetSocketAddressBuilder setAddress(InetAddress address) {
        this.address = address;

        return this;
    }

    @Alternate
    @Optional
    public InetSocketAddressBuilder setHost(String host) {
        this.host = host;

        return this;
    }

    @Override
    public InetSocketAddress build() throws IOException {
        if (host == null && address == null) {
            return new InetSocketAddress(port);
        }

        if (host != null) {
            address = InetAddress.getByName(host);
        }

        return new InetSocketAddress(address, port);

    }

}

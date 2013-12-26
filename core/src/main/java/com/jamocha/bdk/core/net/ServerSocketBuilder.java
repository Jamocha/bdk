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
import java.net.ServerSocket;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class ServerSocketBuilder implements Builder<ServerSocket> {

    @Override
    public ServerSocket build() throws IOException {
        return new ServerSocket();
    }

    public BoundServerBuilder bind(int port) {
        return new BoundServerBuilder(port);

    }

    public static class BoundServerBuilder implements Builder<ServerSocket> {

        public static final Integer DEFAULT_BACKLOG = 50;

        private final Integer port;
        private Integer backlog = DEFAULT_BACKLOG;
        private InetAddress address;

        private BoundServerBuilder(Integer port) {
            this.port = port;
        }

        @Optional
        public BoundServerBuilder address(InetAddress address) {
            this.address = address;

            return this;
        }

        @Optional
        public BoundServerBuilder backlog(int backlog) {
            this.backlog = backlog;

            return this;
        }

        @Override
        public ServerSocket build() throws IOException {
            return new ServerSocket(port, backlog, address);
        }
    }

}

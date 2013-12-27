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
package com.jamocha.bdk.core.io;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Alternate;
import com.jamocha.bdk.api.annotation.Optional;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.forName;
import java.nio.charset.CharsetDecoder;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class InputStreamReaderBuilder {

    public StreamBuilder input(InputStream input) {
        return new StreamBuilder(input);
    }

    public static class StreamBuilder implements Builder<InputStreamReader> {

        private final InputStream input;

        public StreamBuilder(InputStream input) {
            this.input = input;
        }

        @Alternate
        @Optional
        public CharsetBuilder charset(String charset) {
            return new CharsetBuilder(input, forName(charset));
        }

        @Alternate
        @Optional
        public CharsetBuilder charset(Charset charset) {
            return new CharsetBuilder(input, charset);
        }

        @Alternate
        @Optional
        public DecoderBuilder charset(CharsetDecoder decoder) {
            return new DecoderBuilder(input, decoder);
        }

        @Override
        public InputStreamReader build() throws Exception {
            return new InputStreamReader(input);
        }

    }

    public static class CharsetBuilder implements Builder<InputStreamReader> {

        private final InputStream input;
        private final Charset charset;

        public CharsetBuilder(InputStream input, Charset charset) {
            this.input = input;
            this.charset = charset;
        }

        @Override
        public InputStreamReader build() {
            return new InputStreamReader(input, charset);
        }
    }

    public static class DecoderBuilder implements Builder<InputStreamReader> {

        private final InputStream input;
        private final CharsetDecoder decoder;

        public DecoderBuilder(InputStream input, CharsetDecoder decoder) {
            this.input = input;
            this.decoder = decoder;
        }

        @Override
        public InputStreamReader build() {
            return new InputStreamReader(input, decoder);
        }
    }

}

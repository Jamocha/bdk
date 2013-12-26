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
import com.jamocha.bdk.api.annotation.Required;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;
import static java.nio.charset.Charset.forName;
import java.nio.charset.CharsetDecoder;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class InputStreamReaderBuilder implements Builder<InputStreamReader> {

    private InputStream inputStream;
    private Charset charset = defaultCharset();
    private CharsetDecoder decoder;

    @Required
    public InputStreamReaderBuilder input(InputStream inputStream) {
        this.inputStream = inputStream;

        return this;
    }

    @Alternate
    @Optional
    public InputStreamReaderBuilder charset(Charset charset) {
        this.charset = charset;

        return this;
    }

    @Alternate
    @Optional
    public InputStreamReaderBuilder charset(String charname) {
        this.charset = forName(charname);

        return this;
    }

    @Optional
    public InputStreamReaderBuilder decoder(CharsetDecoder decoder) {
        this.decoder = decoder;

        return this;
    }

    @Override
    public InputStreamReader build() {
        if (decoder == null) {
            return new InputStreamReader(inputStream, charset);
        }

        return new InputStreamReader(inputStream, decoder);
    }

}

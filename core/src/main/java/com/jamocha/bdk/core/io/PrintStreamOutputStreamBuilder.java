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
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class PrintStreamOutputStreamBuilder implements Builder<PrintStream> {

    public static final Boolean DEFAULT_AUTOFLUSH = false;
    private OutputStream outputStream;
    private Boolean autoflush = DEFAULT_AUTOFLUSH;
    private String charset = defaultCharset().name();

    @Required
    public PrintStreamOutputStreamBuilder setOutput(OutputStream outputStream) {
        this.outputStream = outputStream;

        return this;
    }

    @Optional
    public PrintStreamOutputStreamBuilder setAutoflush(boolean autoflush) {
        this.autoflush = autoflush;

        return this;
    }

    @Alternate
    @Optional
    public PrintStreamOutputStreamBuilder setCharset(Charset charset) {
        this.charset = charset.name();

        return this;
    }

    @Alternate
    @Optional
    public PrintStreamOutputStreamBuilder setCharset(String charset) {
        this.charset = charset;

        return this;
    }

    @Override
    public PrintStream build() throws UnsupportedEncodingException {
        return new PrintStream(outputStream, true, charset);
    }

}

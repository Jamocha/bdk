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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import static java.nio.charset.Charset.defaultCharset;

/**
 *
 * @author saden
 */
public class PrintWriterFileBuilder implements Builder<PrintWriter> {

    private File file;
    private String charset = defaultCharset().name();

    @Required
    @Alternate
    public PrintWriterFileBuilder setFile(File file) {
        this.file = file;

        return this;
    }

    @Required
    @Alternate
    public PrintWriterFileBuilder setFile(String name) {
        this.file = new File(name);

        return this;
    }

    @Optional
    @Alternate
    public PrintWriterFileBuilder setCharset(Charset charset) {
        this.charset = charset.name();

        return this;
    }

    @Optional
    @Alternate
    public PrintWriterFileBuilder setCharset(String charset) {
        this.charset = charset;

        return this;
    }

    public PrintWriter build() throws FileNotFoundException,
            UnsupportedEncodingException {
        return new PrintWriter(file, charset);
    }

}
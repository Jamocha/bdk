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
import com.jamocha.bdk.api.annotation.Optional;
import java.io.StringWriter;

/**
 *
 * @author saden
 */
public class StringWriterBuilder implements Builder<StringWriter> {

    public static final Integer DEFAULT_SIZE = 16;
    private Integer size;

    @Optional
    public void setSize(int size) {
        this.size = size;
    }

    public StringWriter build() throws Exception {
        return new StringWriter(size);
    }

}

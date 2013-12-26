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
package com.jamocha.bdk.core.util;

import com.jamocha.bdk.api.Builder;
import com.jamocha.bdk.api.annotation.Optional;
import com.jamocha.bdk.api.annotation.Required;
import java.util.Locale;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class LocaleBuilder implements Builder<Locale> {

    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_VARIANT = "";

    private String language;
    private String country = DEFAULT_COUNTRY;
    private String variant = DEFAULT_VARIANT;

    @Required
    public LocaleBuilder language(String language) {
        this.language = language;

        return this;
    }

    @Optional
    public LocaleBuilder country(String country) {
        this.country = country;

        return this;
    }

    @Optional
    public LocaleBuilder variant(String variant) {
        this.variant = variant;

        return this;
    }

    @Override
    public Locale build() {
        return new Locale(language, country, variant);
    }

}

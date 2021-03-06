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
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;

/**
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class CookieManagerBuilder implements Builder<CookieManager> {

    private CookieStore store;
    private CookiePolicy policy;

    public CookieManagerBuilder store(CookieStore store) {
        this.store = store;

        return this;
    }

    public CookieManagerBuilder policy(CookiePolicy policy) {
        this.policy = policy;

        return this;
    }

    @Override
    public CookieManager build() {
        return new CookieManager(store, policy);
    }

}

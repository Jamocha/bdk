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
import com.jamocha.bdk.api.annotation.Required;
import java.io.FilePermission;

/**
 * TODO: enhance actions permissions
 *
 * @author Sharmarke Aden <www.github.com/saden1>
 */
public class FilePermissionBuilder implements Builder<FilePermission> {

    private String path;
    private String actions;

    @Required
    public FilePermissionBuilder setPath(String path) {
        this.path = path;

        return this;
    }

    @Required
    public FilePermissionBuilder setActions(String actions) {
        this.actions = actions;

        return this;
    }

    @Override
    public FilePermission build() {
        return new FilePermission(path, actions);
    }

}

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
import com.jamocha.bdk.api.annotation.Required;
import java.io.File;

/**
 *
 * @author saden
 */

public class FileHierarchyBuilder implements Builder<File> {

    private String child;
    private String parent;

    @Required
    public FileHierarchyBuilder setParent(String parent) {
        this.parent = parent;

        return this;
    }

    @Required
    public FileHierarchyBuilder setChild(String child) {
        this.child = child;

        return this;
    }

    @Optional
    public FileHierarchyBuilder setParent(File parent) {
        this.parent = parent.getPath();

        return this;
    }

    public File build() {
        return new File(parent, child);
    }

}

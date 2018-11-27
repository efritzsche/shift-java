// Generated by ast.js
/**
 * Copyright 2018 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.shapesecurity.shift.es2017.ast;

import javax.annotation.Nonnull;
import com.shapesecurity.functional.data.HashCodeBuilder;
import com.shapesecurity.functional.data.Maybe;

public class ExportFromSpecifier implements Node {
    @Nonnull
    public final String name;

    @Nonnull
    public final Maybe<String> exportedName;


    public ExportFromSpecifier (@Nonnull String name, @Nonnull Maybe<String> exportedName) {
        this.name = name;
        this.exportedName = exportedName;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof ExportFromSpecifier && this.name.equals(((ExportFromSpecifier) object).name) && this.exportedName.equals(((ExportFromSpecifier) object).exportedName);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "ExportFromSpecifier");
        code = HashCodeBuilder.put(code, this.name);
        code = HashCodeBuilder.put(code, this.exportedName);
        return code;
    }

}
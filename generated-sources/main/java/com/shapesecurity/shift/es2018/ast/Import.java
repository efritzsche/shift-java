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


package com.shapesecurity.shift.es2018.ast;

import javax.annotation.Nonnull;
import com.shapesecurity.functional.data.HashCodeBuilder;
import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;

public class Import extends ImportDeclaration {
    @Nonnull
    public final Maybe<BindingIdentifier> defaultBinding;

    @Nonnull
    public final ImmutableList<ImportSpecifier> namedImports;


    public Import (@Nonnull Maybe<BindingIdentifier> defaultBinding, @Nonnull ImmutableList<ImportSpecifier> namedImports, @Nonnull String moduleSpecifier) {
        super(moduleSpecifier);
        this.defaultBinding = defaultBinding;
        this.namedImports = namedImports;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof Import && this.defaultBinding.equals(((Import) object).defaultBinding) && this.namedImports.equals(((Import) object).namedImports) && this.moduleSpecifier.equals(((Import) object).moduleSpecifier);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "Import");
        code = HashCodeBuilder.put(code, this.defaultBinding);
        code = HashCodeBuilder.put(code, this.namedImports);
        code = HashCodeBuilder.put(code, this.moduleSpecifier);
        return code;
    }

}

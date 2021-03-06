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
import com.shapesecurity.shift.es2018.ast.operators.Precedence;

public class LiteralRegExpExpression implements Expression {
    @Nonnull
    public final String pattern;

    @Nonnull
    public final boolean global;

    @Nonnull
    public final boolean ignoreCase;

    @Nonnull
    public final boolean multiLine;

    @Nonnull
    public final boolean dotAll;

    @Nonnull
    public final boolean unicode;

    @Nonnull
    public final boolean sticky;


    public LiteralRegExpExpression (@Nonnull String pattern, boolean global, boolean ignoreCase, boolean multiLine, boolean dotAll, boolean unicode, boolean sticky) {
        this.pattern = pattern;
        this.global = global;
        this.ignoreCase = ignoreCase;
        this.multiLine = multiLine;
        this.dotAll = dotAll;
        this.unicode = unicode;
        this.sticky = sticky;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof LiteralRegExpExpression && this.pattern.equals(((LiteralRegExpExpression) object).pattern) && this.global == ((LiteralRegExpExpression) object).global && this.ignoreCase == ((LiteralRegExpExpression) object).ignoreCase && this.multiLine == ((LiteralRegExpExpression) object).multiLine && this.dotAll == ((LiteralRegExpExpression) object).dotAll && this.unicode == ((LiteralRegExpExpression) object).unicode && this.sticky == ((LiteralRegExpExpression) object).sticky;
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "LiteralRegExpExpression");
        code = HashCodeBuilder.put(code, this.pattern);
        code = HashCodeBuilder.put(code, this.global);
        code = HashCodeBuilder.put(code, this.ignoreCase);
        code = HashCodeBuilder.put(code, this.multiLine);
        code = HashCodeBuilder.put(code, this.dotAll);
        code = HashCodeBuilder.put(code, this.unicode);
        code = HashCodeBuilder.put(code, this.sticky);
        return code;
    }

    @Override
    @Nonnull
    public Precedence getPrecedence() {
        return Precedence.PRIMARY;
    }

}

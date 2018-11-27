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
import com.shapesecurity.shift.es2017.ast.operators.UpdateOperator;
import com.shapesecurity.shift.es2017.ast.operators.Precedence;

public class UpdateExpression implements Expression {
    @Nonnull
    public final boolean isPrefix;

    @Nonnull
    public final UpdateOperator operator;

    @Nonnull
    public final SimpleAssignmentTarget operand;


    public UpdateExpression (boolean isPrefix, @Nonnull UpdateOperator operator, @Nonnull SimpleAssignmentTarget operand) {
        this.isPrefix = isPrefix;
        this.operator = operator;
        this.operand = operand;
    }


    @Override
    public boolean equals(Object object) {
        return object instanceof UpdateExpression && this.isPrefix == ((UpdateExpression) object).isPrefix && this.operator.equals(((UpdateExpression) object).operator) && this.operand.equals(((UpdateExpression) object).operand);
    }


    @Override
    public int hashCode() {
        int code = HashCodeBuilder.put(0, "UpdateExpression");
        code = HashCodeBuilder.put(code, this.isPrefix);
        code = HashCodeBuilder.put(code, this.operator);
        code = HashCodeBuilder.put(code, this.operand);
        return code;
    }

    @Override
    @Nonnull
    public Precedence getPrecedence() {
        return this.isPrefix ? Precedence.PREFIX : Precedence.POSTFIX;
    }

}
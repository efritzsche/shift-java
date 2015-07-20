// Generated by src/generate-spec-java.js 

/**
 * Copyright 2015 Shape Security, Inc.
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

package com.shapesecurity.shift.ast;

import org.jetbrains.annotations.NotNull;
import com.shapesecurity.functional.data.HashCodeBuilder;
import com.shapesecurity.shift.ast.operators.Precedence;
import com.shapesecurity.shift.ast.operators.UpdateOperator;

public class UpdateExpression extends Expression
{

  @NotNull
  public final Boolean isPrefix;

  @NotNull
  public final UpdateOperator operator;

  @NotNull
  public final BindingIdentifierMemberExpression operand;

  public UpdateExpression (@NotNull Boolean isPrefix, @NotNull UpdateOperator operator, @NotNull BindingIdentifierMemberExpression operand)
  {
    super();
    this.isPrefix = isPrefix;
    this.operator = operator;
    this.operand = operand;
  }

  @NotNull
  public Boolean getIsPrefix()
  {
    return this.isPrefix;
  }

  @NotNull
  public UpdateOperator getOperator()
  {
    return this.operator;
  }

  @NotNull
  public BindingIdentifierMemberExpression getOperand()
  {
    return this.operand;
  }

  @NotNull
  public UpdateExpression setIsPrefix(@NotNull Boolean isPrefix)
  {
    return new UpdateExpression(isPrefix, this.operator, this.operand);
  }

  @NotNull
  public UpdateExpression setOperator(@NotNull UpdateOperator operator)
  {
    return new UpdateExpression(this.isPrefix, operator, this.operand);
  }

  @NotNull
  public UpdateExpression setOperand(@NotNull BindingIdentifierMemberExpression operand)
  {
    return new UpdateExpression(this.isPrefix, this.operator, operand);
  }

  @Override
  @NotNull
  public Precedence getPrecedence()
  {
    return this.isPrefix ? Precedence.PREFIX : Precedence.POSTFIX;
  }

}
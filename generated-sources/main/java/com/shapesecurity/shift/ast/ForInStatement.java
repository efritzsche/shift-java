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

public class ForInStatement extends IterationStatement
{

  @NotNull
  public final VariableDeclarationBinding left;

  @NotNull
  public final Expression right;

  @NotNull
  public final Statement body;

  public ForInStatement (@NotNull VariableDeclarationBinding left, @NotNull Expression right, @NotNull Statement body)
  {
    super(body);
    this.left = left;
    this.right = right;
    this.body = body;
  }

  @NotNull
  public VariableDeclarationBinding getLeft()
  {
    return this.left;
  }

  @NotNull
  public Expression getRight()
  {
    return this.right;
  }

  @NotNull
  public Statement getBody()
  {
    return this.body;
  }

  @NotNull
  public ForInStatement setLeft(@NotNull VariableDeclarationBinding left)
  {
    return new ForInStatement(left, this.right, this.body);
  }

  @NotNull
  public ForInStatement setRight(@NotNull Expression right)
  {
    return new ForInStatement(this.left, right, this.body);
  }

  @NotNull
  public ForInStatement setBody(@NotNull Statement body)
  {
    return new ForInStatement(this.left, this.right, body);
  }

}
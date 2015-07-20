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

public class Export extends ExportDeclaration
{

  @NotNull
  public final FunctionDeclarationClassDeclarationVariableDeclaration declaration;

  public Export (@NotNull FunctionDeclarationClassDeclarationVariableDeclaration declaration)
  {
    super();
    this.declaration = declaration;
  }

  @NotNull
  public FunctionDeclarationClassDeclarationVariableDeclaration getDeclaration()
  {
    return this.declaration;
  }

  @NotNull
  public Export setDeclaration(@NotNull FunctionDeclarationClassDeclarationVariableDeclaration declaration)
  {
    return new Export(declaration);
  }

}
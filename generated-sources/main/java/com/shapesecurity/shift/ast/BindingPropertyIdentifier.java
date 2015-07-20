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
import com.shapesecurity.functional.data.Maybe;

public class BindingPropertyIdentifier extends BindingProperty
{

  @NotNull
  public final BindingIdentifier binding;

  @NotNull
  public final Maybe<Expression> init;

  public BindingPropertyIdentifier (@NotNull BindingIdentifier binding, @NotNull Maybe<Expression> init)
  {
    super();
    this.binding = binding;
    this.init = init;
  }

  @NotNull
  public BindingIdentifier getBinding()
  {
    return this.binding;
  }

  @NotNull
  public Maybe<Expression> getInit()
  {
    return this.init;
  }

  @NotNull
  public BindingPropertyIdentifier setBinding(@NotNull BindingIdentifier binding)
  {
    return new BindingPropertyIdentifier(binding, this.init);
  }

  @NotNull
  public BindingPropertyIdentifier setInit(@NotNull Maybe<Expression> init)
  {
    return new BindingPropertyIdentifier(this.binding, init);
  }

}
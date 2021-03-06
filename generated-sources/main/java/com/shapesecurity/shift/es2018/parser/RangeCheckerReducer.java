// Generated by rangechecker.js
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


package com.shapesecurity.shift.es2018.parser;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.functional.data.Maybe;
import com.shapesecurity.functional.data.Monoid;
import com.shapesecurity.shift.es2018.ast.*;
import com.shapesecurity.shift.es2018.reducer.MonoidalReducer;
import javax.annotation.Nonnull;

import static org.junit.Assert.assertTrue;

public class RangeCheckerReducer extends MonoidalReducer<RangeCheckerReducer.RangeChecker> {
    private final ParserWithLocation parserWithLocation;

    protected RangeCheckerReducer(ParserWithLocation parserWithLocation) {
        super(RangeChecker.MONOID);
        this.parserWithLocation = parserWithLocation;
    }

    private RangeChecker accept(Node node, RangeChecker innerBounds) {
        Maybe<SourceSpan> span = this.parserWithLocation.getLocation(node);
        assertTrue(span.isJust());
        RangeChecker outerBounds = new RangeChecker(span.just());
        assertTrue(outerBounds.start <= outerBounds.end);

        assertTrue(outerBounds.start <= innerBounds.start);
        assertTrue(innerBounds.end <= outerBounds.end);

        return outerBounds;
    }

    static class RangeChecker {
        public final static Monoid<RangeChecker> MONOID = new Monoid<RangeChecker>() {
            @Nonnull
            @Override
            public RangeChecker identity() {
                return new RangeChecker(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            @Nonnull
            @Override
            public RangeChecker append(RangeChecker a, RangeChecker b) {
                assertTrue(a.end <= b.start);
                return new RangeChecker(a.start, b.end);
            }
        };
        public final int start, end;

        private RangeChecker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public RangeChecker(SourceSpan sourceSpan) {
            this(sourceSpan.start.offset, sourceSpan.end.offset);
        }
    }

    @Nonnull
    @Override
    public RangeChecker reduceArrayAssignmentTarget(@Nonnull ArrayAssignmentTarget node, @Nonnull ImmutableList<Maybe<RangeChecker>> elements, @Nonnull Maybe<RangeChecker> rest) {
      return accept(node, super.reduceArrayAssignmentTarget(node, elements, rest));
    }

    @Nonnull
    @Override
    public RangeChecker reduceArrayBinding(@Nonnull ArrayBinding node, @Nonnull ImmutableList<Maybe<RangeChecker>> elements, @Nonnull Maybe<RangeChecker> rest) {
      return accept(node, super.reduceArrayBinding(node, elements, rest));
    }

    @Nonnull
    @Override
    public RangeChecker reduceArrayExpression(@Nonnull ArrayExpression node, @Nonnull ImmutableList<Maybe<RangeChecker>> elements) {
      return accept(node, super.reduceArrayExpression(node, elements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceArrowExpression(@Nonnull ArrowExpression node, @Nonnull RangeChecker params, @Nonnull RangeChecker body) {
      return accept(node, super.reduceArrowExpression(node, params, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAssignmentExpression(@Nonnull AssignmentExpression node, @Nonnull RangeChecker binding, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceAssignmentExpression(node, binding, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAssignmentTargetIdentifier(@Nonnull AssignmentTargetIdentifier node) {
      return accept(node, super.reduceAssignmentTargetIdentifier(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAssignmentTargetPropertyIdentifier(@Nonnull AssignmentTargetPropertyIdentifier node, @Nonnull RangeChecker binding, @Nonnull Maybe<RangeChecker> init) {
      return accept(node, super.reduceAssignmentTargetPropertyIdentifier(node, binding, init));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAssignmentTargetPropertyProperty(@Nonnull AssignmentTargetPropertyProperty node, @Nonnull RangeChecker name, @Nonnull RangeChecker binding) {
      return accept(node, super.reduceAssignmentTargetPropertyProperty(node, name, binding));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAssignmentTargetWithDefault(@Nonnull AssignmentTargetWithDefault node, @Nonnull RangeChecker binding, @Nonnull RangeChecker init) {
      return accept(node, super.reduceAssignmentTargetWithDefault(node, binding, init));
    }

    @Nonnull
    @Override
    public RangeChecker reduceAwaitExpression(@Nonnull AwaitExpression node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceAwaitExpression(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBinaryExpression(@Nonnull BinaryExpression node, @Nonnull RangeChecker left, @Nonnull RangeChecker right) {
      return accept(node, super.reduceBinaryExpression(node, left, right));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBindingIdentifier(@Nonnull BindingIdentifier node) {
      return accept(node, super.reduceBindingIdentifier(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBindingPropertyIdentifier(@Nonnull BindingPropertyIdentifier node, @Nonnull RangeChecker binding, @Nonnull Maybe<RangeChecker> init) {
      return accept(node, super.reduceBindingPropertyIdentifier(node, binding, init));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBindingPropertyProperty(@Nonnull BindingPropertyProperty node, @Nonnull RangeChecker name, @Nonnull RangeChecker binding) {
      return accept(node, super.reduceBindingPropertyProperty(node, name, binding));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBindingWithDefault(@Nonnull BindingWithDefault node, @Nonnull RangeChecker binding, @Nonnull RangeChecker init) {
      return accept(node, super.reduceBindingWithDefault(node, binding, init));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBlock(@Nonnull Block node, @Nonnull ImmutableList<RangeChecker> statements) {
      return accept(node, super.reduceBlock(node, statements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBlockStatement(@Nonnull BlockStatement node, @Nonnull RangeChecker block) {
      return accept(node, super.reduceBlockStatement(node, block));
    }

    @Nonnull
    @Override
    public RangeChecker reduceBreakStatement(@Nonnull BreakStatement node) {
      return accept(node, super.reduceBreakStatement(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceCallExpression(@Nonnull CallExpression node, @Nonnull RangeChecker callee, @Nonnull ImmutableList<RangeChecker> arguments) {
      return accept(node, super.reduceCallExpression(node, callee, arguments));
    }

    @Nonnull
    @Override
    public RangeChecker reduceCatchClause(@Nonnull CatchClause node, @Nonnull RangeChecker binding, @Nonnull RangeChecker body) {
      return accept(node, super.reduceCatchClause(node, binding, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceClassDeclaration(@Nonnull ClassDeclaration node, @Nonnull RangeChecker name, @Nonnull Maybe<RangeChecker> _super, @Nonnull ImmutableList<RangeChecker> elements) {
      return accept(node, super.reduceClassDeclaration(node, name, _super, elements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceClassElement(@Nonnull ClassElement node, @Nonnull RangeChecker method) {
      return accept(node, super.reduceClassElement(node, method));
    }

    @Nonnull
    @Override
    public RangeChecker reduceClassExpression(@Nonnull ClassExpression node, @Nonnull Maybe<RangeChecker> name, @Nonnull Maybe<RangeChecker> _super, @Nonnull ImmutableList<RangeChecker> elements) {
      return accept(node, super.reduceClassExpression(node, name, _super, elements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceCompoundAssignmentExpression(@Nonnull CompoundAssignmentExpression node, @Nonnull RangeChecker binding, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceCompoundAssignmentExpression(node, binding, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceComputedMemberAssignmentTarget(@Nonnull ComputedMemberAssignmentTarget node, @Nonnull RangeChecker object, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceComputedMemberAssignmentTarget(node, object, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceComputedMemberExpression(@Nonnull ComputedMemberExpression node, @Nonnull RangeChecker object, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceComputedMemberExpression(node, object, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceComputedPropertyName(@Nonnull ComputedPropertyName node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceComputedPropertyName(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceConditionalExpression(@Nonnull ConditionalExpression node, @Nonnull RangeChecker test, @Nonnull RangeChecker consequent, @Nonnull RangeChecker alternate) {
      return accept(node, super.reduceConditionalExpression(node, test, consequent, alternate));
    }

    @Nonnull
    @Override
    public RangeChecker reduceContinueStatement(@Nonnull ContinueStatement node) {
      return accept(node, super.reduceContinueStatement(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceDataProperty(@Nonnull DataProperty node, @Nonnull RangeChecker name, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceDataProperty(node, name, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceDebuggerStatement(@Nonnull DebuggerStatement node) {
      return accept(node, super.reduceDebuggerStatement(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceDirective(@Nonnull Directive node) {
      return accept(node, super.reduceDirective(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceDoWhileStatement(@Nonnull DoWhileStatement node, @Nonnull RangeChecker body, @Nonnull RangeChecker test) {
      return accept(node, super.reduceDoWhileStatement(node, body, test));
    }

    @Nonnull
    @Override
    public RangeChecker reduceEmptyStatement(@Nonnull EmptyStatement node) {
      return accept(node, super.reduceEmptyStatement(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExport(@Nonnull Export node, @Nonnull RangeChecker declaration) {
      return accept(node, super.reduceExport(node, declaration));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportAllFrom(@Nonnull ExportAllFrom node) {
      return accept(node, super.reduceExportAllFrom(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportDefault(@Nonnull ExportDefault node, @Nonnull RangeChecker body) {
      return accept(node, super.reduceExportDefault(node, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportFrom(@Nonnull ExportFrom node, @Nonnull ImmutableList<RangeChecker> namedExports) {
      return accept(node, super.reduceExportFrom(node, namedExports));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportFromSpecifier(@Nonnull ExportFromSpecifier node) {
      return accept(node, super.reduceExportFromSpecifier(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportLocalSpecifier(@Nonnull ExportLocalSpecifier node, @Nonnull RangeChecker name) {
      return accept(node, super.reduceExportLocalSpecifier(node, name));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExportLocals(@Nonnull ExportLocals node, @Nonnull ImmutableList<RangeChecker> namedExports) {
      return accept(node, super.reduceExportLocals(node, namedExports));
    }

    @Nonnull
    @Override
    public RangeChecker reduceExpressionStatement(@Nonnull ExpressionStatement node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceExpressionStatement(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceForAwaitStatement(@Nonnull ForAwaitStatement node, @Nonnull RangeChecker left, @Nonnull RangeChecker right, @Nonnull RangeChecker body) {
      return accept(node, super.reduceForAwaitStatement(node, left, right, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceForInStatement(@Nonnull ForInStatement node, @Nonnull RangeChecker left, @Nonnull RangeChecker right, @Nonnull RangeChecker body) {
      return accept(node, super.reduceForInStatement(node, left, right, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceForOfStatement(@Nonnull ForOfStatement node, @Nonnull RangeChecker left, @Nonnull RangeChecker right, @Nonnull RangeChecker body) {
      return accept(node, super.reduceForOfStatement(node, left, right, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceForStatement(@Nonnull ForStatement node, @Nonnull Maybe<RangeChecker> init, @Nonnull Maybe<RangeChecker> test, @Nonnull Maybe<RangeChecker> update, @Nonnull RangeChecker body) {
      return accept(node, super.reduceForStatement(node, init, test, update, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceFormalParameters(@Nonnull FormalParameters node, @Nonnull ImmutableList<RangeChecker> items, @Nonnull Maybe<RangeChecker> rest) {
      return accept(node, super.reduceFormalParameters(node, items, rest));
    }

    @Nonnull
    @Override
    public RangeChecker reduceFunctionBody(@Nonnull FunctionBody node, @Nonnull ImmutableList<RangeChecker> directives, @Nonnull ImmutableList<RangeChecker> statements) {
      return accept(node, super.reduceFunctionBody(node, directives, statements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceFunctionDeclaration(@Nonnull FunctionDeclaration node, @Nonnull RangeChecker name, @Nonnull RangeChecker params, @Nonnull RangeChecker body) {
      return accept(node, super.reduceFunctionDeclaration(node, name, params, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceFunctionExpression(@Nonnull FunctionExpression node, @Nonnull Maybe<RangeChecker> name, @Nonnull RangeChecker params, @Nonnull RangeChecker body) {
      return accept(node, super.reduceFunctionExpression(node, name, params, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceGetter(@Nonnull Getter node, @Nonnull RangeChecker name, @Nonnull RangeChecker body) {
      return accept(node, super.reduceGetter(node, name, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceIdentifierExpression(@Nonnull IdentifierExpression node) {
      return accept(node, super.reduceIdentifierExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceIfStatement(@Nonnull IfStatement node, @Nonnull RangeChecker test, @Nonnull RangeChecker consequent, @Nonnull Maybe<RangeChecker> alternate) {
      return accept(node, super.reduceIfStatement(node, test, consequent, alternate));
    }

    @Nonnull
    @Override
    public RangeChecker reduceImport(@Nonnull Import node, @Nonnull Maybe<RangeChecker> defaultBinding, @Nonnull ImmutableList<RangeChecker> namedImports) {
      return accept(node, super.reduceImport(node, defaultBinding, namedImports));
    }

    @Nonnull
    @Override
    public RangeChecker reduceImportNamespace(@Nonnull ImportNamespace node, @Nonnull Maybe<RangeChecker> defaultBinding, @Nonnull RangeChecker namespaceBinding) {
      return accept(node, super.reduceImportNamespace(node, defaultBinding, namespaceBinding));
    }

    @Nonnull
    @Override
    public RangeChecker reduceImportSpecifier(@Nonnull ImportSpecifier node, @Nonnull RangeChecker binding) {
      return accept(node, super.reduceImportSpecifier(node, binding));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLabeledStatement(@Nonnull LabeledStatement node, @Nonnull RangeChecker body) {
      return accept(node, super.reduceLabeledStatement(node, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralBooleanExpression(@Nonnull LiteralBooleanExpression node) {
      return accept(node, super.reduceLiteralBooleanExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralInfinityExpression(@Nonnull LiteralInfinityExpression node) {
      return accept(node, super.reduceLiteralInfinityExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralNullExpression(@Nonnull LiteralNullExpression node) {
      return accept(node, super.reduceLiteralNullExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralNumericExpression(@Nonnull LiteralNumericExpression node) {
      return accept(node, super.reduceLiteralNumericExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralRegExpExpression(@Nonnull LiteralRegExpExpression node) {
      return accept(node, super.reduceLiteralRegExpExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceLiteralStringExpression(@Nonnull LiteralStringExpression node) {
      return accept(node, super.reduceLiteralStringExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceMethod(@Nonnull Method node, @Nonnull RangeChecker name, @Nonnull RangeChecker params, @Nonnull RangeChecker body) {
      return accept(node, super.reduceMethod(node, name, params, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceModule(@Nonnull Module node, @Nonnull ImmutableList<RangeChecker> directives, @Nonnull ImmutableList<RangeChecker> items) {
      return accept(node, super.reduceModule(node, directives, items));
    }

    @Nonnull
    @Override
    public RangeChecker reduceNewExpression(@Nonnull NewExpression node, @Nonnull RangeChecker callee, @Nonnull ImmutableList<RangeChecker> arguments) {
      return accept(node, super.reduceNewExpression(node, callee, arguments));
    }

    @Nonnull
    @Override
    public RangeChecker reduceNewTargetExpression(@Nonnull NewTargetExpression node) {
      return accept(node, super.reduceNewTargetExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceObjectAssignmentTarget(@Nonnull ObjectAssignmentTarget node, @Nonnull ImmutableList<RangeChecker> properties, @Nonnull Maybe<RangeChecker> rest) {
      return accept(node, super.reduceObjectAssignmentTarget(node, properties, rest));
    }

    @Nonnull
    @Override
    public RangeChecker reduceObjectBinding(@Nonnull ObjectBinding node, @Nonnull ImmutableList<RangeChecker> properties, @Nonnull Maybe<RangeChecker> rest) {
      return accept(node, super.reduceObjectBinding(node, properties, rest));
    }

    @Nonnull
    @Override
    public RangeChecker reduceObjectExpression(@Nonnull ObjectExpression node, @Nonnull ImmutableList<RangeChecker> properties) {
      return accept(node, super.reduceObjectExpression(node, properties));
    }

    @Nonnull
    @Override
    public RangeChecker reduceReturnStatement(@Nonnull ReturnStatement node, @Nonnull Maybe<RangeChecker> expression) {
      return accept(node, super.reduceReturnStatement(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceScript(@Nonnull Script node, @Nonnull ImmutableList<RangeChecker> directives, @Nonnull ImmutableList<RangeChecker> statements) {
      return accept(node, super.reduceScript(node, directives, statements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSetter(@Nonnull Setter node, @Nonnull RangeChecker name, @Nonnull RangeChecker param, @Nonnull RangeChecker body) {
      return accept(node, super.reduceSetter(node, name, param, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceShorthandProperty(@Nonnull ShorthandProperty node, @Nonnull RangeChecker name) {
      return accept(node, super.reduceShorthandProperty(node, name));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSpreadElement(@Nonnull SpreadElement node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceSpreadElement(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSpreadProperty(@Nonnull SpreadProperty node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceSpreadProperty(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceStaticMemberAssignmentTarget(@Nonnull StaticMemberAssignmentTarget node, @Nonnull RangeChecker object) {
      return accept(node, super.reduceStaticMemberAssignmentTarget(node, object));
    }

    @Nonnull
    @Override
    public RangeChecker reduceStaticMemberExpression(@Nonnull StaticMemberExpression node, @Nonnull RangeChecker object) {
      return accept(node, super.reduceStaticMemberExpression(node, object));
    }

    @Nonnull
    @Override
    public RangeChecker reduceStaticPropertyName(@Nonnull StaticPropertyName node) {
      return accept(node, super.reduceStaticPropertyName(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSuper(@Nonnull Super node) {
      return accept(node, super.reduceSuper(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSwitchCase(@Nonnull SwitchCase node, @Nonnull RangeChecker test, @Nonnull ImmutableList<RangeChecker> consequent) {
      return accept(node, super.reduceSwitchCase(node, test, consequent));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSwitchDefault(@Nonnull SwitchDefault node, @Nonnull ImmutableList<RangeChecker> consequent) {
      return accept(node, super.reduceSwitchDefault(node, consequent));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSwitchStatement(@Nonnull SwitchStatement node, @Nonnull RangeChecker discriminant, @Nonnull ImmutableList<RangeChecker> cases) {
      return accept(node, super.reduceSwitchStatement(node, discriminant, cases));
    }

    @Nonnull
    @Override
    public RangeChecker reduceSwitchStatementWithDefault(@Nonnull SwitchStatementWithDefault node, @Nonnull RangeChecker discriminant, @Nonnull ImmutableList<RangeChecker> preDefaultCases, @Nonnull RangeChecker defaultCase, @Nonnull ImmutableList<RangeChecker> postDefaultCases) {
      return accept(node, super.reduceSwitchStatementWithDefault(node, discriminant, preDefaultCases, defaultCase, postDefaultCases));
    }

    @Nonnull
    @Override
    public RangeChecker reduceTemplateElement(@Nonnull TemplateElement node) {
      return accept(node, super.reduceTemplateElement(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceTemplateExpression(@Nonnull TemplateExpression node, @Nonnull Maybe<RangeChecker> tag, @Nonnull ImmutableList<RangeChecker> elements) {
      return accept(node, super.reduceTemplateExpression(node, tag, elements));
    }

    @Nonnull
    @Override
    public RangeChecker reduceThisExpression(@Nonnull ThisExpression node) {
      return accept(node, super.reduceThisExpression(node));
    }

    @Nonnull
    @Override
    public RangeChecker reduceThrowStatement(@Nonnull ThrowStatement node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceThrowStatement(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceTryCatchStatement(@Nonnull TryCatchStatement node, @Nonnull RangeChecker body, @Nonnull RangeChecker catchClause) {
      return accept(node, super.reduceTryCatchStatement(node, body, catchClause));
    }

    @Nonnull
    @Override
    public RangeChecker reduceTryFinallyStatement(@Nonnull TryFinallyStatement node, @Nonnull RangeChecker body, @Nonnull Maybe<RangeChecker> catchClause, @Nonnull RangeChecker finalizer) {
      return accept(node, super.reduceTryFinallyStatement(node, body, catchClause, finalizer));
    }

    @Nonnull
    @Override
    public RangeChecker reduceUnaryExpression(@Nonnull UnaryExpression node, @Nonnull RangeChecker operand) {
      return accept(node, super.reduceUnaryExpression(node, operand));
    }

    @Nonnull
    @Override
    public RangeChecker reduceUpdateExpression(@Nonnull UpdateExpression node, @Nonnull RangeChecker operand) {
      return accept(node, super.reduceUpdateExpression(node, operand));
    }

    @Nonnull
    @Override
    public RangeChecker reduceVariableDeclaration(@Nonnull VariableDeclaration node, @Nonnull ImmutableList<RangeChecker> declarators) {
      return accept(node, super.reduceVariableDeclaration(node, declarators));
    }

    @Nonnull
    @Override
    public RangeChecker reduceVariableDeclarationStatement(@Nonnull VariableDeclarationStatement node, @Nonnull RangeChecker declaration) {
      return accept(node, super.reduceVariableDeclarationStatement(node, declaration));
    }

    @Nonnull
    @Override
    public RangeChecker reduceVariableDeclarator(@Nonnull VariableDeclarator node, @Nonnull RangeChecker binding, @Nonnull Maybe<RangeChecker> init) {
      return accept(node, super.reduceVariableDeclarator(node, binding, init));
    }

    @Nonnull
    @Override
    public RangeChecker reduceWhileStatement(@Nonnull WhileStatement node, @Nonnull RangeChecker test, @Nonnull RangeChecker body) {
      return accept(node, super.reduceWhileStatement(node, test, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceWithStatement(@Nonnull WithStatement node, @Nonnull RangeChecker object, @Nonnull RangeChecker body) {
      return accept(node, super.reduceWithStatement(node, object, body));
    }

    @Nonnull
    @Override
    public RangeChecker reduceYieldExpression(@Nonnull YieldExpression node, @Nonnull Maybe<RangeChecker> expression) {
      return accept(node, super.reduceYieldExpression(node, expression));
    }

    @Nonnull
    @Override
    public RangeChecker reduceYieldGeneratorExpression(@Nonnull YieldGeneratorExpression node, @Nonnull RangeChecker expression) {
      return accept(node, super.reduceYieldGeneratorExpression(node, expression));
    }
}

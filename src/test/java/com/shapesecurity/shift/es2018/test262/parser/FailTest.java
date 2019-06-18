package com.shapesecurity.shift.es2018.test262.parser;

import com.shapesecurity.shift.es2018.parser.JsError;
import com.shapesecurity.shift.es2018.parser.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class FailTest {
	static final String testsDir = "src/test/resources/test262-parser-tests/fail/";

	static final Set<String> xfail = new HashSet<>(Arrays.asList(
			// Invalid test
			// https://github.com/tc39/test262-parser-tests/issues/21
			"e3fbcf63d7e43ead.js",
			"" // empty line to make git diffs nicer
	));

	static void check(String name) throws IOException {
		String src = new String(Files.readAllBytes(Paths.get(testsDir, name)), StandardCharsets.UTF_8);

		try {
			if (name.endsWith(".module.js")) {
				Parser.parseModule(src);
			} else {
				Parser.parseScript(src);
			}
			throw new RuntimeException("Test parsed despite being marked as fail");
		} catch (JsError e) {
			// Good.
		}
	}

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		File[] files = (new File(testsDir)).listFiles();
		return Arrays.stream(files)
				.map(f -> new Object[]{ f.getName() })
				.collect(Collectors.toList());
	}

	@Parameterized.Parameter
	public String name;

	@Test
	public void test() throws Exception {
		XFailHelper.wrap(this.name, xfail, FailTest::check);
	}
}

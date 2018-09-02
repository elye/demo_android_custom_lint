package com.elyeproj.customlint

import com.android.tools.lint.checks.infrastructure.LintDetectorTest.java
import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class NamingPatternDetectorTest {

    @Test
    fun correctClassName() {
        lint()
                .files(java("""
        |package foo;
        |
        |class XmlHttpRequest {
        |}""".trimMargin()))
                .issues(ISSUE_NAMING_PATTERN)
                .run()
                .expectClean()
    }

    @Test
    fun incorrectClassName() {
        lint()
                .files(java("""
        |package foo;
        |
        |class XMLHTTPRequest {
        |}""".trimMargin()))
                .issues(ISSUE_NAMING_PATTERN)
                .run()
                .expect("""
        |src/foo/XMLHTTPRequest.java:3: Warning: Not named in defined camel case. [NamingPattern]
        |class XMLHTTPRequest {
        |      ~~~~~~~~~~~~~~
        |0 errors, 1 warnings""".trimMargin())
    }

    @Test
    fun incorrectClassNameKotlin() {
        lint()
                .files(kt("""
       |package foo;
       |
       |class XMLHTTPRequest""".trimMargin()))
                .issues(ISSUE_NAMING_PATTERN)
                .run()
                .expect("""
       |src/foo/XMLHTTPRequest.kt:3: Warning: Not named in defined camel case. [NamingPattern]
       |class XMLHTTPRequest
       |      ~~~~~~~~~~~~~~
       |0 errors, 1 warnings""".trimMargin())
    }
}

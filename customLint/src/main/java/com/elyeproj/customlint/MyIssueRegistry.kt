package com.elyeproj.customlint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import java.util.*

class MyIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(ISSUE_NAMING_PATTERN)

    override val api: Int = com.android.tools.lint.detector.api.CURRENT_API
}

val ISSUE_NAMING_PATTERN = Issue.create("NamingPattern",
        "Names should be well named.",
        "Some long description about this issue",
        CORRECTNESS,
        5,
        Severity.WARNING,
        Implementation(NamingPatternDetector::class.java,
                EnumSet.of(Scope.JAVA_FILE, Scope.TEST_SOURCES))
)

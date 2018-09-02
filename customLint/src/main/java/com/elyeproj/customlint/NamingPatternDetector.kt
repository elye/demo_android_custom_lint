package com.elyeproj.customlint

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UClass

class NamingPatternDetector : Detector(), Detector.UastScanner {
    override fun getApplicableUastTypes() = listOf(UClass::class.java)
    override fun createUastHandler(context: JavaContext) =
            NamingPatternHandler(context)

    class NamingPatternHandler(private val context: JavaContext) :
            UElementHandler() {
        override fun visitClass(node: UClass) {
            if (node.name?.isDefinedCamelCase() == false) {
                context.report(ISSUE_NAMING_PATTERN, node,
                        context.getNameLocation(node),
                        "Not named in defined camel case.")
            }
        }
    }
}

private fun String.isDefinedCamelCase(): Boolean {
    val charArray = toCharArray()
    return charArray
            .mapIndexed { index, current ->
                current to charArray.getOrNull(index + 1)
            }
            .none {
                it.first.isUpperCase() && it.second?.isUpperCase() ?: false
            }
}

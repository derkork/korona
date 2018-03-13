package com.ancientlightstudios.korona

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class KoronaTest(baseUrl:String) {
    val browser = Browser(baseUrl)

    fun <T : Page> visit(page: T, receiver: T.() -> Unit) = browser.visit(page, receiver)
    fun <T : Page> at(page: T, receiver: T.() -> Unit) = browser.at(page, receiver)

    @AfterAll
    private fun shutdownBrowser() {
        browser.shutdown()
    }
}
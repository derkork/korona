package com.ancientlightstudios.korona

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.Spec

abstract class KoronaSpek(private val baseUrl: String, spec: Spec.() -> Unit) : Spek({
    browser = Browser(baseUrl)

    spec()

    afterGroup {
        browser.shutdown()
        Browsers.remove(this)
    }

})

object Browsers {
    private val browsers = HashMap<Spec, Browser>()

    fun get(spec: Spec) = browsers[spec]
    fun put(spec: Spec, browser: Browser) {
        browsers[spec] = browser
    }

    fun remove(spec: Spec) {
        browsers.remove(spec)
    }

}

var Spec.browser: Browser
    get() {
        return Browsers.get(this) ?: throw IllegalStateException("Set up a browser first.")
    }
    set(value) {
        Browsers.put(this, value)
    }


fun <T : Page> Spec.visit(page: T, receiver: T.() -> Unit) = browser.visit(page, receiver)
fun <T : Page> Spec.at(page: T, receiver: T.() -> Unit) = browser.at(page, receiver)

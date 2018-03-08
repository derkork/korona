package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorProvider

class Link(navigatorProvider: NavigatorProvider) : Component(navigatorProvider) {
    fun click() {
        navigator.element.click()
    }

    val href:String? get() = navigator.element.getAttribute("href")
}
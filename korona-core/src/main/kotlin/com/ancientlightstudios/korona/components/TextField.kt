package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorProvider

class TextField(navigatorProvider: NavigatorProvider) : FormComponent(navigatorProvider) {

    var value: String
        get() = navigator.element.getAttribute("value")
        set(value) {
            val input = navigator.element
            input.clear()
            input.sendKeys(value)
        }
}



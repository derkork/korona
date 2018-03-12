package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorProvider

class Button(navigatorProvider: NavigatorProvider) : FormComponent(navigatorProvider) {

    fun click() {
        navigator.element.click()
    }
}


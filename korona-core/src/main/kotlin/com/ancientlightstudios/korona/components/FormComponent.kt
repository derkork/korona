package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorProvider

abstract class FormComponent(navigatorProvider: NavigatorProvider) : Component(navigatorProvider) {

    val enabled get() = navigator.element.isEnabled
    val selected get() = navigator.element.isSelected

}
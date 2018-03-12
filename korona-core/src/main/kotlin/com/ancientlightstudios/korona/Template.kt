package com.ancientlightstudios.korona

import com.ancientlightstudios.korona.components.Component

fun <T : Component> NavigatorBased.component(cssSelector: String, initializer: (NavigatorProvider) -> T): Lazy<T> = lazy {
    initializer({ navigator.find(cssSelector) })
}

fun <T : Component> NavigatorBased.components(cssSelector: String, initializer: (NavigatorProvider) -> T): Lazy<List<T>> = lazy {
    navigator.find(cssSelector).elements.map { initializer({ Navigator.from(it) }) }
}
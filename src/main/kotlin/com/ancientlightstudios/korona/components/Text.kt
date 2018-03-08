package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorProvider

class Text<T>(navigatorProvider: NavigatorProvider, private val converter: Text<T>.() -> T) : Component(navigatorProvider) {
    val value: T
        get() = converter()

}

fun <T> text(converter: (String) -> T): (NavigatorProvider) -> Text<T> = { provider: NavigatorProvider ->
    Text(provider, { converter(navigator.element.text) })
}

fun text() = text({ it })

fun <T> attribute(name: String, converter: (String) -> T): (NavigatorProvider) -> Text<T> = { provider: NavigatorProvider ->
    Text(provider, { converter(navigator.element.getAttribute(name)) })
}

fun attribute(name: String) = attribute(name, { it })

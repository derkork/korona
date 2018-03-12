package com.ancientlightstudios.korona.components

import com.ancientlightstudios.korona.NavigatorBased
import com.ancientlightstudios.korona.NavigatorProvider

abstract class Component(private val navigatorProvider: NavigatorProvider) : NavigatorBased() {
    override val navigator by lazy {
      navigatorProvider()
    }

}
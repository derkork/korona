package com.ancientlightstudios.korona.pages.automationpractice.components

import com.ancientlightstudios.korona.NavigatorProvider
import com.ancientlightstudios.korona.component
import com.ancientlightstudios.korona.components.Component
import com.ancientlightstudios.korona.components.Link
import com.ancientlightstudios.korona.components.text

class ProductContainer(navigatorProvider: NavigatorProvider) : Component(navigatorProvider) {

    val productName by component("a.product-name", text())
    val productPrice by component("span.price.product-price", text())
    val detailLink by component("a.product-name", ::Link)

}
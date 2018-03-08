package com.ancientlightstudios.korona.pages.automationpractice.pages

import com.ancientlightstudios.korona.component
import com.ancientlightstudios.korona.components.text

class ProductPage : ShopPage("index.php?controller=product", "product") {
    val productName by component("h1[itemprop='name']", text())
}
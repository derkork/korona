package com.ancientlightstudios.korona.pages.automationpractice.pages

import com.ancientlightstudios.korona.components
import com.ancientlightstudios.korona.pages.automationpractice.components.ProductContainer

class SearchResultPage : ShopPage("index.php?controller=search", "search") {
    val products by components("div.product-container", ::ProductContainer)
}
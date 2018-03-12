package com.ancientlightstudios.korona.pages.automationpractice.pages

import com.ancientlightstudios.korona.Page
import com.ancientlightstudios.korona.component
import com.ancientlightstudios.korona.components.Button
import com.ancientlightstudios.korona.components.TextField
import com.ancientlightstudios.korona.components.attribute

abstract class ShopPage(location: String, private val expectedId:String) : Page(location) {

    private val pageId by component("body", attribute("id"))
    override fun verify(): Boolean = pageId.value == expectedId

    val searchField by component("#search_query_top", ::TextField)
    val searchButton by component("button.button-search", ::Button)

}
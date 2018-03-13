package com.ancientlightstudios.korona.junit5

import com.ancientlightstudios.korona.KoronaTest
import com.ancientlightstudios.korona.pages.automationpractice.pages.HomePage
import com.ancientlightstudios.korona.pages.automationpractice.pages.SearchResultPage
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SearchTest : KoronaTest("http://automationpractice.com") {

    @Test
    fun narf() {
        visit(HomePage()) {
            searchField.value = "dress"
            searchButton.click()
        }

        at(SearchResultPage()) {
            assertEquals(7, products.size)
            println(products.map { it.productName.value })
            println(products.map { it.productPrice.value })
        }
    }

}
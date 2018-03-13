package com.ancientlightstudios.korona.spek

import com.ancientlightstudios.korona.KoronaSpek
import com.ancientlightstudios.korona.at
import com.ancientlightstudios.korona.pages.automationpractice.pages.HomePage
import com.ancientlightstudios.korona.pages.automationpractice.pages.ProductPage
import com.ancientlightstudios.korona.pages.automationpractice.pages.SearchResultPage
import com.ancientlightstudios.korona.visit
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object MySpek : KoronaSpek("http://automationpractice.com", {
    describe("a product search") {
        on("visiting the home page and searching for dresses") {
            visit(HomePage()) {
                searchField.value = "dress"
                searchButton.click()
            }

            it("it shows 7 search results") {
                at(SearchResultPage()) {
                    assertEquals(7, products.size)
                    println(products.map { it.productName.value })
                    println(products.map { it.productPrice.value })
                }
            }
        }

        on("clicking on a detail link") {
            at(SearchResultPage()) {
                products[0].detailLink.click()
            }

            it("shows the detail page of the product") {
                at(ProductPage()) {
                    assertEquals("Printed Summer Dress", productName.value)
                }
            }
        }
    }
})
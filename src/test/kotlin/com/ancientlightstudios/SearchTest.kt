package com.ancientlightstudios

import com.ancientlightstudios.korona.Browser
import com.ancientlightstudios.korona.pages.automationpractice.pages.HomePage
import com.ancientlightstudios.korona.pages.automationpractice.pages.ProductPage
import com.ancientlightstudios.korona.pages.automationpractice.pages.SearchResultPage
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object MySpek : Spek({
    describe("a product search") {
        val browser = Browser("http://automationpractice.com")


        on("visiting the home page and searching for dresses") {
            browser.visit(HomePage()) {
                searchField.value = "dress"
                searchButton.click()
            }

            it("it shows 7 search results") {
                browser.at(SearchResultPage()) {
                    assertEquals(7, products.size)
                    println(products.map { it.productName.value })
                    println(products.map { it.productPrice.value })
                }
            }
        }

        on("clicking on a detail link") {
            browser.at(SearchResultPage()) {
                products[0].detailLink.click()
            }

            it("shows the detail page of the product") {
                browser.at(ProductPage()) {
                    assertEquals("Printed Summer Dress", productName.value)
                }
            }
        }

        afterGroup {
            browser.shutdown()
        }

    }
})
package com.ancientlightstudios.korona

import org.openqa.selenium.By
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

typealias NavigatorProvider = () -> Navigator

class Navigator private constructor(private val getSearchContexts: () -> List<SearchContext>) {
    companion object {
        fun from(context: SearchContext) = Navigator {
            listOf(context)
        }
    }

    val present by lazy {
        elements.size == 1
    }

    val element: WebElement by lazy {
        val available = elements
        when {
            available.isNotEmpty() -> elements[0]
            else -> throw ElementNotPresentException()
        }
    }

    val elements: List<WebElement> by lazy {
        getSearchContexts().filter { it is WebElement }.map { it as WebElement }
    }

    fun find(cssSelector: String) = Navigator {
        getSearchContexts().flatMap {
            it.findElements(By.cssSelector(cssSelector))
        }
    }
}


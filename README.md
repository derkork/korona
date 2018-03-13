# Korona

_Note: Korona is a work in progress. This documentation may contain features that are not actually implemented, as
  Korona is using Readme driven design. For now it is not recommended to use Korona in a productive environment._

Korona is a browser automation solution. It is heavily inspired by the great Geb framework. Main highlights are:

* Type safe - Korona is written in Kotlin and therefore statically typed.
* IDE friendly - Korona does not use magic that is opaque to IDEs (e.g reliance on missing method/properties callbacks)
   and that would prevent things like usage search or auto-completion from working. Korona is 100% Kotlin and if your 
   IDE speaks Kotlin you will get great support for Korona as well. 
* Batteries included - Korona takes an opinionated view on browser automation and includes components for many standard
  use cases.   
* Testing framework agnostic - You can use Korona with any testing framework of your choice. Out of the box Korona 
  provides integrations for these testing frameworks:
  * Spek
  * JUnit 5   

  If your framework of choice is not amongst them, you can still use Korona, it's just a little less convenient.

## Usage
### Components

The core of Korona are components. A component describes a part of the website that you want to test. It can be something
simple like a button or a string of text, something more complex like a type-ahead field or even the whole page itself.
Korona comes with several built-in components like:

 * `Page` - a web page
 * `Button` - a button (e.g. form button)
 * `Link` - a link
 * `Text` - a string of text
 * `TextField` - a form text field
   
Components may contain other components, e.g. a search result component may contain components referring to details
of a search result:

```html
<!-- This is the HTML we want to create a component for --> 
<div class="product-container">
  <a href="/products/ha29127" class="product-name">Some Product</a>
  <span class="price product-price">25.00</span>
</div>
```

You can represent this as a component in Korona:

```kotlin
// We call this component ProductContainer and it is derived from Component.
class ProductContainer(navigatorProvider: NavigatorProvider) : Component(navigatorProvider) {

	// We create member components for each of the interesting pieces.
	// The "by component" delegate simplifies component creation and lifecycle management.

    val productName by component("a.product-name", text())
    val productPrice by component("span.price.product-price", text())
    val detailLink by component("a.product-name", ::Link)
}
```

### Pages

A `Page` represent a web page as you see it in the browser. You can think of it as the root component and it is itself
a Korona `Component`. 


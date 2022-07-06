package com.mrp.automation.definition

import com.mrp.automation.AndroidAppiumTestExecutor
import com.mrp.automation.page.component.{ProductComponent, ResultsGridComponent, SortAndFilterComponent}
import com.mrp.automation.page.data.model.ProductData
import com.mrp.automation.page._
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import io.cucumber.scala.{EN, ScalaDsl}
import org.testng.Assert.assertEquals

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

class StepDefinitions extends ScalaDsl with EN {
  implicit val  driver: AndroidDriver[AndroidElement] = AndroidAppiumTestExecutor().getDriver()
  var itemSelected: List[ProductData] = List()
val sortAndFilterComponent= new SortAndFilterComponent()
  When("""User Navigate to Shop""") { () =>
    HomePage().navigateToSHop()
  }
  Then("""User Navigate to Ladies""") { () =>
    // Write code here that turns the phrase above into concrete actions
    ShopPage().navigateToLadies()
  }
  Then("""User Navigate to Shop clothing""") { () =>
    LadiesPage().navigateToShopClothing()
  }

  Then("""User Navigate to shopping category {string}""") { (category: String) =>
    ShopClothing().navigateToClothesCategory(category)

  }
  Then("""Select product item by name {string}""") { (title: String) =>
    // Write code here that turns the phrase above into concrete actions
   itemSelected++List( DressesAndTunics().getProductByTitleData(title))
    DressesAndTunics().selectProductByTitle(title)
  }
  Then("""Sort by {string}""") { (sortBy: String) =>
  sortAndFilterComponent.sortProductsBy(sortBy)
  }
  Then("""The products are sorted By Price {string}""") { (sortBy: String) =>
   if(sortBy=="Price: Low to High"){
     val actual=ResultsGridComponent().products.toList.map(product=>new ProductComponent(product).getData())
     val expected=actual.sortBy(_.price.drop(1).toDouble)
     assertEquals(actual,expected,"The products are not sorted by "+sortBy)


   }
  }
}
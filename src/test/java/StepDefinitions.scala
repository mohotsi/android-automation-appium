import com.mrp.automation.AndroidAppiumTestExecutor
import com.mrp.automation.page.{HomePage, LadiesPage, ShopClothing, ShopPage}
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import io.cucumber.scala.{EN, PendingException, ScalaDsl}

class StepDefinitions extends ScalaDsl with EN {
  implicit val  driver: AndroidDriver[AndroidElement] = AndroidAppiumTestExecutor().getDriver()
  Given("""User does something""") { () =>

    HomePage().navigateToSHop()
    ShopPage().navigateToLadies()
    LadiesPage().navigateToShopClothing()
    ShopClothing().navigateToClothesCategory("Dresses / Tunics")
  }
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
}
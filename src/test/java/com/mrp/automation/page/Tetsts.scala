package com.mrp.automation.page

import com.mrp.automation.AndroidAppiumTestExecutor
import io.appium.java_client.MobileElement
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.testng.annotations.Test

class Tetsts {
  @Test
  def one: Unit ={

   implicit val  driver: AndroidDriver[AndroidElement] = AndroidAppiumTestExecutor().getDriver()
    HomePage().navigateToSHop()
    ShopPage().navigateToLadies()
    LadiesPage().navigateToShopClothing()
    ShopClothing().navigateToClothesCategory("Dresses / Tunics")

  }


}

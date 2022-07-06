package com.mrp.automation.page

import com.mrp.automation.webElement.WebElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`

case class ShopClothing()(implicit driver:AndroidDriver[AndroidElement]) {

  def clothesCategory:AndroidElement=driver.findElementById("za.com.mrp:id/category_list_recycler")

  def navigateToClothesCategory(category:String) ={
     clothesCategory.findElementsByClassName("android.widget.TextView").toList
     .filter(_.getAttribute("text")==category).head.asInstanceOf[AndroidElement].clickRetry()

  }
  //*[@id='za.com.mrp:id/category_list_recycler']/

}

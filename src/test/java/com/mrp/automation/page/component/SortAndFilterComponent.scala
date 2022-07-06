package com.mrp.automation.page.component

import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.util.Try

class SortAndFilterComponent(implicit driver:AndroidDriver[AndroidElement]) {

  def products=driver.findElementsById("za.com.mrp:id/product_container")
  def searchbar_right_icon()=driver.findElementById(" //id=za.com.mrp:id/searchbar_right_icon")
   def sortby=driver.findElementsById("za.com.mrp:id/radio_recycler")
  def showButton=driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'SHOW')]")

 def sortProductsBy(label:String)={
   Try(    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Slip Dress" + "\").instance(0))"))

   searchbar_right_icon.clickRetry()
   sortby.toList.filter(_.findElementById("za.com.mrp:id/box_text").getAttribute("text")==label)
     .foreach(_.findElementByClassName("android.widget.ImageView").asInstanceOf[AndroidElement].clickRetry())
   showButton.clickRetry()
 }


  //
  //class=android.widget.ImageView
  //za.com.mrp:id/box_text

  // (Recommended,What's New,Price: Low to High,Price: High to Low,Name

  //*[resource-id="za.com.mrp:id/filter_header"]  ,text=PRICES,class=android.widget.ImageView,resource-id=za.com.mrp:id/rangeSeekBar


  //category [za.com.mrp:id/box_square,za.com.mrp:id/box_text]


  //colour
  //class=android.widget.LinearLayout[resource-id=za.com.mrp:id/product_swatch_item_image_container,resource-id=za.com.mrp:id/product_swatch_colour_name]

  //Length [za.com.mrp:id/box_square,za.com.mrp:id/box_text] (Maxi (10))

  // Size [id=za.com.mrp:id/swatch_size_text] (32)
}

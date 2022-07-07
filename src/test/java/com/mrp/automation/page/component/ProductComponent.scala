package com.mrp.automation.page.component

import com.mrp.automation.page.data.model.ProductData
import com.mrp.automation.webElement.AndroidElementImplicit.Cuddle
import io.appium.java_client.android.{AndroidDriver, AndroidElement}

import java.awt.image.BufferedImage

  class ProductComponent(androidElement: =>AndroidElement)(implicit driver:AndroidDriver[AndroidElement]) {


  def getProductTitle() = {
   def title = androidElement.findElementById("za.com.mrp:id/product_card_item_title").asInstanceOf[AndroidElement]
   title
  }
  def getBrand()={
   def brand = androidElement.findElementById("za.com.mrp:id/product_card_item_brand").asInstanceOf[AndroidElement]
   brand

  }
  def getPrice()={
   def price = androidElement.findElementById("za.com.mrp:id/product_card_item_price").asInstanceOf[AndroidElement]
   price

  }

  def getImage() = {
   def img = androidElement.findElementById("za.com.mrp:id/product_card_item_image").asInstanceOf[AndroidElement]

   img

  }

  def getData(): ProductData ={
   ProductData(
    getProductTitle().getAttribute("text"),
    getBrand().getAttribute("text"),
    getPrice().getAttribute("text"),
    getImage().getScreenShot())
  }





}

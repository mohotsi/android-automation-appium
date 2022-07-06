package com.mrp.automation.page

import com.mrp.automation.AndroidAppiumTestExecutor
import io.appium.java_client.MobileElement
import io.appium.java_client.android.{AndroidDriver, AndroidElement}
import org.testng.annotations.Test

import java.util.concurrent.TimeUnit

class CommonPage(implicit driver:AndroidDriver[AndroidElement]=AndroidAppiumTestExecutor().getDriver()) {


  def laboour(): Unit = {
    val el1 = driver.findElementByAccessibilityId("SHOP").asInstanceOf[AndroidElement]
    el1.click()
    driver.manage.timeouts.implicitlyWait(10, TimeUnit.SECONDS)
    val el2 = driver.findElementByXPath("//android.view.View[@content-desc=\"Ladies\"]/android.view.View").asInstanceOf[AndroidElement]
    el2.click()
    driver.manage.timeouts.implicitlyWait(10, TimeUnit.SECONDS)
    val el3 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView").asInstanceOf[AndroidElement]
    el3.click()
    driver.manage.timeouts.implicitlyWait(10, TimeUnit.SECONDS)
    val el4 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView").asInstanceOf[AndroidElement]
    el4.click()
  }



}

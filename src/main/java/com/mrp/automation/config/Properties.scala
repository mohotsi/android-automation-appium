package com.mrp.automation.config

import java.io.FileInputStream
import java.util.Properties

object Properties {
  val property = new Properties()
 private val input = new FileInputStream("./src/main/resources/application.properties");
 property.load(input)


}

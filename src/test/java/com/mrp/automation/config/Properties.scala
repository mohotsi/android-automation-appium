package com.mrp.automation.config

import com.mrp.automation.config.Properties.property

import java.io.FileInputStream
import java.util.Properties

object Properties {
  val property = new Properties()
 private val input = new FileInputStream("./src/main/resources/config.properties");
 property.load(input)


}

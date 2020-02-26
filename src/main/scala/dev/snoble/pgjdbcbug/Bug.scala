package dev.snoble.pgjdbcbug

import java.sql.DriverManager
import java.sql.Connection

object Bug {
  def main(args: Array[String]): Unit = {
    val url = "jdbc:postgresql:db"
    val conn = DriverManager.getConnection(url, "postgres", "")
  }
}

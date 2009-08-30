package com.shopping.snippet

import com.shopping._
import model._
import net.liftweb._

import util._

import scala.xml._

class CreateItem {

    def create(html : NodeSeq): NodeSeq = {
        val item = new Item()
        item.toForm(Full("save"), {_.save})
    }

}

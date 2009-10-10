package com.shopping.snippet

import com.shopping._
import model._
import net.liftweb._
import http._

import SHtml._
import S._
import mapper._
import util._
import Helpers._

import scala.xml.{NodeSeq, Text}

class EditItem {

    var id = S.param("id") openOr ""

    var item = try {
        Item.findByKey(id.toLong)
    } catch {
        case e:NumberFormatException => Empty
    }

    def edit (html: NodeSeq): NodeSeq ={
        item map ({ i =>
            i.toForm(Full("save"), "/item/list")
        }) openOr Text("Invalid Item")
    }

}

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

class DeleteItem {

    var id = S.param("id") openOr ""

    var item = try {
        Item.findByKey(id.toLong)
    } catch {
        case e:NumberFormatException => Empty
    }

    def delete (html: NodeSeq): NodeSeq ={

        item map ({ i =>
            def deleteItem() :Unit = {
                i.delete_!
                S.redirectTo("/item/list")
            }
            bind("item", html,
                 "name" -> i.name,
                 "amount" -> i.amount,
                 "submit" -> submit("Delete", deleteItem )
            )
        }) openOr Text("Invalid Item")
    }

}

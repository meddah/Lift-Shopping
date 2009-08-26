/*
 * ListItem.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.shopping.snippet

import com.shopping._
import model._
import net.liftweb._

import util._
import Helpers._
import http._

import scala.xml._

class ListItem {

    def list(html: NodeSeq) : NodeSeq = {
        toShow.flatMap(item =>
            bind("item", html,
                 "name" -> item.name,
                 "amount" -> item.amount,
                 FuncAttrBindParam("view_href", _ =>
                   Text("view/"+ (item.primaryKeyField)),"href"),
                 FuncAttrBindParam("edit_href", _ =>
                   Text("edit/"+ (item.primaryKeyField)),"href"),
                FuncAttrBindParam("delete_href", _ =>
                    Text("delete/"+ (item.primaryKeyField)),"href")
            )
        )
    }

    private def toShow =
        Item.findAll();

}

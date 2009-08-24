
package com.shopping.model

import net.liftweb._
import mapper._
import util._

class Item extends LongKeyedMapper[Item] with IdPK with CRUDify[Long, Item]{

    def getSingleton = Item

    object name extends MappedPoliteString(this, 128)
    object amount extends MappedInt(this)

    override def showAllMenuLoc = Empty
}

object Item extends Item with LongKeyedMetaMapper[Item]
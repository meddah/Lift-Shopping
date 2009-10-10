
package com.shopping.model

import net.liftweb._
import mapper._
import util._

class Item extends LongKeyedMapper[Item] with IdPK{

    def getSingleton = Item

    object name extends MappedPoliteString(this, 128)
    object amount extends MappedInt(this)

}

object Item extends Item with LongKeyedMetaMapper[Item] {

    override def fieldOrder = List(name, amount)
}
package com.example.newgroupelement.GroupModel

class GroupModel(var id: Int, var category_id: Int, var name: String, var image: ByteArray? = null ) {
    override fun toString(): String {
        return this.name
    }
}

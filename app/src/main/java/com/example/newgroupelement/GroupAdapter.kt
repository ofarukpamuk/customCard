package com.example.newgroupelement

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newgroupelement.GroupModel.GroupModel
import com.example.newgroupelement.databinding.GroupElementBinding

class GroupAdapter(private val groupList : ArrayList<GroupModel>) : RecyclerView.Adapter<GroupAdapter.GroupHolder>() {
    class GroupHolder(val binding: GroupElementBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupHolder {
        val binding = GroupElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupHolder(binding)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun onBindViewHolder(holder: GroupHolder, position: Int) {
        if (groupList[position].image == null) {
            holder.binding.images.visibility = View.GONE
            //holder.binding.textLinear.gravity = Gravity.CENTER
            //holder.binding.textLinear2.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,  R.color.dark_grey))
        } else {
            val byteArray = groupList[position].image
            val bitmap = byteArray?.let { getBitmapFromByteArray(it) }
            holder.binding.images.setImageBitmap(bitmap)
        }

    }
    private fun getBitmapFromByteArray(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }


}

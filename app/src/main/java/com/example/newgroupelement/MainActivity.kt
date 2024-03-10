package com.example.newgroupelement

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newgroupelement.GroupModel.GroupModel
import com.example.newgroupelement.databinding.ActivityMainBinding
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: GroupAdapter
    private lateinit var binding: ActivityMainBinding
    val groupList = ArrayList<GroupModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        grouplists()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val spanCount = 6 // Yeni span count değeri (yatayda kaç eleman gösterileceği)
        val layoutManager = GridLayoutManager(this, spanCount)
        binding.groupeRecycler.layoutManager = layoutManager
        adapter = GroupAdapter(groupList)
        binding.groupeRecycler.adapter = adapter
        setContentView(binding.root)

    }

    private fun grouplists() {
        groupList.add(GroupModel(2, 102, "Grup 2"  , getByteArrayFromImage(R.drawable.foto) ))
        groupList.add(GroupModel(3, 103, "Grup 3", getByteArrayFromImage(R.drawable.foto)))
        groupList.add(GroupModel(4, 104, "Grup 4", getByteArrayFromImage(R.drawable.foto)))
        groupList.add(GroupModel(5, 105, "Grup 5", getByteArrayFromImage(R.drawable.foto)))
        groupList.add(GroupModel(6, 106, "Grup 6", getByteArrayFromImage(R.drawable.foto)))
        groupList.add(GroupModel(7, 107, "Grup 7"))
    }
    private fun getByteArrayFromImage(resourceId: Int): ByteArray {
        val bitmap = BitmapFactory.decodeResource(resources, resourceId)

        if (bitmap != null) {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            return stream.toByteArray()
        } else {
            // Bitmap null ise boş bir byte dizisi döndür
            return ByteArray(0)
        }
    }




    // 7 elemanlı ArrayList oluşturma

}
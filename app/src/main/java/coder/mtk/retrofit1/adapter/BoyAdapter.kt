package coder.mtk.retrofit1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.retrofit1.PhotoView
import coder.mtk.retrofit1.R
import coder.mtk.retrofit1.model.BoyItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_profilelist.view.*
import kotlin.coroutines.coroutineContext

class BoyAdapter (var arrList: ArrayList<BoyItem>) : RecyclerView.Adapter<BoyAdapter.BoyViewHolder>() {
    class BoyViewHolder (itemView : View) : RecyclerView.ViewHolder  (itemView)  {
        fun bind(boyItem: BoyItem) {
            var img : String = boyItem.img_url
            if (img !== null){
                Glide.with(itemView).load(img).into(itemView.photo)
            }
            itemView.PersonName.text = boyItem.name
            itemView.idNum.text = boyItem.id
            itemView.classRoomNum.text = boyItem.`class`
            itemView.voteNum.text = boyItem.vote_count.toString()
            itemView.votetimeNum.text = boyItem.vote_time_status.toString()

//            itemView.photo.setOnClickListener {
//                var intent =  Intent(,PhotoView::class.java)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_profilelist,parent,false)
        return BoyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: BoyViewHolder, position: Int) {
        holder.bind(arrList[position])
    }
}
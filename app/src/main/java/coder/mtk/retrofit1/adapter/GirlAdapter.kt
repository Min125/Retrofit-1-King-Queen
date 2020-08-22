package coder.mtk.retrofit1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.retrofit1.R
import coder.mtk.retrofit1.model.BoyItem
import coder.mtk.retrofit1.model.GirlItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_profilelist.view.*

class GirlAdapter (var arrList1: ArrayList<GirlItem>) : RecyclerView.Adapter<GirlAdapter.GirlViewHolder>() {
    class GirlViewHolder (itemView : View) : RecyclerView.ViewHolder  (itemView)  {
        fun bind(girlItem: GirlItem) {
            var img  = girlItem.img_url
            if (img !== null){
                Glide.with(itemView).load(img).into(itemView.photo)
            }
            itemView.PersonName.text = girlItem.name
            itemView.idNum.text = girlItem.id
            itemView.classRoomNum.text = girlItem.`class`
            itemView.voteNum.text = girlItem.vote_count.toString()
            itemView.votetimeNum.text = girlItem.vote_time_status.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GirlViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_profilelist,parent,false)
        return GirlViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrList1.size
    }

    override fun onBindViewHolder(holder: GirlViewHolder, position: Int) {
        holder.bind(arrList1[position])
    }
}
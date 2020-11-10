package guz.roman.testtask.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import guz.roman.testtask.R
import guz.roman.testtask.model.data.RestorauntModel


class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>() {

    val news = mutableListOf<RestorauntModel>()

    class MyViewHolder(item: View): RecyclerView.ViewHolder(item){
        var title: TextView = item.findViewById(R.id.titleNameItem)
        var textItem: TextView = item.findViewById(R.id.textItem)
        var image: ImageView = item.findViewById(R.id.imageItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restoraunt_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentNews = news[position]
        holder.title.text = currentNews.name


        Glide.with(holder.itemView.context).load(currentNews.imageUrl).into(holder.image)
    }

    fun setData(setNews: List<RestorauntModel>){
        news.addAll(setNews)
        notifyDataSetChanged()
    }

}
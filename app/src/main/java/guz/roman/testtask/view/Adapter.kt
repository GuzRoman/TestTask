package guz.roman.testtask.view

import android.location.Location
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import guz.roman.testtask.R
import guz.roman.testtask.model.data.Businesse
import guz.roman.testtask.model.data.Coordinates


class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>() {
    var currentLocation = Location("")
    val restoraunts = mutableListOf<Businesse>()

    class MyViewHolder(item: View): RecyclerView.ViewHolder(item){
        var title: TextView = item.findViewById(R.id.titleNameItem)
        var textItem: TextView = item.findViewById(R.id.textItem)
        var image: ImageView = item.findViewById(R.id.imageItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restoraunt_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = restoraunts.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curentRestoran = restoraunts[position]
        holder.title.text = curentRestoran.name
        holder.textItem.text = distance(curentRestoran.coordinates) + " км"

        Glide.with(holder.itemView.context).load(curentRestoran.imageUrl).into(holder.image)
    }

    private fun distance(coordinates: Coordinates): String{
        val loc = Location("")
        loc.latitude = coordinates.latitude
        loc.longitude = coordinates.longitude
        val distanseToRest = currentLocation.distanceTo(loc)/1000
        return distanseToRest.toString()
    }

    fun setData(setNews: List<Businesse>, location: Location){
        currentLocation = location
        restoraunts.addAll(setNews)
        notifyDataSetChanged()
    }

}
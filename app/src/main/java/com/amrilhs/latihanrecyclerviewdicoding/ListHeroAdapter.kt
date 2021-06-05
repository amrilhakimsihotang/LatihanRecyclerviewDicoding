package com.amrilhs.latihanrecyclerviewdicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ItemRowHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.listViewHolder>() {
    inner class listViewHolder(val itemRowHeroBinding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(itemRowHeroBinding.root) {
        fun bind(hero: Hero) {
            Glide.with(itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(300, 300))
                .error(R.drawable.ic_baseline_error_24)
                .into(itemRowHeroBinding.imgItem)
            itemRowHeroBinding.txtTitle.text = hero.name
            itemRowHeroBinding.txtDescription.text = hero.detail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return listViewHolder(binding)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        holder.bind(listHero[position])
        val dataHero = listHero[position]
        holder.itemView.setOnClickListener {
            val heroIntent = Hero(
                dataHero.name,
                dataHero.detail,
                dataHero.photo
            )
            val mIntent = Intent(it.context, DetailHero::class.java)
            mIntent.putExtra(DetailHero.DETAIL_HERO, heroIntent)
            it.context.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}
package com.amrilhs.latihanrecyclerviewdicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ItemGridHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapter.gridViewHolder>() {
    inner class gridViewHolder(val gridHeroBinding: ItemGridHeroBinding) :
        RecyclerView.ViewHolder(gridHeroBinding.root) {
        fun bind(hero: Hero) {
            Glide.with(itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(300, 300))
                .error(R.drawable.ic_baseline_error_24)
                .into(gridHeroBinding.imgGridView)
            gridHeroBinding.txtTitleGrid.text = hero.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gridViewHolder {
        val binding =
            ItemGridHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return gridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: gridViewHolder, position: Int) {
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
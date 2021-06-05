package com.amrilhs.latihanrecyclerviewdicoding

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ItemCardviewHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.cardViewHolder>() {
    inner class cardViewHolder(val cardviewHeroBinding: ItemCardviewHeroBinding) :
        RecyclerView.ViewHolder(cardviewHeroBinding.root) {
        fun bind(hero: Hero) {
            Glide.with(itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(300, 300))
                .error(R.drawable.ic_baseline_error_24)
                .into(cardviewHeroBinding.imgCardView)
            cardviewHeroBinding.txtTitleCard.text = hero.name
            cardviewHeroBinding.txtDescriptionCard.text = hero.detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        val binding =
            ItemCardviewHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return cardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
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
        holder.cardviewHeroBinding.buttonShare.setOnClickListener {
            val eBody: String = R.string.body.toString()
            val eSubject: String = R.string.subject.toString()
            val eAddress: String = R.string.email2.toString()
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:" + eAddress)
                putExtra(Intent.EXTRA_SUBJECT, eSubject)
                putExtra(Intent.EXTRA_TEXT, eBody)
            }
            it.context.startActivity(Intent.createChooser(emailIntent, R.string.title.toString()))
        }
    }


    override fun getItemCount(): Int {
        return listHero.size
    }
}
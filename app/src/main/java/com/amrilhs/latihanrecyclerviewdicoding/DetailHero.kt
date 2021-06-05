package com.amrilhs.latihanrecyclerviewdicoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ActivityDetailHeroBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailHero : AppCompatActivity() {

    companion object {
        const val DETAIL_HERO = "detail_hero"
    }

    private lateinit var detailHeroBinding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailHeroBinding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(detailHeroBinding.root)
        supportActionBar?.title = resources.getString(R.string.detailheader)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hero = intent.getParcelableExtra<Hero>(DETAIL_HERO) as Hero
        Glide.with(this)
            .load(hero.photo)
            .apply(RequestOptions().override(300, 300))
            .error(R.drawable.ic_baseline_error_24)
            .into(detailHeroBinding.imgItemDetail)
        detailHeroBinding.txtTitleItemDetail.text = hero.name
        detailHeroBinding.txtDescriptionItemDetail.text = hero.detail
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
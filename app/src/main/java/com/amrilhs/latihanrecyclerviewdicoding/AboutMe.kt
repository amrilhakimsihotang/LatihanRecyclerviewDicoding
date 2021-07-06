package com.amrilhs.latihanrecyclerviewdicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ActivityAboutMeBinding

class AboutMe : AppCompatActivity() {
    private lateinit var aboutMeBinding: ActivityAboutMeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aboutMeBinding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(aboutMeBinding.root)
        supportActionBar?.title = resources.getString(R.string.about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
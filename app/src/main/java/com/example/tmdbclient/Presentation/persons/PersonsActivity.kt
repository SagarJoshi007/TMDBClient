package com.example.tmdbclient.Presentation.persons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityPersonsBinding

class PersonsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_persons)
    }
}
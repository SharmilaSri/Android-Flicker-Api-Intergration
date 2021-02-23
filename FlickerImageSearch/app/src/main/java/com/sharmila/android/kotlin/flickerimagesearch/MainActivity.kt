package com.sharmila.android.kotlin.flickerimagesearch

import PhotolistAdapter
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sharmila.android.kotlin.flickerimagesearch.database.Word
import com.sharmila.android.kotlin.flickerimagesearch.model.Photo
import com.sharmila.android.kotlin.flickerimagesearch.singleton.AppApplication
import com.sharmila.android.kotlin.flickerimagesearch.viewmodel.MainActivityViewModel
import com.sharmila.android.kotlin.flickerimagesearch.viewmodel.WordViewModel
import com.sharmila.android.kotlin.flickerimagesearch.viewmodel.WordViewModelFactory

class MainActivity : AppCompatActivity() {

    private var model: MainActivityViewModel? = null
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory(
            (application as AppApplication).repository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query:String = intent.getStringExtra("QUERY").toString()
        seUpGridImage(query)

    }



    private fun seUpGridImage(searchQuery:String) {
        //setup view model and network call
        model = ViewModelProvider(this)[MainActivityViewModel::class.java]

        var photos= model?.getPhotos(searchQuery)
        photos?.observe(this@MainActivity, Observer {
            onResultReceived(photos.value?.photos?.photo!!,searchQuery)
        })
    }

    private fun onResultReceived(photolist:List<Photo>,searchQuery:String) {
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            var adapter:PhotolistAdapter = PhotolistAdapter(applicationContext,photolist)
            val layoutManager = GridLayoutManager(applicationContext,2)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.adapter = adapter

            if(!photolist.isEmpty())
                wordViewModel.insert(Word(searchQuery))
    }
}
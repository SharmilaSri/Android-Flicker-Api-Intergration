package com.sharmila.android.kotlin.flickerimagesearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sharmila.android.kotlin.flickerimagesearch.adapters.SearchWordListAdapter
import com.sharmila.android.kotlin.flickerimagesearch.adapters.SearchWordListAdapterCallback
import com.sharmila.android.kotlin.flickerimagesearch.viewmodel.WordViewModel
import com.sharmila.android.kotlin.flickerimagesearch.viewmodel.WordViewModelFactory
import com.sharmila.android.kotlin.flickerimagesearch.singleton.AppApplication



class SearchActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory(
            (application as AppApplication).repository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.search_word_recycle)
        val adapter = SearchWordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.setCallBack(object : SearchWordListAdapterCallback {
            override fun callback(queryText:String) {
                moveToMainActivity(queryText)

            }
        } )

        wordViewModel.allWords.observe(owner = this) { words ->
            // Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }

        setUpSearchBtn()
    }

    private fun setUpSearchBtn() {

        val searchBtn: Button =findViewById(R.id.search_btn)
        searchBtn.setOnClickListener(View.OnClickListener {
            val searchView: SearchView =findViewById(R.id.search_view)
            var searchQuery=searchView.query.toString()

            moveToMainActivity(searchQuery)
        })
    }

    private fun moveToMainActivity(searchQuery:String){
        var intent=Intent(applicationContext,MainActivity::class.java)
        intent.putExtra("QUERY",searchQuery)
        startActivity(intent)
    }
}
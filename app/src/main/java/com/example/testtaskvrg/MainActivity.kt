package com.example.testtaskvrg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskvrg.View.ListingViewModel
import com.example.testtaskvrg.View.model.DisplayablePost
import com.example.testtaskvrg.adapter.PostsAdapter
import com.example.testtaskvrg.databinding.ActivityMainBinding
import com.example.testtaskvrg.until.DataBindingUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var disposables : CompositeDisposable
    @Inject
    lateinit var viewModel: ListingViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        disposables = CompositeDisposable()
        disposables.add(
            viewModel.postsNew()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::displayPosts)
        )
    }

    override fun onStop() {
        super.onStop()
        disposables.dispose()
    }

    fun displayPosts(posts: List<DisplayablePost>) {
        val layoutManager = LinearLayoutManager(this)
        val adapter = PostsAdapter(posts)
        with(binding) {
            listingRecycler.layoutManager = layoutManager
            listingRecycler.adapter = adapter
        }
    }
}
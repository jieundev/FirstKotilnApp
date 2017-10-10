package com.dev.jieun.firstkotilnapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.*
import android.view.inputmethod.InputMethodManager
import com.dev.jieun.firstkotilnapp.R
import com.dev.jieun.firstkotilnapp.data.FlickrRepository
import com.dev.jieun.firstkotilnapp.ui.adapter.ImageDelegateAdapter
import com.dev.jieun.firstkotilnapp.ui.adapter.LoadDelegateAdapter
import com.dev.jieun.firstkotilnapp.ui.adapter.LoadMoreAdapter
import com.dev.jieun.firstkotilnapp.ui.base.BaseFragment
import com.dev.jieun.firstkotilnapp.ui.listener.InfiniteScrollListener
import com.dev.jieun.firstkotilnapp.ui.viewmodel.ImageViewModel
import com.dev.jieun.firstkotilnapp.util.AdapterConstants
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_image.*

class MainFragment : BaseFragment() {
    private var page = 0
    override fun getLayoutResource(): Int = R.layout.fragment_image
    private lateinit var activity : MainActivity // 늦은 초기화, 사용하는 시점에서 초기화

    // Java 식의 static instance
    companion object {
        val INSTANCE : MainFragment by lazy { MainFragment() }
        val TAG : String = "MainFragment"
    }

    private val fab by lazy {
        activity.findViewById<FloatingActionButton>(R.id.fab) as FloatingActionButton
    }

    private val viewModel : ImageViewModel by lazy {
        ImageViewModel(activity, FlickrRepository)
    }

    private val galleryAdapter : LoadMoreAdapter by lazy {
        println("MainFrag :: "+activity.applicationContext.toString())
        LoadMoreAdapter(activity.applicationContext).apply {
            delegateAdapters.put(AdapterConstants.LOADING, LoadDelegateAdapter(activity.applicationContext))
            delegateAdapters.put(AdapterConstants.ITEM, ImageDelegateAdapter(activity.applicationContext, {photo->
                activity.startActivity(Intent(activity, InfoActivity::class.java).apply {
                    putExtra("data", photo)
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                })
            }))
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun reqPhoto(){
        println("call api reqPhoto :: seoul")
        viewModel.fetchPhotoList(++page, "seoul")
    }

    private fun searchPhoto(searchText : String){
        println("call api searchPhoto :: "+searchText)
        viewModel.fetchPhotoList(++page, searchText)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.let{
            toolbar.title = getString(R.string.app_name)
        }

        fab.setOnClickListener {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            if(laySearchRootLinear.visibility == View.VISIBLE){
                editSearchText.text.clear()
                imm.hideSoftInputFromWindow(editSearchText.windowToken, 0)
                laySearchRootLinear.visibility = View.GONE

                Snackbar.make(it, "Hide Search Edit Box", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            } else {
                laySearchRootLinear.visibility = View.VISIBLE
                editSearchText.requestFocus()
                imm.showSoftInput(editSearchText, InputMethodManager.SHOW_FORCED)

                Snackbar.make(it, "show Search Edit Box", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }

        btnSearch.setOnClickListener{
            if (editSearchText.text.isNotEmpty()){
                page = 0
                galleryAdapter.clear()
                searchPhoto(editSearchText.text.toString())
                galleryAdapter.notifyDataSetChanged()
            } else {
                editSearchText.requestFocus()
                Snackbar.make(it, "정확한 값을 입력하세요.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
        }

        viewModel.showProgress = {
            loading_progress.visibility = View.VISIBLE
        }
        viewModel.hideProgress={
            if (loading_progress.visibility == View.VISIBLE){
                loading_progress.visibility = View.GONE
            }
        }

        viewModel.addItem = {
            galleryAdapter.addItems(it)
            galleryAdapter.notifyDataSetChanged()
        }

        // println("api with infinite scroll ")
        recyclerview.apply {
            setHasFixedSize(true)
            val staggerLayout = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            layoutManager = staggerLayout
            adapter = galleryAdapter
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ reqPhoto() }, staggerLayout))
        }

        // println("api with default call")
        reqPhoto()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}

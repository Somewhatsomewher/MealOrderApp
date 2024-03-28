package com.rubelz.presentation.fragments

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
import com.rubelz.presentation.R
import com.rubelz.presentation.adapters.ProductAdapter
import com.rubelz.presentation.databinding.FragmentMenuBinding
import com.rubelz.presentation.viewmodels.MenuViewModel.MenuViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class MenuFragment : Fragment(){
    private var _bind: FragmentMenuBinding? = null
    private val bind get() = _bind!!

    private lateinit var adapter: ProductAdapter
    val viewModel: MenuViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentMenuBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCategories()
        viewModel.getProducts()

        viewModel.categories.observe(viewLifecycleOwner) {

                for (i in it.indices) {
                    val chip = Chip(requireContext())
                    chip.text = it[i].name
                    chip.isCheckable = true
                    chip.isFocusable = true
                    chip.setBackgroundResource(R.drawable.custom_chip_bg)
                    bind.cgCategories.addView(chip)
            }
        }
        bind.cgCategories.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            if (chip != null) {
                if (chip.isChecked) {
                    viewModel.getProducts(chip.text.toString())
                } else {
                    viewModel.getProducts()
                }
            }
        }


        adapter = ProductAdapter(emptyList())
        viewModel.products.observe(viewLifecycleOwner) { products ->
            Log.d("MyTag", "$products")
            if (products != null) {

                adapter.addProducts(products)
                bind.rvProducts.adapter = adapter
                bind.rvProducts.layoutManager = LinearLayoutManager(requireContext())
            }
        }

        bind.rvProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && bind.bannerLayout.visibility == View.VISIBLE) {
                    bind.bannerLayout.visibility = View.GONE
                } else if (dy < 0 && bind.bannerLayout.visibility != View.VISIBLE) {
                    bind.bannerLayout.visibility = View.VISIBLE
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}
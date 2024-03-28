package com.rubelz.presentation.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.chip.Chip
//import com.google.android.material.chip.ChipGroup
//import com.rubelz.presentation.R
//import com.rubelz.presentation.databinding.FragmentMenuBinding
//
//class CategoryAdapter(private val categoryList: List<String>) :
//    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        val bind =FragmentMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CategoryViewHolder(bind)
//    }
//
//    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
//        holder.bind(categoryList[position])
//        private val chipGroup: ChipGroup = itemView.findViewById(R.id.chipGroup)
//
//        fun bind(category: String) {
//            val chip = Chip(chipGroup.context)
//            chip.text = category
//            chip.isClickable = true
//            chip.isCheckable = false // Set to true if you want the chips to be checkable
//            chipGroup.addView(chip)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return categoryList.size
//    }
//
//    inner class CategoryViewHolder(val bind: FragmentMenuBinding) : RecyclerView.ViewHolder(bind.root) {
//
//    }
//}
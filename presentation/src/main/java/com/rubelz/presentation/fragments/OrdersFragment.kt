package com.rubelz.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubelz.presentation.R
import com.rubelz.presentation.databinding.FragmentOrdersBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : Fragment() {
    private var _bind: FragmentOrdersBinding? = null
    private val bind get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentOrdersBinding.inflate(inflater, container, false)

        return bind.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}
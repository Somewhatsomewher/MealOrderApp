package com.rubelz.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rubelz.presentation.R
import com.rubelz.presentation.databinding.FragmentProfileBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private var _bind: FragmentProfileBinding? = null
    private val bind get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentProfileBinding.inflate(inflater, container, false)

        return bind.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}
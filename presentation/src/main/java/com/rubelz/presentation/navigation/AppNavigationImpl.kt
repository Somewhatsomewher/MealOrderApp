package com.rubelz.presentation.navigation

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rubelz.presentation.R
import javax.inject.Inject

class AppNavigationImpl @Inject constructor(private val activity: FragmentActivity) :
    AppNavigation {

    override fun getNaveHostFragment(hostFragmentId: Int): NavController {
        val navHostFragment =
            activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

}
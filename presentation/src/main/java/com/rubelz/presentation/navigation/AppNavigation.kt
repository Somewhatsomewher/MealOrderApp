package com.rubelz.presentation.navigation

import androidx.navigation.NavController

interface AppNavigation {
    fun getNaveHostFragment(hostFragmentId: Int): NavController

}
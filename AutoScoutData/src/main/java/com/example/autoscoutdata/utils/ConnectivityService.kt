package com.example.autoscoutdata.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

class ConnectivityService(private val context: Context) {

    fun checkNetwork(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkNetworkPostMarshmallow(connectivityManager)
        } else {
            checkNetworkPreMarshmallow(connectivityManager)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkNetworkPostMarshmallow(connectivityManager: ConnectivityManager): Boolean {
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    }

    @Suppress("DEPRECATION")
    private fun checkNetworkPreMarshmallow(connectivityManager: ConnectivityManager): Boolean {
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}

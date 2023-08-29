package com.example.autoscoutdata.DataErrors

class NoNetworkException(override val message:String?):Exception(message)

class ApiException(override val message: String?):Exception(message)
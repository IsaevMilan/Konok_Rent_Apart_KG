package com.KonokRent.app.domain.models

data class Hotel(
    val id: String,
    val  name: String,
    val feedbacksCount: Int,
    val rating: Double,
    val price: Int,
    val please: Int,
    val betsCount: Int,
    val roomsCount: Int,
    val bathCount: Int,
)

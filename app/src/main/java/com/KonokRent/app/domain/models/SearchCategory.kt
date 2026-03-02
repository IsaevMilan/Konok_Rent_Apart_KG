package com.KonokRent.app.domain.models

import com.airbnbclone.app.R

enum class SearchCategory(val title: String, val iconRes: Int) {
    HOTELS("Отели", R.drawable.ic_hotel),
    PRIVATE("Частные хозяева", R.drawable.ic_house),
    RESORTS("Курортные зоны", R.drawable.ic_resort)
}
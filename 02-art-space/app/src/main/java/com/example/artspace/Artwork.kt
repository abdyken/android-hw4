package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    val id: Int,
    @param:DrawableRes val imageRes: Int,
    @param:StringRes val descriptionRes: Int,
    @param:StringRes val titleRes: Int,
    @param:StringRes val artistRes: Int,
    @param:StringRes val yearRes: Int
)

val artworks = listOf(
    Artwork(
        id = 1,
        imageRes = R.drawable.starry_night,
        descriptionRes = R.string.starry_night_description,
        titleRes = R.string.starry_night_title,
        artistRes = R.string.starry_night_artist,
        yearRes = R.string.starry_night_year
    ),
    Artwork(
        id = 2,
        imageRes = R.drawable.impression_sunrise,
        descriptionRes = R.string.impression_sunrise_description,
        titleRes = R.string.impression_sunrise_title,
        artistRes = R.string.impression_sunrise_artist,
        yearRes = R.string.impression_sunrise_year
    ),
    Artwork(
        id = 3,
        imageRes = R.drawable.great_wave,
        descriptionRes = R.string.great_wave_description,
        titleRes = R.string.great_wave_title,
        artistRes = R.string.great_wave_artist,
        yearRes = R.string.great_wave_year
    ),
    Artwork(
        id = 4,
        imageRes = R.drawable.ninth_wave,
        descriptionRes = R.string.ninth_wave_description,
        titleRes = R.string.ninth_wave_title,
        artistRes = R.string.ninth_wave_artist,
        yearRes = R.string.ninth_wave_year
    ),
    Artwork(
        id = 5,
        imageRes = R.drawable.pearl_earring,
        descriptionRes = R.string.pearl_earring_description,
        titleRes = R.string.pearl_earring_title,
        artistRes = R.string.pearl_earring_artist,
        yearRes = R.string.pearl_earring_year
    )
)

package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var artworkId by remember { mutableIntStateOf(1) }
    var imageRes by remember { mutableIntStateOf(R.drawable.starry_night) }
    var descriptionRes by remember { mutableIntStateOf(R.string.starry_night_description) }
    var titleRes by remember { mutableIntStateOf(R.string.starry_night_title) }
    var artistRes by remember { mutableIntStateOf(R.string.starry_night_artist) }
    var yearRes by remember { mutableIntStateOf(R.string.starry_night_year) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(
            imageRes = imageRes,
            contentDescription = stringResource(descriptionRes),
            modifier = Modifier.weight(1f)
        )
        ArtworkDescriptor(
            title = stringResource(titleRes),
            artist = stringResource(artistRes),
            year = stringResource(yearRes),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        DisplayController(
            onPreviousClick = {
                when (artworkId) {
                    1 -> {
                        artworkId = 5
                        imageRes = R.drawable.pearl_earring
                        descriptionRes = R.string.pearl_earring_description
                        titleRes = R.string.pearl_earring_title
                        artistRes = R.string.pearl_earring_artist
                        yearRes = R.string.pearl_earring_year
                    }
                    2 -> {
                        artworkId = 1
                        imageRes = R.drawable.starry_night
                        descriptionRes = R.string.starry_night_description
                        titleRes = R.string.starry_night_title
                        artistRes = R.string.starry_night_artist
                        yearRes = R.string.starry_night_year
                    }
                    3 -> {
                        artworkId = 2
                        imageRes = R.drawable.impression_sunrise
                        descriptionRes = R.string.impression_sunrise_description
                        titleRes = R.string.impression_sunrise_title
                        artistRes = R.string.impression_sunrise_artist
                        yearRes = R.string.impression_sunrise_year
                    }
                    4 -> {
                        artworkId = 3
                        imageRes = R.drawable.great_wave
                        descriptionRes = R.string.great_wave_description
                        titleRes = R.string.great_wave_title
                        artistRes = R.string.great_wave_artist
                        yearRes = R.string.great_wave_year
                    }
                    5 -> {
                        artworkId = 4
                        imageRes = R.drawable.ninth_wave
                        descriptionRes = R.string.ninth_wave_description
                        titleRes = R.string.ninth_wave_title
                        artistRes = R.string.ninth_wave_artist
                        yearRes = R.string.ninth_wave_year
                    }
                }
            },
            onNextClick = {
                when (artworkId) {
                    1 -> {
                        artworkId = 2
                        imageRes = R.drawable.impression_sunrise
                        descriptionRes = R.string.impression_sunrise_description
                        titleRes = R.string.impression_sunrise_title
                        artistRes = R.string.impression_sunrise_artist
                        yearRes = R.string.impression_sunrise_year
                    }
                    2 -> {
                        artworkId = 3
                        imageRes = R.drawable.great_wave
                        descriptionRes = R.string.great_wave_description
                        titleRes = R.string.great_wave_title
                        artistRes = R.string.great_wave_artist
                        yearRes = R.string.great_wave_year
                    }
                    3 -> {
                        artworkId = 4
                        imageRes = R.drawable.ninth_wave
                        descriptionRes = R.string.ninth_wave_description
                        titleRes = R.string.ninth_wave_title
                        artistRes = R.string.ninth_wave_artist
                        yearRes = R.string.ninth_wave_year
                    }
                    4 -> {
                        artworkId = 5
                        imageRes = R.drawable.pearl_earring
                        descriptionRes = R.string.pearl_earring_description
                        titleRes = R.string.pearl_earring_title
                        artistRes = R.string.pearl_earring_artist
                        yearRes = R.string.pearl_earring_year
                    }
                    5 -> {
                        artworkId = 1
                        imageRes = R.drawable.starry_night
                        descriptionRes = R.string.starry_night_description
                        titleRes = R.string.starry_night_title
                        artistRes = R.string.starry_night_artist
                        yearRes = R.string.starry_night_year
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes imageRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = Color.White,
            shadowElevation = 12.dp,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}

@Composable
fun ArtworkDescriptor(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 26.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 32.sp
        )
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(artist)
                }
                append(" ($year)")
            },
            fontSize = 16.sp
        )
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}

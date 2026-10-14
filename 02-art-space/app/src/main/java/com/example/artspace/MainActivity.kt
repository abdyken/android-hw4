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
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(
            imageRes = R.drawable.starry_night,
            contentDescription = stringResource(R.string.starry_night_description),
            modifier = Modifier.weight(1f)
        )
        ArtworkDescriptor(
            title = stringResource(R.string.starry_night_title),
            artist = stringResource(R.string.starry_night_artist),
            year = stringResource(R.string.starry_night_year),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
        DisplayController(
            onPreviousClick = {},
            onNextClick = {},
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

package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtSpaceUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceLayout()
            }
        }
    }

    @Test
    fun firstArtwork_isShownOnStart() {
        composeTestRule.onNodeWithText("The Starry Night").assertExists()
    }

    @Test
    fun nextButton_showsSecondArtwork() {
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Impression, Sunrise").assertExists()
    }

    @Test
    fun nextButton_onLastArtwork_wrapsAroundToFirst() {
        repeat(artworks.size) {
            composeTestRule.onNodeWithText("Next").performClick()
        }
        composeTestRule.onNodeWithText("The Starry Night").assertExists()
    }

    @Test
    fun previousButton_onFirstArtwork_wrapsAroundToLast() {
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Girl with a Pearl Earring").assertExists()
    }
}

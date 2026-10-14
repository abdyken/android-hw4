# Assignment 4 — State and User Interaction in Jetpack Compose

Android Basics with Compose, Unit 2, Pathway 3:
https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-3

## Projects

| # | Folder | Codelabs |
|---|--------|----------|
| 1 | `01-tip-time/` | Intro to state in Compose, Calculate a custom tip, Write automated tests |
| 2 | `02-art-space/` | Project: Create an Art Space app (including the screen sizes challenge) |

### 01 Tip Time

- **Intro to state in Compose** — `TextField`, `mutableStateOf`, `remember`, recomposition, state hoisting
- **Calculate a custom tip** — tip percentage field, `ImeAction.Next` / `ImeAction.Done`, round up `Switch`, `verticalScroll` for landscape, leading icons (optional task, see `01-tip-time/TASKS.md`)
- **Write automated tests** — local test `TipCalculatorTests` and instrumentation test `TipUITests`

### 02 Art Space

Requirements and low fidelity prototype are in `02-art-space/TASK.md`.

- Three sections: artwork wall, artwork descriptor, display controller
- `Previous` / `Next` buttons with wraparound in both directions
- Artworks stored as a list of `Artwork` data class objects, current artwork kept with `rememberSaveable`
- Side by side layout on wide screens and limited width on tall screens (challenge)
- Instrumentation tests `ArtSpaceUITests` for navigation and wraparound
- Artwork images are public domain paintings from Wikimedia Commons

## Running tests

```bash
cd 01-tip-time && ./gradlew testDebugUnitTest connectedDebugAndroidTest
cd 02-art-space && ./gradlew testDebugUnitTest connectedDebugAndroidTest
```

## Screenshots

| Tip Time | | |
|---|---|---|
| ![](screenshots/01-codelab1-state.png) | ![](screenshots/02-codelab2-custom-tip.png) | ![](screenshots/03-codelab2-landscape-scroll.png) |

| Art Space | | |
|---|---|---|
| ![](screenshots/04-project-static-ui.png) | ![](screenshots/05-project-pearl-earring.png) | ![](screenshots/06-project-great-wave.png) |
| ![](screenshots/10-challenge-phone-portrait-after.png) | ![](screenshots/11-challenge-phone-landscape-after.png) | ![](screenshots/09-challenge-tablet-portrait-after.png) |

Tablet landscape before and after the challenge fixes:

![](screenshots/07-challenge-tablet-before.png)
![](screenshots/08-challenge-tablet-landscape-after.png)

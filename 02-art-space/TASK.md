# Art Space — project requirements

Source: https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space

## Goal

Build an app that works as a digital art space. It shows one artwork at a time
together with information about it and lets the user move between artworks.

## Requirements

- Show one artwork image with a meaningful `contentDescription` for TalkBack
- Show the artwork title and the artist with the year of publication
- Add **Previous** and **Next** buttons
- Keep the image title artist and year in `MutableState` so the UI updates on tap
- Give every artwork a sequential id starting from 1 and use a `when` expression in `onClick`
- Next on the last artwork wraps around to the first one
- Previous on the first artwork wraps around to the last one
- Use only images that are owned or free to use

## Low fidelity prototype

```
+--------------------------------+
|                                |
|   +------------------------+   |
|   |                        |   |   Artwork Wall
|   |        artwork         |   |   Surface with shadow and border
|   |         image          |   |   holding the Image
|   |                        |   |
|   +------------------------+   |
|                                |
|   +------------------------+   |
|   | Artwork Title          |   |   Artwork Descriptor
|   | Artist (Year)          |   |   two Text composables
|   +------------------------+   |
|                                |
|   [ Previous ]    [  Next  ]   |   Display Controller
+--------------------------------+
```

## Artworks (public domain, Wikimedia Commons)

| Id | Title | Artist | Year |
|----|-------|--------|------|
| 1 | The Starry Night | Vincent van Gogh | 1889 |
| 2 | Impression, Sunrise | Claude Monet | 1872 |
| 3 | The Great Wave off Kanagawa | Katsushika Hokusai | 1831 |
| 4 | The Ninth Wave | Ivan Aivazovsky | 1850 |
| 5 | Girl with a Pearl Earring | Johannes Vermeer | 1665 |

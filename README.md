[![Download](https://api.bintray.com/packages/sczerwinski/android/tiles-layout/images/download.svg)](https://bintray.com/sczerwinski/android/tiles-layout/_latestVersion)

Anko:
[![Download](https://api.bintray.com/packages/sczerwinski/android/tiles-layout-anko/images/download.svg)](https://bintray.com/sczerwinski/android/tiles-layout-anko/_latestVersion)

# Static Tiles Layout For Android And Anko

## Gradle Build Configuration

```gradle
dependencies {
    compile 'it.czerwinski.android:tiles-layout:0.1'
    compile 'it.czerwinski.android:tiles-layout-anko:0.1' // with Kotlin and Anko
}
```

## Usage

### XML layout

```xml
<it.czerwinski.android.view.layout.tiles.TilesLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:paddingTop="8dp"
    android:paddingBottom="8dp"
    app:tilesLayout_colsCount="2"
    app:tilesLayout_rowsCount="3"
    app:tilesLayout_innerHorizontalPadding="24dp"
    app:tilesLayout_innerVerticalPadding="12dp">

    <Button
        android:text="Button 1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <Button
        android:text="Button 2"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <Button
        android:text="Button 3"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <Button
        android:text="Button 4"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <Button
        android:text="Button 5"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <Button
        android:text="Button 6"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</it.czerwinski.android.view.layout.tiles.TilesLayout>
```

### Anko

```kotlin
tilesLayout(cols = 2, rows = 3) {
    horizontalPadding = dip(16)
    verticalPadding = dip(8)
    innerHorizontalPadding = dip(24)
    innerVerticalPadding = dip(12)

    button("Button 1")
    button("Button 2")
    button("Button 3")
    button("Button 4")
    button("Button 5")
    button("Button 6")
}
```

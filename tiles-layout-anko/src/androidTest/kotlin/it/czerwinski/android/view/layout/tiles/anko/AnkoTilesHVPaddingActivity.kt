package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.dip

class AnkoTilesHVPaddingActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		tilesLayout(cols = 2, rows = 2) {
			horizontalPadding = dip(8)
			verticalPadding = dip(16)

			button("Button 1")
			button("Button 2")
			button("Button 3")
			button("Button 4")
		}
	}
}

package it.czerwinski.android.view.layout.tiles.anko

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.dip

class AnkoTilesPaddingActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		tilesLayout(cols = 2, rows = 2) {
			padding = dip(36)

			button("Button 1")
			button("Button 2")
			button("Button 3")
			button("Button 4")
		}
	}
}

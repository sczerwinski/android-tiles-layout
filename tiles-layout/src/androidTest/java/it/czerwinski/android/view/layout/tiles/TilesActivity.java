package it.czerwinski.android.view.layout.tiles;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import it.czerwinski.android.view.layout.tiles.test.R;

public class TilesActivity extends Activity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity_tiles);
	}
}

package com.mygdx.game;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class AndroidLauncher extends FragmentActivity implements  AndroidFragmentApplication.Callbacks {

	private GameFragment libgdxFragment;

	private Button btn_arena;
	private boolean arena = true; //true-playa;false-disco
	private boolean dancer = true; //true-lego;false-
	private int move = 0;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dance);

		// Create libgdx fragment
		libgdxFragment = new GameFragment(arena, dancer, move);

		// Put it inside the framelayout (which is defined in the layout.xml file).
		getSupportFragmentManager().beginTransaction().
				add(R.id.dance_layout, libgdxFragment).
				addToBackStack(null).
				commit();

		btn_arena = (Button) findViewById(R.id.btn_arena);

		btn_arena.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				/*arena = !arena;
				libgdxFragment.changeArena();*/
				arena = !arena;
				getSupportFragmentManager().beginTransaction().remove(libgdxFragment).
						addToBackStack(null).
						commit();
				libgdxFragment = new GameFragment(arena, dancer, move);
				getSupportFragmentManager().beginTransaction().
						add(R.id.dance_layout, libgdxFragment).
						addToBackStack(null).
						commit();
			}
		});
	}

	@Override
	public void exit() {

	}
}

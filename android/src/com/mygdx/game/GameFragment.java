package com.mygdx.game;

/**
 * Created by DanielAlejandro on 15/05/2017.
 */
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class GameFragment extends AndroidFragmentApplication{

    private MyGdxGame game;

    private boolean arena = true; //true-playa;false-disco
    private boolean dancer = true; //true-lego;false-
    private int move = 0;

    public GameFragment(boolean arena, boolean dancer, int move){
        game = new MyGdxGame(arena, dancer, move);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // return the GLSurfaceView on which libgdx is drawing game stuff
        //game = new MyGdxGame();
        return initializeForView(game);
    }

    public void changeArena(){
        game.changeArena();
    }
}
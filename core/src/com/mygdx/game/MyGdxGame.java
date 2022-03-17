package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture buttonImage;
	private Texture bucketImage;
	private BitmapFont font;
	private Rectangle cursor;

	@Override
	public void create () {
		font = new BitmapFont();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		buttonImage = new Texture("Button.png");
		cursor = new Rectangle();
		bucketImage = new Texture("bucket.png");

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);

		batch.begin();
		Button pink = new Button(buttonImage, batch,128, 50, 300, 400);
		pink.interact(bucketImage);
		if(pink.isPressed() == true){
			batch.draw(bucketImage, 30, 30);
			font.draw(batch, Integer.toString(pink.getCount()), 200, 240 );
		}
		puzzle1();
		batch.end();
	}

	public void puzzle1(){
//		if(cursor.overlaps(button)){
//
//
//		}



	}


	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.*;
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
	private Animation spriteMovement;
	private Texture[] moveTextures;
	private BitmapFont font;
	private Rectangle cursor;
	Button pink;

	//player movement
	private Sprite player;
	private float playerSpeed = 1.2f;
	private float elapsedTime = 0;

	@Override
	public void create () {
		player = new Sprite();
		font = new BitmapFont();
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		buttonImage = new Texture("Button.png");
		cursor = new Rectangle();
		bucketImage = new Texture("bucket.png");
		moveTextures = new Texture []{new Texture("Sprite_Frame1.png"), new Texture("Sprite_Frame2.png"), new Texture("Sprite_Frame3.png"), new Texture("Sprite_Frame4.png")};
		spriteMovement = new Animation <Texture> (0.08f, moveTextures);
		player = new Sprite;

		pink = new Button(buttonImage, batch, 128, 50, 300, 400);
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 0, 0.2f, 1);

		player.setTexture(spriteMovement.getKeyFrame(elapsedTime, true));
		playerMovement();

		batch.begin();
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

	public void playerMovement(){

		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			player.translateX(playerSpeed);
			if (player.isFlipX()){
				player.flip(true,false);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)){

			player.translateX(-playerSpeed);
			if (!player.isFlipX()){
				player.flip(true, false);
			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)){

			player.translateY(playerSpeed);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)){

			player.translateY(-playerSpeed);
		}
	}



	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

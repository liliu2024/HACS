package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

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

public class Button extends ApplicationAdapter {
    private int width;
    private int height;
    private int x;
    private int y;
    private int count;
    private BitmapFont font;
    private Texture buttonTexture;
    private SpriteBatch buttonBatch;
//128, 50
    public Button(Texture texture, SpriteBatch batch,int width, int height, int x, int y){
        this.buttonTexture = texture;
        this.buttonBatch = batch;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.font = new BitmapFont();
    }
//**(0, 0) is top left, but objects are made with bottom left corner
    public boolean overlaps(){
        if(Gdx.input.getX() > x && Gdx.input.getX() < (x+width)
        && Gdx.input.getY() < 480-y && Gdx.input.getY() > (480- y -height)
        ) {return true;}
        else{
            return false;
        }

    }

    public void interact(Texture altTexture){
        if(overlaps() == false){
            buttonBatch.draw(buttonTexture, x, y);
        }else{
            setButtonTexture(altTexture);
            buttonBatch.draw(altTexture, x, y);
        }

    }
    public boolean isPressed(){
       if(overlaps() && Gdx.input.isTouched()){
           count++;
           if(count % 2 == 0){
               return false;
           }else{
               return true;
           }
       }
//        font.draw(buttonBatch, Integer.toString(count), 60, 60);
       return false;
    }

    public int getCount(){
        return count;
    }

    public void trial(){

    }

    public void setButtonTexture(Texture freshTexture){
        buttonTexture = freshTexture;
    }
    public Texture getButtonTexture() {
        return buttonTexture;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

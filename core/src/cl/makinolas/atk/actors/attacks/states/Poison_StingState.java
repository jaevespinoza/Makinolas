package cl.makinolas.atk.actors.attacks.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

import cl.makinolas.atk.actors.Monsters;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Poison_StingState extends SpriteState{
  
  @Override
  public int getAttackDamage() {
    return 15;
  }

  @Override
  public void initializeBody(float x, float y) {
    myAttack.initializeBody(x, y);
  }

  @Override
  public TextureRegion getTexture() {
    return new TextureRegion(new Texture(Gdx.files.internal("Attacks/Poison_Sting.png")));
  }

  @Override
  public int getWidth() {
    return 16;
  }

  @Override
  public int getHeight() {
    return 5;
  }

  @Override
  public float getFrameTime() {
    return 0.2f;
  }

  @Override
  public PlayMode getModeAnimation() {
    return Animation.PlayMode.LOOP;
  }

  @Override
  public int getInitialSprite() {
    return 0;
  }

  @Override
  public int getFinalSprite() {
    return 0;
  }

  @Override
  public int getTypeAttack(Monsters monster) {
    return myAttack.getPhysicalAttackDamage(monster);
  }

}

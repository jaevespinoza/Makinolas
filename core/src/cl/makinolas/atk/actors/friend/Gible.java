package cl.makinolas.atk.actors.friend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import cl.makinolas.atk.actors.Hero;

public class Gible extends AbstractFriend {
  
  private TextureRegion[][] faces;
  
  public Gible(Hero hero) {
    super(hero);
    faces = new TextureRegion(new Texture(Gdx.files.internal("Actors/Gible_faces.png"))).split(40,40);
    setTexture(new TextureRegion(new Texture(Gdx.files.internal("Actors/gible.png"))));
    setAnimations(new int[]{31,29},
                  new int[][]{new int[]{0,4},new int[]{0,5},new int[]{0,6},new int[]{0,5}},
                  new int[][]{new int[]{0,0}});
    setMeleeAnimation(7,9);
    setFaceSprite(faces[0][0]);
    initLevel(5);
    initDead();
    setActualEvolution(0);
    setMaxHealth(30);
    setMaxMagic(100);
    friend = Enemies.GIBLE;
  }

  public Gible(int level, Hero hero){
    this(hero);
    initLevel(level);
  }
  
  @Override
  protected void initLevel(int level){
   this.level = new Level(level);
   new Evolution(this.level, 34, 1);
   new Evolution(this.level, 50, 1);
  }
  
  @Override
  protected void evolve(int numberOfLevel){
    if (numberOfLevel == 1 && getActualEvolution() < 1){
      setTexture(new TextureRegion(new Texture(Gdx.files.internal("Actors/Gabite.png"))));
      setAnimations(new int[]{39,34},
          new int[][]{new int[]{0,4},new int[]{0,5},new int[]{0,6},new int[]{0,5}},
          new int[][]{new int[]{0,0}});
      setMeleeAnimation(7,9);
      setFaceSprite(faces[0][1]);
      setActualEvolution(1);
      setMaxHealth(70);
      setMaxMagic(100);
      friend = Enemies.GABITE;
    } else if (numberOfLevel == 2 && getActualEvolution() < 2){
      setTexture(new TextureRegion(new Texture(Gdx.files.internal("Actors/Garchomp.png"))));
      setAnimations(new int[]{43,40},
          new int[][]{new int[]{0,4},new int[]{0,5},new int[]{0,6},new int[]{0,5}},
          new int[][]{new int[]{0,0}});
      setMeleeAnimation(7,10);
      setFaceSprite(faces[0][2]);
      setActualEvolution(2);
      setMaxHealth(140);
      setMaxMagic(100);
      friend = Enemies.GARCHOMP;
    }
  }
  
}

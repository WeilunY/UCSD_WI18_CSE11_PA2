import java.awt.*;

/*  @author: cs11wml
 *  PID: A15017352
 *  Class name: Bear
 *  Class type: subclass of Critter
 *  Constructor: public Bear(boolean grizzly)
 *
 *  Overidden methods:
 *  - color (getColor): brown (new Color(190,110,50)) for a grizzly bear (when grizzly is true), and white (Color.WHITE) for a polar bear (when grizzly is false)
 *  - eating behavior (eat): always returns true
 *  - fighting behavior (fight): always scratch (Attack.SCRATCH)
 *  - movement behavior (getMove): alternates between south and east in a zigzag pattern (first south, then east, then south, then east, ...)
 *  - toString (toString): "B"
 */
public class Bear extends Critter{
  /* data field:
   * grizzly: wether the bear is grizzly bear or not
   * step: the total steps the bear has moved, used for getMove method
   */
  private boolean grizzly;
  private int step = 0;

  /* Create a bear object with boolean that determin the color of bear
   * @param grizzly: Whether the color is grizzly or white
   */
  public Bear(boolean grizzly){
    this.grizzly = grizzly;
  }

  // Always return true
  public boolean eat(){
    return true;
  }

  /* Return the color of the bear, grizzly or white
   * @return grizzly color if boolean grizzly is true, white otherwise
   */
  public Color getColor(){
    if (grizzly)
      return new Color(190,110,50);
    else
      return Color.WHITE;
  }

  /* Always return SCRATCH
   * @param opponent: the opponent critter's name
   */
  public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

  /* Return the direction of where the bear will go next, alternate between south and east
   * @return SOUTH if this.step is even, EAST if this.step is odd
   */
  public Direction getMove() {
    if(step % 2 == 0){
      step++;
      return Direction.SOUTH;
    }
    else{
      step++;
      return Direction.EAST;
    }
	}

  // Always return B
  public String toString() {
		return "B";
	}
}

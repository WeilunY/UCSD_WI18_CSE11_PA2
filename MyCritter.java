import java.awt.*;
import java.util.Random;

/*  @author: cs11wml
 *  PID: A15017352
 *  Class name: Bear
 *  Class type: subclass of Critter
 *  Constructor: public MyCritter()
 */
 
public class MyCritter extends Critter{

  /* data field:
   * bear: the number of bear have fought
   * lion: the number of lion have fought
   * r: random generator
   * fightWay: the random attack number
   * step: the total steps take
   * count: the number of mycritter alive in the field
   */
  private static int bear = 0;
  private static int lion = 0;
  private Random r = new Random();
  private int fightWay;
  private int step = 0;
  private static int count = 0;

  // Constructor
  // increment the number of count
  public MyCritter(){
    count++;
  }

  /* Return whether my critter eat or not
   * @return: true if take more than 10 steps, false otherwise
   */
  @Override
  public boolean eat(){
    if(step >= 10){
      return true;
    }
    else{
      return false;
    }
  }

  /* Return the attack stradegy base on different opponent
   * @param opponent: the opponent's name
   * @return different attack stradegy base on different opponent
   * details below:
   */
  @Override
  public Attack fight(String opponent) {

		switch(opponent){
      // When the opponent is bear always roar
      case "B":
        bear++;
        return Attack.ROAR;

      // When the opponent is lion
      // Since I am not bear, alwats return scratch
      case "L":
        lion++;
        return Attack.SCRATCH;

      // When the opponent is tiger
      // if the number is greater than 0 (1-12), return roar
      // if the number is 0, return scratch
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
      case "6":
      case "7":
      case "8":
      case "9":
      case "10":
      case "11":
      case "12":
        return Attack.ROAR;

      case"0":
        return Attack.SCRATCH;

      // When the opponent is dragon
      // generate random number base on the number of bear
      // The more bear I have encounted (beated) means there are less bear out there
      // So there will be higher chance for other attack
      // then generate random number base on the number of lion
      // The more bear I have encounted (beated) means there are less lion out there
      // the defalut will return random attack
      case "D":
        fightWay = r.nextInt(bear + 3);
        switch(fightWay){
          case 0: return Attack.POUNCE;
          default:
            fightWay = r.nextInt(lion + 3);
            switch(fightWay){
              case 0: return Attack.ROAR;
              default:
              fightWay = r.nextInt(3);
              switch(fightWay){
                case 2: return Attack.ROAR;
                case 1: return Attack.POUNCE;
                default: return Attack.SCRATCH;
              }
            }
        }

      // Default random attack
      default:
        fightWay = r.nextInt(3);
        switch(fightWay){
          case 1: return Attack.ROAR;
          case 2: return Attack.POUNCE;
          default: return Attack.SCRATCH;
      }
    }
	}


  /* return the color of mycritter
   * @return switch between blue and red, like a police light
   */
  @Override
	public Color getColor() {
    if (step % 2 == 0)
		  return Color.BLUE;
    else
      return Color.RED;
	}


// Experiment Chasing stradegy
  @Override
  public Direction getMove(){
    step++;
    String left = getNeighbor(Direction.WEST);
    String up = getNeighbor(Direction.NORTH);
    String right = getNeighbor(Direction.EAST);
    String down = getNeighbor(Direction.SOUTH);

    if(count > 12){
      if(left.equals("B") || up.equals("B"))
        return Direction.CENTER;

        else{
          if(step % 2 == 0)
            return Direction.EAST;
          else
            return Direction.NORTH;
          }
        }

      // When less than 13 left, start to pirotize mating
      else{
        if(down.equals("M") || left.equals("M"))
          return Direction.CENTER;

        else if(up.equals("M"))
          return Direction.NORTH;

        else if(right.equals("M"))
          return Direction.EAST;

        else{
          if(step % 2 == 0)
            return Direction.EAST;
          else
            return Direction.NORTH;
          }

      }

  }

  // decrement count when die
  @Override
  public void lose(){
    count--;
  }

  // increment when mate
  @Override
  public void mate(){
    count++;
  }

  // Always return M to represent MyCritter
  @Override
	public String toString() {
		return "M";
	}
}

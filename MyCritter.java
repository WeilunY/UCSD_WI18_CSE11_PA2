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
   * tiger: the number of tiger have fought
   * dragon: the number of dragon have fought
   */
  private int bear = 0;
  private int lion = 0;
  private int total = 0;
  private Random r = new Random();
  private int fightWay;
  private int step = 0;

  public MyCritter(){

  }

  @Override
  public boolean eat(){
    if(step >= 10){
      return true;
    }
    else{
      return false;
    }


  }

  @Override
  public Attack fight(String opponent) {

    //total *= 4 ;
		switch(opponent){
      // When the opponent is bear always roar
      case "B":
        bear++;
        return Attack.ROAR;

      // When the opponent is lion
      // generate random number base on the number of bear
      // the more bear I have encounted (beated) means there are less bear out there
      // So the higher chance Lion will use Pounce
      case "L":
        lion++;
        fightWay = r.nextInt(bear + 2);
        switch(fightWay){
          case 0: return Attack.SCRATCH;
          default: return Attack.POUNCE;
        }

      // When the opponent is tiger
      // generate random number base on the number of I have eaten
      // the more bear I eat means there are less food for tiger, so the higher chance it will be hungry
      // So the higher chance Lion will use SCRATCH
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
      case "6":
      case "7":
      case "8":
      case "9":
        return Attack.ROAR;

      case"0":
        return Attack.SCRATCH;

      // When the opponent is lion
      // generate random number base on the number of bear
      // The more bear I have encounted (beated) means there are less bear out there
      // So there will be higher chance for other attack
      // then generate random number base on the number of lion
      // The more bear I have encounted (beated) means there are less lion out there
      // the defalut will return random attack
      case "D":
        fightWay = r.nextInt(bear + 2);
        switch(fightWay){
          case 0: return Attack.POUNCE;
          default:
            fightWay = r.nextInt(lion + 2);
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


	public Color getColor() {
		return Color.BLUE;
	}

	public Direction getMove() {
    // reset step once it reaches 8 times total
    total = step * 2;
    if (step == total)
      step = 0;

    // Go West of South if step is smaller than 10
    if (step < total / 4 ){
      // if step is even then go west
      if (step % 2 == 0){
        step++;
        return Direction.WEST;
      }
      // go south otherwise
      else{
        step++;
        return Direction.SOUTH;
      }
    }

      // Go South or East if the step >= 10 and < 20
      else if (step < total / 2){
        // if step is even then go south
        if (step % 2 == 0){
          step++;
          return Direction.SOUTH;
        }
        // go east otherwise
        else{
          step++;
          return Direction.EAST;
        }
      }

      // Go North or East if the step >= 20 and < 30
      else if (step < total * 3 / 4){
        // if step is even then go East
        if (step % 2 == 0){
          step++;
          return Direction.EAST;
        }
        // go north otherwise
        else{
          step++;
          return Direction.NORTH;
        }
      }

      // Go North or West if the step >= 30 and < 40
      else{
        // if step is even then go North
        if (step % 2 == 0){
          step++;
          return Direction.NORTH;
        }
        // go West otherwise
        else{
          step++;
          return Direction.WEST;
        }
      }

	}

	public String toString() {
		return "M";
	}
}

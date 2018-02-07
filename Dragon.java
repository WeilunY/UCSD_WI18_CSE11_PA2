import java.awt.*;
import java.util.Random;

/*  @author: cs11wml
 *  PID: A15017352
 *  Class name: Bear
 *  Class type: subclass of Critter
 *  Constructor: public Dragon()
 *
 * Overidden methods:
 * - getColor: The dragon will change color depending on the food items that it consumes. If it has eaten an even number of food items, it will be black in color. If the dragon has eaten an odd number of food items, it will be white in color.
 * - fight: When the dragon encounters an animal of a different species, it will fight. The choice of attack will depend on the PREVIOUS animal that it encounters
 * - getMove: The initial direction of the dragon is WEST. In the subsequent moves, the dragon goes in a zig zag circle shape of diameter 10, going in counter clockwise direction.
 * - eat: The eating behavior of a dragon is always true.
 * - toString: The toString method should return “D”
 */

 public class Dragon extends Critter{

   /* data field
    * initialAttack: the initial random attack number
    * foodEaten: the number of food dragon has ate, used in eat and getColor
    * preMons: the previouse monster it fight, initialize as empty, used in fight
    */
    private int initialAttack;
    private int foodEaten = 0;
    private String preMons = "";
    private int step = 0;

    /* Constructor
     * Assign random int between 0 to 2 to initial Attack
     */
    public Dragon(){
      Random r = new Random();
      initialAttack = r.nextInt(3);
    }

    /* Always return true
     * increment foodEaten each time eat;
     */
    @Override
    public boolean eat(){
      foodEaten++;
      return true;
    }

    /* Return the color of the dragon
     * @return Black if foodEaten is even , White otherwise
     */
    @Override
    public Color getColor(){
      if(foodEaten % 2 == 0)
        return Color.BLACK;
      else
        return Color.WHITE;
    }

    /* Return attck type base on previous monster, if the first one then random
     * @param opponent: the opponent critter's name
     * @return: Roar if preMons is Bear, Pounce if preMons is Lion, Scratch otherwise
     * random attack if no preMons
     */
    @Override
    public Attack fight(String opponent) {
     switch(preMons){
       case "B":
          preMons = opponent;
          return Attack.ROAR;
       case "L":
          preMons = opponent;
          return Attack.POUNCE;
       case "":
          preMons = opponent;
          switch(initialAttack){
            case 0: return Attack.ROAR;
            case 1: return Attack.POUNCE;
            default: return Attack.SCRATCH;
          }
       default:
          preMons = opponent;
          return Attack.SCRATCH;
     }
   }

    /* Return the direction of where the Dragon will go next
     * The initial direction of the dragon is WEST. In the subsequent moves,
     * the dragon goes in a zigzag circle shape of diameter 10, going in
     * counter clockwise direction.
     * Increment step for each step takes
     * @return direction base on step
     */
    @Override
    public Direction getMove() {
      // reset step once it reaches 40
      if (step == 40)
        step = 0;

      // Go West of South if step is smaller than 10
      if (step < 10){
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
      else if (step < 20){
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
      else if (step < 30){
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

    // Always return D
    @Override
    public String toString() {
     return "D";
   }


 }

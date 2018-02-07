import java.awt.*;
import java.util.Random;

/*  @author: cs11wml
 *  PID: A15017352
 *  Class name: Bear
 *  Class type: subclass of Critter
 *  Constructor: public Tiger(int hunger)
 *
 * Overidden methods:
 * - color (getColor): yellow (Color.YELLOW)
 * - eating behavior (eat): returns true the first hunger times it is called (variable hunger is passed in the constructor), and false after that
 * - fighting behavior (fight): if this Tiger is hungry (if eat would return true), then scratch (Attack.SCRATCH); else pounce (Attack.POUNCE). NOTE: Based on your code, calling eat() may change the hunger status. So it may not be wise to call eat() to check if the tiger is hungry.
 * - movement behavior (getMove): Chooses a random direction dir(north, south, east, or west) and moves in that direction for 3 subsequent calls to move function. Then chooses a new random direction and repeats. If you forget how to use random object, please check the “Generating random numbers” section below.
 * - toString (toString): the number of pieces of food this Tiger still wants to eat, as a String (i.e. "4")
 */

public class Tiger extends Critter{

  /* data field:
   * hunger: the total number of food the tiger will eat
   * eatTimes: the time tiger has eaten, used in eat method
   * step: the number or step it takes for one direction used in getMove
   * direction: the reference for direction used in gerMove
   */
   private int hunger;
   private int eatTimes = 0;
   private int step = 0;
   private int direction;

   /* Construct a Tiger object with max number of food it will eat
    * @param hunger: the total food the tiger will eat
    */
    public Tiger(int hunger){
      this.hunger = hunger;
    }

    /* Return whether lion eat or not
     * @return: True if eatTimes < hungry; false otherwise
     * incremnent eatTimes everytime eat
     */
    @Override
    public boolean eat(){
      if (eatTimes < hunger){
        eatTimes++;
        return true;
      }
      else{
        return false;
      }
    }

    /* Return the color of the lion
     * @return Yellow
     */
    @Override
    public Color getColor(){
      return Color.YELLOW;
    }

    /* Return Scratch if hungry, Pounce otherwise
     * @param opponent: the opponent critter's name
     * @return: SCRATCH if eatTimes < hunger, POUNCE otherwise
     */
    @Override
    public Attack fight(String opponent) {
     if (eatTimes < hunger){
       return Attack.SCRATCH;
     }
     else{
       return Attack.POUNCE;
     }
   }

    /* Return the direction of where the Tiger will go next
     * Randomly generate a number and move for 3 times
     * @return randomly chose direction for 3 times
     */
    @Override
    public Direction getMove() {
      // create a new random
      Random r = new Random();

      // randomly assign the direction if step is 0
      if (step == 0){
        direction = r.nextInt(4);
      }

      // increment step
      // if step > 2 reset it to 0
      step++;
      if(step > 2)
        step = 0;

      // return direction base on int direction
      switch(direction){
        case 0:
          return Direction.NORTH;
        case 1:
          return Direction.EAST;
        case 2:
          return Direction.SOUTH;
        default:
          return Direction.WEST;
      }

   }

    // return the number of food the tiger still want to eat.
    @Override
    public String toString() {
     return Integer.toString(hunger - eatTimes);
   }
 }

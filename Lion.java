import java.awt.*;

/*  @author: cs11wml
 *  PID: A15017352
 *  Class name: Bear
 *  Class type: subclass of Critter
 *  Constructor: public Lion()
 *
 * Overidden methods:
 * - color (getColor): red (Color.RED)
 * - eating behavior (eat()): returns true if this Lion has been in a fight since it has last eaten (if fight has been called on this Lion at least once since the last call to eat).
 * - fighting behavior (fight): if opponent is a Bear ("B"), then roar (Attack.ROAR); otherwise pounce (Attack.POUNCE).
 * - movement behavior: first go south 5 times, then go west 5 times, then go north 5 times, then go east 5 times (a clockwise square pattern), then repeat.
 * - toString: "L"
 */

 public class Lion extends Critter{

   /* data field:
    * fightTimes: the number of fight since last eaten
    * step: the number of step, used in getMove
    */
   private int fightTimes = 0;
   private int step = 0;

   // Constructor
   // No Argument
   public Lion(){

   }

   /* Return whether lion eat or not
    * @return: True if fightTimes > 0; false otherwise
    * set fightTimes to 0 if return true;
    */
   public boolean eat(){
     if (this.fightTimes > 0) {
       fightTimes = 0;
       return true;
     }
     else {
       return false;
     }
   }

   /* Return the color of the lion
    * @return RED
    */
   public Color getColor(){
     return Color.RED;
   }

   /* Return Roar for bear and pounce for others
    * @param opponent: the opponent critter's name
    * @return: ROAR if opponent is B, POUNCE otherwise
    */
   public Attack fight(String opponent) {
 		if (opponent.equals("B")){
      return Attack.ROAR;
    } else {
      return Attack.POUNCE;
    }
 	}

   /* Return the direction of where the Lion will go next
    * alternate between all direction for every 5 steps
    * @return SOUTH for first 5, WEST for second 5
    * NORTH for third 5, and EAST for eorth 5
    * increment step for every step take
    */
   public Direction getMove() {
     // Start a new cycle when total step reach 20
     if(step == 20)
      step = 0;

     if(step < 5){
       // first 5 step go south
       // total < 5
       step++;
       return Direction.SOUTH;
     }
     else if(step < 10){
       // then go west for 5 steps
       // total < 10
       step++;
       return Direction.WEST;
     }
     else if(step < 15){
       // then go north for 5 step
       // total < 15
       step++;
       return Direction.NORTH;
     }
     else {
       // the go east for 5 step
       // total < 20;
       step++;
       return Direction.EAST;
     }

 	}

   // Always return L
   public String toString() {
 		return "L";
 	}

 }

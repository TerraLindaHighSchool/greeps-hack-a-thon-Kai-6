import greenfoot.*;

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.2
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!

    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }

    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
        setFlag(2, true);
    }

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        if(getFlag(2)) {
            setMemory(Greenfoot.getRandomNumber(100));
            if(getMemory() <= 25) {
                setRotation(0);
            } else if (getMemory() > 25 && getMemory() <= 50) {
                setRotation(90);
            } else if (getMemory() > 50 && getMemory() <= 75) {
                setRotation(180);
            } else {
                setRotation(-90);
            }
            setFlag(2, false);
        }
        if(atWater()) {
            spit("purple");
            turn(45);
            move();
            return;
        } else {
            if(atWorldEdge()) {
                turn(10);
                move();
                return;
            } else {

                if(carryingTomato()) {
                    if(atShip()) {
                        turn(180);
                        dropTomato();
                        return;
                    }
                    if(seePaint("purple")) {
                        move();
                        return;
                    }
                    checkFood();
                    setFlag(1, false);
                    turnHome();
                    move();
                    return;
                } else {
                    if(getFlag(1)) {
                        setFlag(1, false);
                        checkFood();
                        return;
                    }
                    spit("red");
                    move();
                    checkFood();
                    return;
                }
            }
        }
    }

    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            setFlag(1, true);
            loadTomato();
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
        }
    }

    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Kai";  // write your name here!
    }

    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        return carryingTomato() ? "greep-with-food.png" : "greep.png";
    }
}
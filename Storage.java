/**
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
                    move();
                    checkFood();
                    return;
                }
            }
        }
        */
        

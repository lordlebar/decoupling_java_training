package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("Corentin");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        if (player.getClass() == HumanPlayer.class)
            logger.log("enter your number : ");

        long guess = player.askNextGuess();
        if (numberToGuess ==  guess){
            logger.log("Vous avez trouvez le bon nombre !");
            return true;
        }

        this.player.respond(numberToGuess > player.askNextGuess());
        return false;
    }

    public void loopUntilPlayerSucceed(long number) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < number; i++){
            if (nextRound()){
                break;
            }
        }
        long end = System.currentTimeMillis();

        logger.log(Long.toString(end - start));
    }
}

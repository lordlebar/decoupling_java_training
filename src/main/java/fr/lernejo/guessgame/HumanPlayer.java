package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class HumanPlayer implements Player {
    Logger log = LoggerFactory.getLogger("test");
    Scanner scanner = new Scanner(System.in);

    public long askNextGuess(){
        long num = scanner.nextLong();
        scanner.nextLine();
        return num;
    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater){
            log.log("more");
        }
        else{
            log.log("less");
        }
    }
}

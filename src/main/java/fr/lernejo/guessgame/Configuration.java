package fr.lernejo.guessgame;

import java.util.Random;

public class Configuration {
    public final Player player;
    final Long numberToGuess;

    private Configuration(Player player, long numberToGuess){
        this.player = player;
        this.numberToGuess = numberToGuess;
    }

    static Configuration parseArgs(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException("Missing -interactive or -auto argument");
        }
        String mode = args[0];
        return switch (mode){
            case "-interactive" -> new Configuration(new HumanPlayer(), new Random().nextInt(101));
            case "-auto" -> {
                if (args.length < 2){
                    throw new IllegalArgumentException("In -auto mode the number to guess should be supplied");
                }
                yield new Configuration(new ComputerPlayer(), Long.parseLong(args[1]));
            }
        };
    }
}

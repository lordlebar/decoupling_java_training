package fr.lernejo.guessgame;

public class Launcher {
    public static void main(String[] args){
        Configuration configuration = Configuration.parseArgs(args);
        Simulation simulation = new Simulation(configuration.player);
        simulation.initialize(configuration.numberToGuess);
        simulation.loopUntilPlayerSucceed(100);
    }
}

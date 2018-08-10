package com.systelab.command;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.validators.PositiveInteger;
import java.util.List;


public class CommandLineApp {

    @Parameter(names = {"--help", "-help", "-h"}, description = "Show this screen", help = true, hidden = true)
    private boolean help;

    @Parameter(names = "-password", description = "Connection password", password = true)
    private String password;

    @Parameter(names = "-names", description = "Comma separated list of names")
    List<String> names;

    @Parameter(names = {"-log","-verbose"}, description = "Level of verbosity")
    private boolean verbose = true;

    @Parameter(names = "-number", description = "Number of items", validateWith = PositiveInteger.class, required=true)
    private Integer numOfItems;

    public CommandLineApp() {
    }

    public void run() {
        System.out.println("Do the job");
    }

    public static void main(String[] args) {
        CommandLineApp main = new CommandLineApp();

        final JCommander commander = JCommander.newBuilder().addObject(main).build();

        commander.setProgramName("command-line");
        commander.parse(args);

        if (main.help) commander.usage();
        else main.run();
    }
}

package com.systelab.command;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class CommandLineApp {

    @Parameter(names = "--help", help = true)
    private boolean help;

    public CommandLineApp() {
    }

    public void run() {
    }

    public static void main(String[] args) {
        CommandLineApp main = new CommandLineApp();

        final JCommander commander=JCommander.newBuilder().addObject(main).build();

        commander.setProgramName("command-line");
        commander.parse(args);

        if (main.help) commander.usage();
        else main.run();
    }
}

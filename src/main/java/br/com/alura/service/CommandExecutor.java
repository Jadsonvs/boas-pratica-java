package br.com.alura.service;

import br.com.alura.Command;

public class CommandExecutor {

    public void executeCommand(Command command) {
        command.execute();
    }

}

package com.itmo.shkuratova.coursework3;

public class LoadGame implements Command {
    private final Game game;

    public LoadGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load();

    }
}


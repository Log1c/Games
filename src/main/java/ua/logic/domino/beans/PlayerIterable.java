package main.java.ua.logic.domino.beans;

import main.java.ua.logic.domino.beans.realisation.PlayerDummy;

import java.util.Iterator;
import java.util.List;

public class PlayerIterable implements Iterable<PlayerDummy> {
    private int index;
    private List<Player> players;

    public PlayerIterable(List<Player> players, Player firstPlayer) {
        this.players = players;
        this.index = players.indexOf(firstPlayer);
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Player>() {
            @Override
            public boolean hasNext() {
                return players.size() != 0;
            }

            @Override
            public Player next() {
                if (index == players.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }

                return players.get(index);
            }
        };
    }

}

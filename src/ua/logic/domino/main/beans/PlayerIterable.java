package ua.logic.domino.main.beans;

import java.util.Iterator;
import java.util.List;

public class PlayerIterable implements Iterable<Player> {
    private int index;
    private List<Player> players;

    public PlayerIterable(List<Player> players, Player firstPlayer) {
        int indexFirstPlayer = players.indexOf(firstPlayer);
        indexFirstPlayer--;
        if (indexFirstPlayer < 0) {
            indexFirstPlayer = players.size() - 1;
        }

        this.players = players;
        this.index = indexFirstPlayer;
    }

    @Override
    public Iterator<Player> iterator() {
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

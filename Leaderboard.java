import java.util.ArrayList;
import java.util.Collections;

class Leaderboard {
    ArrayList<Player> leaderboard = new ArrayList<>();

    public void addPlayer (String name) {
        int place = this.leaderboard.size() + 1;
        this.leaderboard.add(new Player(name, 0, place));
    }

    private Player playerOfPlace(int playerPlace) {
        //Geometry proofs in a nutshell
        Player player = null;
        for (Player p : leaderboard) {
            if (p.placement == playerPlace) {
                player = p;
                break;
            }
        }
        return player;
    }

    public void sortPlacements() {
        /*old approach
        for (Player currentPlayer : this.leaderboard) {
            for (Player comparedPlayer : this.leaderboard) {
                if (currentPlayer != comparedPlayer) {
                    if (currentPlayer.placement > comparedPlayer.placement) {
                        if (currentPlayer.compareTo(comparedPlayer) == -1) {
                            currentPlayer.placement = comparedPlayer.placement;
                            comparedPlayer.placement++;
                        }
                    } else if (currentPlayer.placement < comparedPlayer.placement) {
                        if (currentPlayer.compareTo(comparedPlayer) == 1) {
                            currentPlayer.placement = comparedPlayer.placement;
                            comparedPlayer.placement--;
                        }
                    }
                }
            }
        }*/
       Collections.sort(leaderboard);
       int givenPos = 1;
        for (Player p: leaderboard) {
            p.placement = givenPos;
            givenPos++;
        }
    }

    public String toString() {
        String returned = "";
        for (Player p : leaderboard) {
            returned += p.toString();
        }
        return returned;
    }

    public Player findPlayerByName(String name) {
        Player player = null;
        for (Player P: this.leaderboard) {
            if (P.name.equals(name)) {
                player = P;
            }
        }
        return player;
    }

    public void boardChange(String playerName, String victimName, int scoreChange) {
        Player p = findPlayerByName(playerName);
        p.playerUpdate(scoreChange);
        Player v = findPlayerByName(victimName);
        v.playerUpdate(-scoreChange);
        sortPlacements();
    }
}
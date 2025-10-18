import java.util.ArrayList;

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
        }
    }

    @Override
    public String toString() {
        String returned = "";
        for (int currentPos = 1; currentPos < leaderboard.size() + 1; currentPos++) {
            for (Player p : leaderboard) {
                if (p.placement == currentPos) {
                    returned += p.toString();
                }
            }
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

}
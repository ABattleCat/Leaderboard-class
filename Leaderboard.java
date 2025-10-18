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

    public void boardChange(String playerName, int scoreChange) {
        Player player = findPlayerByName(playerName);
        player.playerUpdate(scoreChange);
        if (leaderboard.contains(player)) {
            OUTER:
            while (playerOfPlace(player.placement - 1) != null) {
                if (player.compareTo(playerOfPlace(player.placement + 1)) == 1) {
                    player.placement = playerOfPlace(player.placement - 1).placement;
                    playerOfPlace(player.placement - 1).placement--;
                } else if (player.compareTo(playerOfPlace(player.placement + 1)) == -1) {
                    if (player.compareTo(playerOfPlace(player.placement - 1)) == -1) {
                        player.placement = playerOfPlace(player.placement + 1).placement;
                        playerOfPlace(player.placement - 1).placement++; 
                    }
                }
            }
        } else {
            System.out.println("Player does not exist");
        }
    }

    @Override
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
}
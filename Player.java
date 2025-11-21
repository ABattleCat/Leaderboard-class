
import java.util.ArrayList;
import java.util.HashMap;

public class Player implements Comparable<Player> {
    public String name;
    public int score = 0;
    public int placement;
    public int health = 100;
    public int level = 1;
    public int deaths = 0;
    public int kills = 0;
    public int maxhealth = level * 20 + 80;
    public int turns = 5;
    public int startTurns = level + 5;
    public boolean turn = false;
    public boolean inCombat = false;
    public Player target = null;
    public HashMap<ArrayList, Integer> inventory = new HashMap<>();

    public Player(String Name, int Placement) {
        this.name = Name;
        this.placement = Placement;
    }

    @Override public int compareTo(Player otherPlayer) {
        if (otherPlayer.score - this.score < 0) {
            return -1;
        } else if(otherPlayer.score - this.score == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public void playerUpdate(int scoreChange) {
        if (this.score + scoreChange <= 0) {
            this.score = 0;
        } else {
            this.score += scoreChange;
        }
    }

    @Override
    public String toString() {
        return "\n" + this.placement + ": " + "deaths - " + this.deaths + " | " + "lvl." + this.level + " | " + "kills - " + this.kills + " | " + this.score + " | " + this.name;
    }

    public Weapon getWeapon(String name) {
        Item item = null;
        for (Item i : this.inventory) {
            if (i.baseName.equals(name)) {
                item = i;
                break;
            }
        }
    }
}
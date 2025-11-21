import java.util.ArrayList;
import java.util.Collections;

class Leaderboard {
    ArrayList<Player> leaderboard = new ArrayList<>();
    ArrayList<Weapon> weapons = new ArrayList<>();

    public void addPlayer (String name) {
        int place = this.leaderboard.size() + 1;
        this.leaderboard.add(new Player(name, place));
    }

    public void addWeapon(String name, int baseDamage, int turnsCost) {
        this.weapons.add(new Weapon(name, baseDamage, turnsCost));
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
            p.health++;
            givenPos++;
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

    public Player PlayerFoundByName(String name) {
        Player player = null;
        for (Player P: this.leaderboard) {
            if (P.name.equals(name)) {
                player = P;
            }
        }
        return player;
    }

    public Weapon WeaponFoundByName(String name) {
        Weapon weapon = null;
        for (Weapon w: this.weapons) {
            if (w.baseName.equals(name)) {
                weapon = w;
            }
        }
        return weapon;
    }

    public void kill(String playerName, String victimName) {
        Player p = PlayerFoundByName(playerName);
        p.playerUpdate(100);
        p.kills++;
        p.health += 30;
        p.inCombat = false;
        Player v = PlayerFoundByName(victimName);
        v.playerUpdate(-100);
        v.deaths++;
        v.health = 100;
        v.inCombat = false;
        sortPlacements();
    }

    public void pointsCrate(String playerName, int crateID) {
        PlayerFoundByName(playerName).playerUpdate(crateID * 10);
        sortPlacements();
    }

    public void healthCrate(String playerName, int crateID) {
        Player p = PlayerFoundByName(playerName);
        int reward = crateID * 10;
        if (p.health + reward > 100) {
            int extraHP = p.health + reward - 100;
            p.health = 100;
            p.playerUpdate(extraHP * 2);
        } else {
            p.health += reward;
        }
        sortPlacements();
    }
    
    public void lvlUp(String playerName) {
        PlayerFoundByName(playerName).level++;
    }

    public void attack(String playerName, String victimName, String weapon) {
        Player p = PlayerFoundByName(playerName);
        Player v = PlayerFoundByName(victimName);
        p.health += 1;
        //v.health -= 
    }
    
    public void enterCombat(String attacker, String victim) {
        PlayerFoundByName(attacker).inCombat = true;
        PlayerFoundByName(attacker).target = PlayerFoundByName(victim);
        PlayerFoundByName(victim).inCombat = true;
        PlayerFoundByName(victim).target = PlayerFoundByName(attacker);
    }
}
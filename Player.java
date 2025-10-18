public class Player implements Comparable<Player> {
    @SuppressWarnings("unused")
    public String name;
    public int score;
    @SuppressWarnings("unused")
    public int placement;

    public Player(String Name, int Score, int Placement) {
        name = Name;
        score = Score;
        placement = Placement;
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
        return "\n" + this.placement + ": " + this.score + " | " + this.name;
    }
}
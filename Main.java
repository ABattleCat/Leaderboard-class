

class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Leaderboard L = new Leaderboard();
        L.addPlayer("Bob");
        L.addPlayer("Bobby");
        L.addPlayer("Bobbobby");
        System.out.println(L.toString());
        System.out.println(L.toString());
    }

}
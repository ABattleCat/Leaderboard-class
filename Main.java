

class Main {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Leaderboard L = new Leaderboard();
        L.addPlayer("Bob");
        L.addPlayer("Bobby");
        L.addPlayer("Bobbobby");
        System.out.println(L.toString());
        L.boardChange("Bob", "Bobbobby", 150);
        System.out.println(L.toString());
        L.boardChange("Bobbobby", "Bob", 100);
        System.out.println(L.toString());
        L.boardChange("Bobby", "Bobbobby", 75);
        System.out.println(L.toString());
    }

}
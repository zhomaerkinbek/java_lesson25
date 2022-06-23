public enum Game {
    ROCK(1, "Камень"),
    PAPER(2, "Бумага"),
    SCISSORS(3, "Ножницы");

    private int value;
    private String name;

    Game(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

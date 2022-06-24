public enum Game {
    ROCK(1, "Камень"),
    PAPER(2, "Бумага"),
    SCISSORS(3, "Ножницы"),
    SPOCK(4,"Спок"),
    LIZARD(5, "Ящерица");

    private final int value;
    private final String name;

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

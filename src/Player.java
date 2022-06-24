import java.util.Random;
import java.util.Scanner;

public class Player {
    private int win;
    private int draw;
    private int lose;
    private double percentWins;
    private Game status;
    private boolean gameMode = true;

    public boolean isGameMode() {
        return gameMode;
    }

    public void setGameMode(boolean gameMode) {
        this.gameMode = gameMode;
    }

    public Player() {
    }

    public int getWin() {
        return win;
    }

    public void setWin() {
        this.win++;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw() {
        this.draw++;
    }

    public int getLose() {
        return lose;
    }

    public void setLose() {
        this.lose++;
    }

    public double getPercentWins() {
        return percentWins;
    }

    public void setPercentWins() {
        percentWins = (getWin() * 100) / (getWin() + getDraw() + getLose());
    }

    public Game getStatus() {
        return status;
    }

    public void setStatus(Game status) {
        this.status = status;
    }

    public void getFinger(){
            int number;
            while (true) {
                try {
                    number = checkNumber();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }
        setFingers(number);
    }

    public void setFingers(int number){
        switch (number) {
            case 1 -> setStatus(Game.ROCK);
            case 2 -> setStatus(Game.PAPER);
            case 3 -> setStatus(Game.SCISSORS);
            case 4 -> setStatus(Game.SPOCK);
            case 5 -> setStatus(Game.LIZARD);
            default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
        }
    }
    public void getRandomFinger(){
        int n;
        Random rnd = new Random();
        if(isGameMode()){
            n = 3;
        } else {
            n = 5;
        }
        int number = rnd.nextInt(n);
        setFingers(number + 1);
    }

    private int checkNumber() throws NoFingerException {
        int n;
        if(isGameMode()){
            n = 3;
            System.out.print("Введите номер какую руку хотите выбрасить (1. Камень, 2. Бумага, 3. Ножницы): ");
        } else {
            n = 5;
            System.out.print("Введите номер какую руку хотите выбрасить (1. Камень, 2. Бумага, 3. Ножницы, 4. Спок, 5. Ящерица): ");
        }
        int number;
        Scanner sc = new Scanner(System.in);
        try {
            number = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ожидается ввод цифры!");
            try{
                number = checkNumber();
            } catch (Exception ex) {
                System.out.println(e.getMessage());
                number = checkNumber();
            }
        }
        if(number < 1 | number > n){
            throw new NoFingerException("Такой руки нету! Введите еще раз");
        } else {
            return number;
        }
    }


    @Override
    public String toString() {
        String header = "┌──────────┬─────────────┬─────────┬─────────────┬─────────────────┐\n";
        String names = String.format("│  %6s  │  %9s  │  %5s  │  %9s  │  %13s  │\n", "ПОБЕДА", "ПОРАЖЕНИЕ", "НИЧЬЯ", "ВСЕГО ИГР", "ПРОЦЕНТ ПОБЕД");
        String line = "├──────────┼─────────────┼─────────┼─────────────┼─────────────────┤\n";
        String text = String.format("│  %6s  │  %9s  │  %5s  │  %9s  │  %13s  │\n", win, lose, draw, (win+lose+draw), percentWins);
        String footer = "└──────────┴─────────────┴─────────┴─────────────┴─────────────────┘";
        return header + names + line + text + footer;
    }

}

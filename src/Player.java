import java.util.Random;
import java.util.Scanner;

public class Player {
    private int win;
    private int draw;
    private int lose;
    private double percentWins;
    private Game status;

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
        if(number == 1){
            setStatus(Game.ROCK);
        } else if (number == 2) {
            setStatus(Game.PAPER);
        } else{
            setStatus(Game.SCISSORS);
        }
    }
    public void getRandomFinger(){
        Random rnd = new Random();
        int number = rnd.nextInt(3);
        if(number == 0){
            setStatus(Game.ROCK);
        } else if (number == 1) {
            setStatus(Game.PAPER);
        } else{
            setStatus(Game.SCISSORS);
        }
    }

    private int checkNumber() throws NoFingerException {
        System.out.print("Введите номер какую руку хотите выбрасить (1. Камень, 2. Бумага, 3. Ножницы!): ");
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
        if(number < 1 | number > 3){
            throw new NoFingerException("Такой руки нету! Введите еще раз");
        } else {
            return number;
        }
    }


    @Override
    public String toString() {
        return "Player{" +
                "win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                ", percentWins=" + percentWins +
                '}';
    }

}

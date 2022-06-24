import java.util.Scanner;

public class Main {
    static Player user = new Player();
    static Player comp = new Player();
    public static void main(String[] args){
        run();
    }

    public static void run(){
        chooseMode();
        for(int i = 0; i < 6; i++){
            user.getFinger();
            comp.getRandomFinger();
            printFinger(user.getStatus().getName(), comp.getStatus().getName());
            checkResult(user.getStatus().getValue(), comp.getStatus().getValue());
        }
        printResultInfo(user, "Пользователь");
        printResultInfo(comp, "Компьютер");
        checkWinner();

    }

    public static void chooseMode(){
        Scanner sc = new Scanner(System.in);
        int chooseNumber = 1;

        System.out.print("Выберите сложность игры (1. Обычный, 2. Усложненный): ");
        try {
            chooseNumber = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ожидается ввод цифры!");
            chooseMode();
        }
        if (chooseNumber < 1 | chooseNumber > 2){
            System.out.println("Неправильный номер команды!");
            chooseMode();
        }
        if(chooseNumber == 2){
            user.setGameMode(false);
            comp.setGameMode(false);
        }
    }
    public static void printResultInfo(Player player, String name){
        player.setPercentWins();
        System.out.printf("-----------------------%s------------------------\n", name);
        System.out.println(player);
    }
    public static void printFinger(String user, String comp){
        System.out.println("Пользователь ------ Компьютер");
        System.out.println("   " + user + "      VS    " + comp);
    }

    public static void checkWinner(){
        if(user.getWin() > comp.getWin()){
            System.out.println("\n----------------------Пользователь выиграл!----------------------");
        } else if (user.getWin() == comp.getWin()){
            System.out.println("\n-------------------------------Ничья!----------------------------");
        } else {
            System.out.println("\n------------------------Компьютер выиграл!-----------------------");
        }
    }
    public static void checkResult(int userValue, int compValue){
        switch (userValue) {
            case 1 -> {
                switch (compValue) {
                    case 1 -> {
                        user.setDraw();
                        comp.setDraw();
                    }
                    case 2, 4 -> {
                        comp.setWin();
                        user.setLose();
                    }
                    case 3, 5 -> {
                        user.setWin();
                        comp.setLose();
                    }
                    default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
                }
            }
            case 2 -> {
                switch (compValue) {
                    case 2 -> {
                        user.setDraw();
                        comp.setDraw();
                    }
                    case 1, 4 -> {
                        user.setWin();
                        comp.setLose();
                    }
                    case 3, 5 -> {

                        comp.setWin();
                        user.setLose();
                    }
                    default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
                }
            }
            case 3 -> {
                switch (compValue) {
                    case 3 -> {
                        user.setDraw();
                        comp.setDraw();
                    }
                    case 2, 5 -> {
                        user.setWin();
                        comp.setLose();
                    }
                    case 1, 4 -> {
                        comp.setWin();
                        user.setLose();
                    }
                    default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
                }
            }
            case 4 -> {
                switch (compValue) {
                    case 4 -> {
                        user.setDraw();
                        comp.setDraw();
                    }
                    case 1, 3 -> {
                        user.setWin();
                        comp.setLose();
                    }
                    case 2, 5 -> {
                        comp.setWin();
                        user.setLose();
                    }
                    default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
                }
            }
            case 5 -> {
                switch (compValue) {
                    case 5 -> {
                        user.setDraw();
                        comp.setDraw();
                    }
                    case 2, 4 -> {
                        user.setWin();
                        comp.setLose();
                    }
                    case 1, 3 -> {
                        comp.setWin();
                        user.setLose();
                    }
                    default -> throw new NoFingerException("Такой руки нету! Введите еще раз");
                }
            }
        }
    }
}

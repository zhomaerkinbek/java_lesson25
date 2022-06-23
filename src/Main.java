public class Main {
    public static void main(String[] args){
        Player user = new Player();
        Player comp = new Player();
        for(int i = 0; i < 6; i++){
            user.getFinger();
            comp.getRandomFinger();
            System.out.println(user.getStatus().getName() + " против " + comp.getStatus().getName());
            checkWin(user, comp);
        }
        System.out.println(user);
        System.out.println(comp);
    }

    public static void checkWin(Player user, Player comp){
        if(user.getStatus().getValue() < comp.getStatus().getValue() & Math.abs(comp.getStatus().getValue() - user.getStatus().getValue()) < 2){
            comp.setWin();
            user.setLose();
        } else if(user.getStatus().getValue() < comp.getStatus().getValue() & Math.abs(comp.getStatus().getValue() - user.getStatus().getValue()) == 2){
            user.setWin();
            comp.setLose();
        } else if (user.getStatus().getValue() == comp.getStatus().getValue()) {
            user.setDraw();
            comp.setDraw();
        }else if(user.getStatus().getValue() > comp.getStatus().getValue() & Math.abs(comp.getStatus().getValue() - user.getStatus().getValue()) == 2){
            comp.setWin();
            user.setLose();
        } else {
            user.setWin();
            comp.setLose();
        }
        user.setPercentWins();
        comp.setPercentWins();
    }
}

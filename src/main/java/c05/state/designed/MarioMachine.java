package c05.state.designed;

public class MarioMachine {
    private IMario mario;
    private int score;

    public MarioMachine() {
        this.mario = SmallMario.getInstance();
        this.score = 0;
    }

    public IMario getMario() {
        return mario;
    }

    public void setMario(IMario mario) {
        this.mario = mario;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void obtainMushroom() {
        this.mario.obtainMushroom(this);
    }

    public void obtainCape() {
        this.mario.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.mario.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.mario.meetMonster(this);
    }
}

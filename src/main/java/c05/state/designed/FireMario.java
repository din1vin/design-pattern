package c05.state.designed;


import c05.state.caseif.State;

public class FireMario implements IMario{

    private final static FireMario instance  = new FireMario();

    private FireMario(){}

    public static FireMario getInstance(){
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushroom(MarioMachine marioMachine) {
        // do nothing
    }

    @Override
    public void obtainFireFlower(MarioMachine marioMachine) {
        // do nothing
    }

    @Override
    public void obtainCape(MarioMachine marioMachine) {
        // do nothing
    }

    @Override
    public void meetMonster(MarioMachine marioMachine) {
        marioMachine.setMario(SmallMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() - 300);
    }
}

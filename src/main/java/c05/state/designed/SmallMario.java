package c05.state.designed;


import c05.state.caseif.State;

public class SmallMario implements IMario {

    private final static SmallMario instance = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushroom(MarioMachine marioMachine) {
        marioMachine.setMario(SuperMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 100);
    }

    @Override
    public void obtainFireFlower(MarioMachine marioMachine) {
        marioMachine.setMario(FireMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 300);

    }

    @Override
    public void obtainCape(MarioMachine marioMachine) {
        marioMachine.setMario(CapeMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() + 200);
    }

    @Override
    public void meetMonster(MarioMachine marioMachine) {
        // do nothing
    }
}

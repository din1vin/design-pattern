package c05.state.designed;


import c05.state.caseif.State;

public class SuperMario implements IMario {

    private final static SuperMario instance = new SuperMario();

    private SuperMario() {
    }

    public static SuperMario getInstance() {
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
        marioMachine.setMario(SmallMario.getInstance());
        marioMachine.setScore(marioMachine.getScore() - 100);
    }
}

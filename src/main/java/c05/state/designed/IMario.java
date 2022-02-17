package c05.state.designed;

import c05.state.caseif.State;

public interface IMario {
    State getName();
    void obtainMushroom(MarioMachine marioMachine);
    void obtainFireFlower(MarioMachine marioMachine);
    void obtainCape(MarioMachine marioMachine);
    void meetMonster(MarioMachine marioMachine);
}

package c05.state.caseif;

public class MarioMachine {
    private int score;
    private State currentState;

    public MarioMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom(){
        if(currentState.equals(State.SMALL)){
            this.score += 100;
            this.currentState = State.SUPER;
        }
    }


    public void obtainCape(){
        if(currentState.equals(State.SMALL)||currentState.equals(State.SUPER)){
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    public void obtainFireFlower(){
        if(currentState.equals(State.SMALL)||currentState.equals(State.SUPER)){
            this.currentState = State.FIRE;
            this.score += 200;
        }
    }

    public void meetMonster(){
        if(currentState.equals(State.SUPER)){
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }

        if(currentState.equals(State.FIRE)){
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }

        if(currentState.equals(State.CAPE)){
            this.currentState = State.SMALL;
            this.score -= 200;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}

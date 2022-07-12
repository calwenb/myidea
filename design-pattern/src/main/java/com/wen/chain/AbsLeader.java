package com.wen.chain;

public abstract class AbsLeader {
    private AbsLeader nextLeader;

    public AbsLeader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(AbsLeader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public abstract void leaveRequest(int day);
}

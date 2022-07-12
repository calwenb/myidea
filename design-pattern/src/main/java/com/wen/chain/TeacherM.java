package com.wen.chain;

public class TeacherM extends AbsLeader {
    @Override
    public void leaveRequest(int day) {
        if (day <= 15) {
            System.out.println("中老师处理请假");
        } else {
            AbsLeader nextLeader = getNextLeader();
            if (nextLeader != null) {
                nextLeader.leaveRequest(day);
            } else {
                System.out.println("无人问津");
            }
        }
    }
}

package com.wen.chain;

public class TeacherL extends AbsLeader {
    @Override
    public void leaveRequest(int day) {
        if (day <= 30) {
            System.out.println("大老师处理请假");
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

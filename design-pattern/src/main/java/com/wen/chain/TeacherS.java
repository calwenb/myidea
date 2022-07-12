package com.wen.chain;

public class TeacherS extends AbsLeader {
    @Override
    public void leaveRequest(int day) {
        if (day <= 7) {
            System.out.println("小老师处理请假");
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

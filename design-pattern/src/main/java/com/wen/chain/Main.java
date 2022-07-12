package com.wen.chain;

/**
 * 责任链模式
 * 应用场景：
 * 1.
 */
public class Main {
    public static void main(String[] args) {

        TeacherS teacherS = new TeacherS();
        TeacherM teacherM = new TeacherM();
        TeacherL teacherL = new TeacherL();
        teacherS.setNextLeader(teacherM);
        teacherM.setNextLeader(teacherL);
        teacherS.leaveRequest(25);

    }

}

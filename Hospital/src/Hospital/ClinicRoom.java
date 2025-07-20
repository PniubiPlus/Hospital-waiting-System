package Hospital;

import LinkedListQueue.LinkedListQueue;

public class ClinicRoom
{
    Department department;       //有必要吗？在这里   有
    String roomNumber;
    private LinkedListQueue patientQueue;   //每个诊室维护一个队列

    //generated

    public ClinicRoom(Department department, String roomNumber, LinkedListQueue patientQueue) {
        this.department = department;
        this.roomNumber = roomNumber;
        this.patientQueue = patientQueue;
    }

    public ClinicRoom() {
//        this.department = new Department(); // 初始化 department 字段  https://www.doubao.com/thread/wa044faf644b647da
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LinkedListQueue getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(LinkedListQueue patientQueue) {
        this.patientQueue = patientQueue;
    }
}

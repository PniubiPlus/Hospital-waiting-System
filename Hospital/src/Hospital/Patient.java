package Hospital;

public class Patient
{
    public static final int URGENT = 1;
    public static final int ORDINARY= 0;

    String ID;
    String name;
    boolean urgency;
    Department department;
    ClinicRoom clinicRoom;

    //--------------------------------------------------
    //无参构造器
    public Patient() {
    }
    //--------------------------------------------------
    //有参构造器
    public Patient(String name, String ID, boolean urgency, Department department, ClinicRoom room) {
        this.name = name;
        this.ID = ID;
        this.urgency = urgency;
        this.department = department;
        this.clinicRoom = room;
    }
    //-----------------------------------------
    //getter&setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ClinicRoom getClinicRoom() {
        return clinicRoom;
    }

    public void setClinicRoom(ClinicRoom clinicRoom) {
        this.clinicRoom = clinicRoom;
    }
}

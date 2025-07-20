package Hospital;

import java.util.List;

//https://www.doubao.com/thread/we5d5235f6d519be8
public class Department
{
    String departmentName;
    List<ClinicRoom> clinicRooms;

    //generated

    public Department(String departmentName, List<ClinicRoom> clinicRooms) {
        this.departmentName = departmentName;
        this.clinicRooms = clinicRooms;
    }

    public Department() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<ClinicRoom> getClinicRooms() {
        return clinicRooms;
    }

    public void setClinicRooms(List<ClinicRoom> clinicRooms) {
        this.clinicRooms = clinicRooms;
    }
}

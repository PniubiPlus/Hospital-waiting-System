package Hospital;

import LinkedListQueue.QueueNode;
import LinkedListQueue.LinkedListQueue;
import LinkedListQueue.basicOperationsOfLinkedListQueue;    //想用记得导包

import javax.swing.*;
import java.util.*;


public class Solution
{
    Scanner scanner = new Scanner(System.in);
//    LinkedListQueue linkedListQueue =new LinkedListQueue();      不应该在这里初始化
    basicOperationsOfLinkedListQueue BOoLLQ = new basicOperationsOfLinkedListQueue();

    List<Department> departments = new ArrayList<>();
//    List<LinkedListQueue> queues = new ArrayList<>(); //https://www.doubao.com/thread/wa6701e50a4fe583d
    Map<String,LinkedListQueue> queueMap = new HashMap<>();     // https://www.doubao.com/thread/w41e296d4d9209d33

    //首页展示
    public void showHomePage()
    {
        System.out.println("（1）候诊");
        System.out.println("（2）就诊");
        System.out.println("（3）查看队列情况");
        System.out.println("（4）查看自己排队状况");
        System.out.println("（5）下班");
        System.out.println("（6）上班");
    }
    //1.候诊
    Department aimDepartment = new Department();
    ClinicRoom aimClinicRoom = new ClinicRoom();
    public void waitingConsultation()
    {
        Patient patient = new Patient();
        QueueNode<Patient> patientQueueNode = new QueueNode<Patient>(patient,null);
        basicOperationsOfLinkedListQueue BOoLLQ = new basicOperationsOfLinkedListQueue();

        System.out.println("请选择您要挂号的科室");
        int i = 0;
        for (Department department : departments) {
            i++;
            System.out.println("(" + i + ")" + department.departmentName);
        }
        int aim1 = scanner.nextInt();
//        Department aimDepartment = new Department();
        aimDepartment = new Department();
//        Department aimDepartment = null; // 修改：初始化为 null
        int j = 0;
        for (Department department : departments) {
            j++;
                if (aim1 == j)
            {
                aimDepartment = department;
                System.out.println("您选择了：(" + j + ")" + department.departmentName);
                patient.setDepartment(aimDepartment);
                break;
            }
        }
        System.out.println("请选择您要挂号的诊室");
        int k = 0;
        for (ClinicRoom clinicRoom : aimDepartment.clinicRooms) {
            k++;
            System.out.println("(" + k + ")" + clinicRoom.getRoomNumber());
        }
        int aim2 = scanner.nextInt();
        int l = 0;
//        ClinicRoom aimClinicRoom = new ClinicRoom();
        aimClinicRoom = new ClinicRoom();
//        ClinicRoom aimClinicRoom = null; // 修改：初始
//        化为 null
        for (ClinicRoom clinicRoom : aimDepartment.clinicRooms) {
            l++;
            if (l == aim2)
            {
                aimClinicRoom = clinicRoom;
                System.out.println("您选择了：(" + l + ")" + clinicRoom.getRoomNumber());
                patient.setClinicRoom(clinicRoom); // 修改：确保 patient.clinicRoom 被正确赋值
                break;
            }
        }

        System.out.println("请输入您的病历号：");
        patient.ID= scanner.next();
        System.out.println("请输入您的姓名");
        patient.name = scanner.next();

        while (true)
        {
            System.out.println("请输入您的紧急程度：");
            System.out.println("(1):紧急");
            System.out.println("(2):正常");
            int input = scanner.nextInt();
            if (input == 1) {
                patient.urgency = true;
                BOoLLQ.urgentEnQueue(getQueue(patient.clinicRoom),patientQueueNode); //如何将病人作为QueueNode入队  https://www.doubao.com/thread/wedd9b5bbb16313ad
                break;
            } else if (input == 2) {
                patient.urgency = false;
                BOoLLQ.enQueue(getQueue(patient.clinicRoom),patientQueueNode);
                break;
            } else {
                System.out.println("您的输入有误，请重新输入");
                return;
            }
        }
        LinkedListQueue nowPatientQueue = aimClinicRoom.getPatientQueue();
        System.out.println("====您已经预约成功====");
    }

    //2.就诊
    public void toBeConsultation(LinkedListQueue queue)
    {
        System.out.println("姓名为：" + BOoLLQ.deQueue(queue).name + "的就诊操作已完成，请前往诊室就诊");
    }


    //3.查看队列情况
    public void showQueueStatus(LinkedListQueue queue)
    {
        if (BOoLLQ.isEmpty(queue))
        {
            System.out.println("此队列为空");
            return;
        }
        System.out.println("此候诊队列还有" + (queue.getQueSize()) + "个人");
    }

    //4.查看自己排队
//    Patient patient = new Patient();
//    public void checkSelfStatus(LinkedListQueue queue)          //每个诊室一个队列咋弄https://www.doubao.com/thread/waf16bd143487eafe
//    {
//        System.out.println("请输入您的病历号： ");
//        patient.ID = scanner.next();
//        QueueNode<Patient> node;
//        int num = 0;
//        Patient foundPatient = null;
//        for (node = queue.getFront();node != null; node = node.getNext())//https://www.doubao.com/thread/w8498e39bd6e9a8a4
//        {
//            if (node.getData().ID.equals(patient.ID))
//            {
//                patient = node.getData();
//                break;
//            }
//            num++;
//        }
//        System.out.println("在您前面还有" + num + "个人");
//        System.out.println("请对照您的姓名是否正确");
//        System.out.println("姓名：" + patient.name);
//    }
    // 4.查看自己排队               https://www.doubao.com/thread/w68321026da278d50
    public void checkSelfStatus(LinkedListQueue queue) {
        System.out.println("请输入您的病历号： ");
        String inputID = scanner.next();
        QueueNode<Patient> node;
        int num = 0;
        Patient foundPatient = null;
        for (node = queue.getFront(); node != null; node = node.getNext()) {
            if (node.getData().getID().equals(inputID)) {
                foundPatient = node.getData();
                break;
            }
            num++;
        }
        if (foundPatient != null) {
            System.out.println("在您前面还有" + num + "个人");
            System.out.println("请对照您的姓名是否正确");
            System.out.println("姓名：" + foundPatient.getName());
        } else {
            System.out.println("未找到该病历号对应的病人信息。");
        }
    }


    //5.下班
    public void END()
    {
        System.out.println("==============今日工作时间已结束==============");
        return;
    }

    //6.上班
    public void BEGGIN()
    {
//        LinkedListQueue queue = new LinkedListQueue();  //不应该初始化一个队列而是应该每个诊室都初始化，最后会有多个队列
        iniAllQueue();
        System.out.println("==============今日工作开始==============");
    }

    //7.初始化各个诊室的队列                  https://www.doubao.com/thread/we27439087d319164
    public void iniAllQueue ()
    {
        List<Department> departments = new ArrayList<>();

         //https://www.doubao.com/thread/w15cec14ce07b4724
        List<ClinicRoom> orthpedicRooms = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String roomNumber = String.format("%03d",i);
            ClinicRoom room = new ClinicRoom(new Department("骨科",null),roomNumber, new LinkedListQueue());
            System.out.println("骨科队列初始化完成...");
            orthpedicRooms.add(room);
            System.out.println("骨科诊室添加完成...");
        }
        Department orthopedicDepartment = new Department("骨科",orthpedicRooms);
        System.out.println("骨科科室初始化完成...");
        departments.add(orthopedicDepartment);
        System.out.println("骨科科室添加完成...");

        List<ClinicRoom> neurologyRooms = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String roomNumber = String.format("%03d",i);
            ClinicRoom room = new ClinicRoom(new Department("神经科",null),roomNumber,new LinkedListQueue());
            System.out.println("神经科队列初始化完成...");
            neurologyRooms.add(room);
            System.out.println("神经科诊室添加完成...");
        }
        Department neurologyDepartment = new Department("神经科", neurologyRooms);
        System.out.println("神经科科室初始化完成...");
        departments.add(neurologyDepartment);
        System.out.println("神经科科室添加完成...");

        List<ClinicRoom> surgicalRooms = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String roomNumber = String.format("%03d", i);
            ClinicRoom room = new ClinicRoom(new Department("外科", null), roomNumber, new LinkedListQueue());
            System.out.println("外科队列初始化完成...");
            surgicalRooms.add(room);
            System.out.println("外科诊室添加完成...");
        }
        Department surgicalDepartment = new Department("外科", surgicalRooms);
        System.out.println("外科科室初始化完成...");
        departments.add(surgicalDepartment);
        System.out.println("外科科室添加完成...");

        this.departments = departments;//https://www.doubao.com/thread/w32751dfb3c19773e

        //以下代码只做了存储各科中各科室的队列作用，但前面并没有初始化对应的队列，只是在下面循环中简单初始化，所以删去垃圾部分，在这上面重新补写
        //https://www.doubao.com/thread/w21e33b240170b3ac
        for (Department department : departments) {
            List<ClinicRoom> clinicRooms = new ArrayList<>();
            for (ClinicRoom clinicRoom : clinicRooms) {
                LinkedListQueue queue = new LinkedListQueue();
                String key = department + "_" + clinicRooms;
                queueMap.put(key,getQueue(clinicRoom));//如何根据科室和诊室号的组合存储到queueMap中//queueMap.entrySet(departments+) 就别用entryset了 https://www.doubao.com/thread/w5a17b4dc037ea80e
                clinicRoom.setPatientQueue(queue);//https://www.doubao.com/thread/w1b69eea3b704e866
            }
        }


    }

    // 获得每个诊室的队列     不会
    public LinkedListQueue getQueue(ClinicRoom clinicRoom)
    {
        if (clinicRoom == null) {
            throw new IllegalArgumentException("参数 clinicRoom 不能为 null");
        }

        for (Department department : departments) {
            for (ClinicRoom room : department.getClinicRooms()) {
                if (room.getRoomNumber().equals(clinicRoom.getRoomNumber()) && room.getDepartment().getDepartmentName().equals(clinicRoom.getDepartment().getDepartmentName()))
                {
                    return room.getPatientQueue();
                }
            }
        }
        
        throw new IllegalArgumentException("未找到对应诊室的队列");
    }

    //找诊室
    public ClinicRoom findClinicRoomByInfo(String departmentName, String roomNumber) {
        for (Department department : departments) {
            if (department.departmentName.equals(departmentName)) {
                for (ClinicRoom room : department.getClinicRooms()) {
                    if (room.getRoomNumber().equals(roomNumber)) {
                        return room;
                    }
                }
            }
        }
        throw new IllegalArgumentException("未找到匹配的诊室：" + departmentName + " - " + roomNumber);
    }

}

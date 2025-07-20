package Hospital;

import LinkedListQueue.LinkedListQueue;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Patient nowPatient = new Patient();
//        LinkedListQueue.QueueNode<Patient> nowPatientQueueNode = new QueueNode<>(null, null);


        System.out.println("========首页========");
        boolean onWork = false;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            solution.showHomePage();
            System.out.println("请选择您要进行的下一步操作：");
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    if (onWork == false)
                    {
                        System.out.println("对不起，非工作时间，请工作时间再来");
                        return;
                    }
                    solution.waitingConsultation();
                    break;
                case 2:
                    if (onWork == false)
                    {
                        System.out.println("对不起，非工作时间，请工作时间再来");
                        return;
                    }
//                    ClinicRoom clinicRoom = solution.findClinicRoomByInfo(nowPatient.getDepartment().departmentName,nowPatient.getClinicRoom().roomNumber);
                    ClinicRoom clinicRoom = solution.findClinicRoomByInfo(solution.aimDepartment.departmentName,solution.aimClinicRoom.roomNumber);
                    solution.toBeConsultation(solution.getQueue(clinicRoom));//👆nowPatient.getClinicRoom().getPatientQueue()//solution.getQueue(nowPatient.g
                    // etClinicRoom())
                    break;
                case 3:
                    if (onWork == false)
                    {
                        System.out.println("对不起，非工作时间，请工作时间再来");
                        return;
                    }
                    ClinicRoom clinicRoom1 = solution.findClinicRoomByInfo(solution.aimDepartment.departmentName,solution.aimClinicRoom.roomNumber);
                    solution.showQueueStatus((solution.getQueue(clinicRoom1)));
                    break;
                case 4:
                    if (onWork == false)
                    {
                        System.out.println("对不起，非工作时间，请工作时间再来");
                        return;
                    }
                    ClinicRoom clinicRoom2 = solution.findClinicRoomByInfo(solution.aimDepartment.departmentName,solution.aimClinicRoom.roomNumber);
                    solution.checkSelfStatus(solution.getQueue(clinicRoom2));
                    break;
                case 5:
                    onWork = false;
                    solution.END();
                    return;
                case 6:
                    onWork = true;
                    solution.BEGGIN();
                    break;
            }

        }

    }
}



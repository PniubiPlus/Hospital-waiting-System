package LinkedListQueue;           //变量与功能分开https://www.doubao.com/thread/wb4af131a96af60b6

import Hospital.Patient;

public class  QueueNode<T>         //泛型的使用https://www.doubao.com/thread/w58062f700997a859
{
    //基本数据                      https://www.doubao.com/thread/wbce2507ac155260d
//    Patient patient;
    T data;                //用这个而非上面那个，保证完全泛型
    QueueNode<T> next;             //为什么只用指向下一个节点，上一个不用https://www.doubao.com/thread/w3274e21ef03185cc


    //-----------------------------------------------------------------------------------
    public QueueNode(T data, QueueNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public QueueNode() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
    //    //------------------------------
//    //无参构造器
//    public QueueNode() {
//    }
//    //有参构造器                  // https://www.doubao.com/thread/w52b8f3633931570c  //冲突  https://www.doubao.com/thread/w770484365e091a8a
//
//    public QueueNode(Patient patient, QueueNode<T> next) {
//        this.patient = patient;
//        this.next = null;// 显式置为null而非next，避免默认值的不确定性
//    }
//
//
//    //getter&setter
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
//
//    public QueueNode<T> getNext() {
//        return next;
//    }
//
//    public void setNext(QueueNode<T> next) {
//        this.next = next;
//    }
}
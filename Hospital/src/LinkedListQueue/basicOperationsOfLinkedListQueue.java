package LinkedListQueue;

import Hospital.Patient;


//方法类
public class basicOperationsOfLinkedListQueue
{
    //初始化      https://www.doubao.com/thread/w9d640aa6e220d020

    //获取队列长度
    public int QueueLength(LinkedListQueue queue)
    {
        return queue.getQueSize();
    }

    //判断队列是否为空
//    public boolean isEmpty(LinkedListQueue queue)
//    {
//        return queue.getQueSize() == 0;
//    }
    public boolean isEmpty(LinkedListQueue queue) {
        if (queue == null) {
            return true; // 或者抛出异常，取决于业务需求
        }
        return queue.getFront() == null; // 直接检查头节点是否为空
    }

    //打印队列是否为空
    public void printIsEmpty(LinkedListQueue queue)
    {
        if (isEmpty(queue))
        {
            System.out.println("队列为空");
        }
        else
        {
            System.out.println("队列非空");
        }
    }

    //入队
    public void enQueue(LinkedListQueue queue,QueueNode newQueueNode)  //https://www.doubao.com/thread/w7c37f1ecb572b2d5
    {
        if (queue == null) {
            throw new IllegalArgumentException("入参 queue 不能为 null，请检查调用处传入的队列对象");
        }
// 验证队列对象有效性放在方法入口处，避免在调用后续queue的方法时出现空指针异常
        if (newQueueNode == null) {
            throw new IllegalArgumentException("入参 newQueueNode 不能为 null");
        }

        //https://www.doubao.com/thread/w94d94affd0c89062
        if (isEmpty(queue) == true)
        {
            queue. setFront(newQueueNode);
            queue.setRear(newQueueNode);
        }
        else
        {
            queue.getRear().setNext(newQueueNode);
            queue.setRear(newQueueNode);              //https://www.doubao.com/thread/w6b3a25bd3e1557c5
        }
        queue.setQueSize(queue.getQueSize()+1);
    }


    //出队
    public Patient deQueue(LinkedListQueue queue)         //https://www.doubao.com/thread/w46827b72513cfe34
    {

        if (isEmpty(queue))
        {
            System.out.println("队列为空，无法出队");
            return null;
        }
        else if (queue.getQueSize() == 1)
        {
//            Patient patient = queue.getFront().patient;
            Patient patient = (Patient) queue.getFront().getData();
            queue.setFront(null);
            queue.setRear(null);
            queue.setQueSize(queue.getQueSize()-1);
            return patient;
        }
        else if (queue.getQueSize() == 2)
        {
//            Patient patient = queue.getFront().patient;
            Patient patient = (Patient) queue.getFront().getData();
            queue.setFront(queue.getRear());
            queue.setQueSize(queue.getQueSize()-1);
            return patient;
        }
        else
        {
//            Patient patient = queue.getFront().patient;
            Patient patient = (Patient) queue.getFront().getData();
            queue.setFront(queue.getFront().next);
            queue.setQueSize(queue.getQueSize()-1);
            return patient;
        }
    }

    //访问队首元素
    public void peekFrontElement(LinkedListQueue queue)
    {
        System.out.println(queue.getFront());
    }

    //情况紧急，直接加入队首
    public void urgentEnQueue(LinkedListQueue queue,QueueNode newQueueNode)
    {
        if (isEmpty(queue) == true)
        {
            queue. setFront(newQueueNode);
            queue.setRear(newQueueNode);
        }
        else
        {
            QueueNode preFrontQueueNode = queue.getFront();
            queue.setFront(newQueueNode);
            newQueueNode.setNext(preFrontQueueNode);
        }
        queue.setQueSize(queue.getQueSize()+1);
    }
}
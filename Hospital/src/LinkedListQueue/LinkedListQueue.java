package LinkedListQueue;

public class LinkedListQueue
{
    private QueueNode front;
    private QueueNode rear;
    private int queSize;

    //----------------------------------------
    //无参构造器
    public LinkedListQueue() {
    }
    //有参构造器
    public LinkedListQueue(QueueNode front, QueueNode rear, int queSize) {
        this.front = front;
        this.rear = rear;
        this.queSize = queSize;
    }
    //getter&setter
    public QueueNode getFront() {
        return front;
    }

    public void setFront(QueueNode front) {
        this.front = front;
    }

    public int getQueSize() {
        return queSize;
    }

    public void setQueSize(int queSize) {
        this.queSize = queSize;
    }

    public QueueNode getRear() {
        return rear;
    }

    public void setRear(QueueNode rear) {
        this.rear = rear;
    }
}

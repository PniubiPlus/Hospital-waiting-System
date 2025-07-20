package LinkedListQueue;
//队列基本操作测试类
public class Test
{
    public static void main(String[] args)
    {
        LinkedListQueue queueTest = new LinkedListQueue();
        basicOperationsOfLinkedListQueue BOoLLQ = new basicOperationsOfLinkedListQueue();
        //测试1：获取队列长度
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));//分析看笔记
        //测试2：判断队列是否为空
        BOoLLQ.printIsEmpty(queueTest);
        //测试3：入队
        QueueNode nodeTest1 = new QueueNode();    //记得不要像只写QueueNode nodeTest1;没有初始化
        BOoLLQ.enQueue(queueTest,nodeTest1);
        //入队后再次获取长度并判断是否为空
        System.out.println("------------------第一次入队后-----------------------");
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        //再次入队
        QueueNode nodeTest2 = new QueueNode();
        BOoLLQ.enQueue(queueTest,nodeTest2);
        System.out.println("------------------第二次入队后-----------------------");
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        //再入一次队
        QueueNode nodeTest3 = new QueueNode();
        BOoLLQ.enQueue(queueTest,nodeTest2);
        System.out.println("------------------第三次入队后-----------------------");
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        //测试4：出队
        System.out.println("---------------第一次出队----------------");
        BOoLLQ.deQueue(queueTest);
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        System.out.println("---------------第二次出队----------------");
        BOoLLQ.deQueue(queueTest);
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        System.out.println("---------------第三次出队----------------");
        BOoLLQ.deQueue(queueTest);
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        System.out.println("---------------第四次出队----------------");
        BOoLLQ.deQueue(queueTest);
        System.out.println("队列长度为： " + BOoLLQ.QueueLength(queueTest));
        BOoLLQ.printIsEmpty(queueTest);
        //再入一次队用来检验peekFrontElement
        BOoLLQ.enQueue(queueTest,nodeTest2);
        //测试5：访问队首元素
        BOoLLQ.peekFrontElement(queueTest);
        //测试6：情况紧急，直接加入队首
        //先入两次队，每入一次看一下队首
        System.out.println("----------------------普通入队第一次  访问队首👇-----------------");
        QueueNode nodeTest4 = new QueueNode();
        BOoLLQ.enQueue(queueTest,nodeTest4);
        BOoLLQ.peekFrontElement(queueTest);
        System.out.println("----------------------普通入队第二次  访问队首👇-----------------");
        QueueNode nodeTest5 = new QueueNode();
        BOoLLQ.enQueue(queueTest,nodeTest5);
        BOoLLQ.peekFrontElement(queueTest);
        System.out.println("----------------------紧急入队第一次  访问队首👇-----------------");
        QueueNode nodeTest6 = new QueueNode();
        BOoLLQ.urgentEnQueue(queueTest,nodeTest6);
        BOoLLQ.peekFrontElement(queueTest);
    }
}
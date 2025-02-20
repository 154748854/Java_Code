class MyBlockingQueue {
    private String[] data = new String[1000];
    // 队列的起始位置
    private int head = 0;
    // 队列的结束位置的下一个位置
    private int tail = 0;
    // 队列中有效元素的个数
    private int size = 0;

    // 提供核心方法,入队列和出队列
    public void put(String elem) {
        if (size == data.length) {
            // 队列满了
            // 普通队列满了就直接return
            return;
        }
        data[tail++] = elem;
        // 如果tail自增之后到达了数组末尾,要让他回到开头
        if (tail == data.length) {
            tail = 0;
        }
        size++;
    }

    public String take() {
        if (size == 0) {
            // 对于普通队列来说,直接返回就行了
            return null;
        }
        // 队列不空,就可以把head位置的元素删除掉并进行返回
        String ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }
}
public class Demo24 {
}

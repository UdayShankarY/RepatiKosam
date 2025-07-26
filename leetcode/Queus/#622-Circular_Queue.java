387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

    Input: s = "leetcode"

    Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

    Input: s = "loveleetcode"

    Output: 2

    Example 3:

    Input: s = "aabb"

    Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.



code : 
    class MyCircularQueue {
        int front;
        int rear;
        int arr[];
        int size;
        public MyCircularQueue(int k) {
            rear = -1;
            front = -1;
            arr = new int[k];
            size = k;
        }
        
        public boolean enQueue(int value) {
            if(isFull()){
                return false;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = value;
            return true;
        }
        
        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }
            if(front == rear){
                front = rear = -1;
            }
            else{
                front = (front+1)%size;
            
            }
            return true;
        }
        
        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return arr[front];
        }
        
        public int Rear() {
            if(isEmpty()){
                return -1;
            }
            return arr[rear];
        }
        
        public boolean isEmpty() {
            if(front == -1 && rear == -1){
                return true;
            }
            return false;
        }
        
        public boolean isFull() {
            if((rear+1)%size == front){
                return true;
            }
            return false;
        }
    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
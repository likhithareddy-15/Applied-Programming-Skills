class MyCircularDeque {
    int[] arr;
    int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        arr = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (size == capacity) return false;
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        if (size == 0) rear = front;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == capacity) return false;
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        if (size == 0) front = rear;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) return -1;
        return arr[front];
    }

    public int getRear() {
        if (size == 0) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
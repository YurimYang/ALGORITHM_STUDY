package part6.list.v02_v09;

public class MyLinkedList<T> implements Ilist<T> {
    private  int size;
    private Node head;
    public MyLinkedList(){
        this.size = 0;
        this.head = new Node(null);

    }
    @Override
    public void add(T t) {
        Node curr = this.head;
        while (curr.next!= null){
            //다음에 추가할 게 존재할 때
            curr = curr.next; // 마지막 노드를 가리킴
        }
        Node node = new Node(t);
        curr.next = node; //마지막 노드에 추가함
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        Node prev = this.head;
        Node curr = prev.next;

        int i = 0;
        while(i++<index){
            prev = prev.next;
            curr = curr.next;
            //한 칸씩 이동
        }

        Node node = new Node(t, curr);
        prev.next = node;
        this.size++;

    }

    @Override
    public void clear() {
        //모두 비워주는 작업
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        Node prev = this.head;
        Node curr = prev.next;
        while(curr!=null){
            if (curr.data.equals(t)){
                prev.next = curr.next;
                curr.next = null;
                this.size--;
                return true;
            }
            prev = prev.next;
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node prev = this.head;
        Node curr = prev.next;

        int i = 0;
        while (i++ < index) {
            prev = prev.next;
            curr = curr.next;
        }

        prev.next = curr.next;
        curr.next = null;
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        Node curr = this.head.next;
        int i = 0;
        while(i++ < index){
            curr = curr.next;
        }
        return curr.data;

    }

    @Override
    public int indexOf(T t) {
        Node curr = this.head.next;
        int index = 0;
        while(curr!= null){
            if(t.equals(curr.data)){
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmptry() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node curr =this.head.next;
        while(curr != null){
            if (t.equals(curr.data)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node{
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}

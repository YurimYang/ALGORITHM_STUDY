package part6.list.v02_v09;


public class MyDoubleLinkedList<T> implements Ilist<T> {
    private Node head;
    private Node tail;
    private int size;


    public MyDoubleLinkedList(){
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }


    @Override
    public void add(T t) {
        Node last = this.tail.prev;
        Node node = new Node(t, last, this.tail);
        //Node(T data, Node prev, Node next)
        last.next = node;
        this.tail.prev = node;
        //next와 prev 연결이 구체적이어야함
        this.size++;

    }

    @Override
    public void insert(int index, T t) {
        //삽입하는 데이터를 기준으로 이전노드와 이후 노드의 연결이 중요
        Node prev = null;
        Node curr = null;

        int i= 0;
        if ( index <this.size / 2){
            prev = this.head;
            curr = this.head.next;

            while(i++< index){
                prev = prev.next;
                curr = curr.next;
            }

//            Node node = new Node(t, prev, curr);
//            curr.prev = node;
//            prev.next = node;
        }else{
            curr = this.tail;
            prev = this.tail.prev;
            while(i++< (this.size - index)){
                curr = curr.prev;
                prev = prev.prev;
            }

//            Node node = new Node(t,prev, curr);
//            curr.prev = node;
//            prev.next = node;
        }
        //중복 코드 정리
        Node node = new Node(t,prev, curr);
        curr.prev = node;
        prev.next = node;
        this.size++;

    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        Node prev = null;
        Node curr = null;
        Node next = null;

        int i = 0;
        if(index< this.size / 2){
            prev = this.head;
            curr = this.head.next;
            while(i++<index){
                prev = prev.next;
                curr = curr.next;
            }
            //curr앞에 있는 노드와 뒤에 있는 노드를 연결해줘야함
            prev.next = curr.next;
            curr.next.prev = prev;
            //사이 연결을 끊어줌
            curr.next = null;
            curr.prev = null;
        }else{
            //tail에서 역으로 찾아가는 경우
            curr = this.tail.prev;
            next = this.tail;
            while(i++<this.size-index-1){
                //실제 데이터가 있는경우부터!
                //점차 왼쪽으로 이동
                next = next.prev;
                curr = curr.prev;
            }
            next.prev = curr.prev;
            curr.prev.next = next;
            curr.next = null;
            curr.prev = null;

        }
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        //index를 들어갈 때 조건 !
        if(index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node curr = null;
        if(index < this.size / 2) { //index가 head에서 더 가까우면
            curr = this.head.next;
            while(i++<index){
                curr = curr.next; //앞에서부터 타고 들어감
            }
        }else{ //index가 tail에 더 가까우면
            curr = this.tail.prev;
            while(i++<this.size - index -1){
                //index가 역순으로 가기 때문에!
                curr = curr.prev; //뒤에서부터 타고 들어감
            }
        }
        return curr.data;
    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public boolean isEmptry() {
        return false;
    }

    @Override
    public boolean contains(T t) { // 앞 뒤 모든 방향으로 탐색을 함 ! (O(N) -> O(N/2)
        Node curr = this.head.next;
        while(curr!= null){
            if (curr.data !=null & curr.data.equals(t)){
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
        Node prev;
        Node next;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}

package part6.list.v02_v09;

import java.util.Arrays;

public class MyArrayList<T> implements Ilist<T> {
    private static final int DEFAULT_SIZE = 50;

    private int size;
    private T[] elements;

    public MyArrayList(){
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];
    }
    @Override
    public void add(T t) {
        if(this.size == this.elements.length){
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        this.elements[this.size] = t;
        this.size +=1;
        //size가 늘어남에 따라 한 칸씩 add함
    }

    @Override
    public void insert(int index, T t) {
        if(this.size == this.elements.length){
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }

        for (int i = index; i< this.size; i++){
            this.elements[i+1] = this.elements[i];
        }
        this.elements[index] = t;
        this.size++;

    }

    @Override
    public void clear() {
        this.size = 0;
        this.elements = (T[]) new Object[DEFAULT_SIZE];

    }

    @Override
    public boolean delete(T t) {
        for (int i = 0; i < this.size; i++){
            if(this.elements[i].equals((t))){
                for(int j = i; j<this.size-1;j++){
                    this.elements[j] = this.elements[j+1];
                }
                this.size--;
                //일치한건 삭제 o = true
                return true;
            }
        }
        //일치하지 않을 경우 삭제 x = false
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if(index<0 || index > this.size-1){
            return false;
        }
        for(int i = index; i< this.size-1; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        if(index<0 || index > this.size-1){
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public int indexOf(T t) {
        for (int i =0; i < this.size; i++){
            if (this.elements[i].equals(t)){
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean isEmptry() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i< this.size; i++){
            if (this.elements[i].equals(t)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}

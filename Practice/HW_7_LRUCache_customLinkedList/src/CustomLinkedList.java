public class CustomLinkedList <T> {

    private int size = 0;
    private T value;
    private CustomLinkedList first;
    private CustomLinkedList last;


    public CustomLinkedList() {
        this.first = null;
    }

    public void add(T item) {
        CustomLinkedList<T> newNode = new CustomLinkedList<>();
        CustomLinkedList<T> first = this.first;

        if (first == null) {

        } else {

        }


        size++;
    }

    public <T>

//    public <T> T get(int index) {
//
//    }
//
//    public <T> T remove(int index) {
//    }

    public int find(T item) {
        return 0;
    }



//    void add(T item)
//    T get(int index)
//    T remove(int index)
//    int find(T item)
}

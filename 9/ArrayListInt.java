public class ArrayListInt {
    private int max;
    private int[] array;
    private int used;

    public ArrayListInt() {
        this.max = 5;
        this.array = new int[max];
        this.used = 0;
    }

    public void add(int value) {
        if(this.used < 5) {
            this.array[used] = value;
            used++;
        } else {
            System.out.println("Limit exceeded.");
            System.out.println(value + " is not inserted.");
        }
    }

    public int size() {
        return this.used;
    }

    public int get(int index) {
        return this.array[index];
    }

    public void print() {
        for (int i = 0; i < this.size(); i ++) {
            System.out.println(this.array[i]);
        }
    }
} 

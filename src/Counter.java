public class Counter {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Counter(long value) {
        this.value = value;
    }

    public Counter() {
    }

    public Counter(Counter counter) {
        this.value = counter.getValue();
    }

    public void decrease(){
        this.setValue(this.getValue()-1);
    }
    public void increase(){
        this.setValue(this.getValue()+1);
    }

    @Override
    public String toString() {
        return "Counter{" +
                "value=" + value +
                '}';
    }

    public static void main (String [] args){
        Counter counter1 = new Counter(1);
        Counter counter2 = new Counter(10);
        Counter counter3 = new Counter(counter2);
        counter2.increase();
        counter1.decrease();
        counter3.decrease();
        counter3.decrease();
        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter3);
    }
}

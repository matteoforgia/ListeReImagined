public class Slot<T> implements Comparable<Slot<T>> {
    protected T valore;
    public Slot next;
    public Slot prev;
    final private Id id;
    private int idCounter = 0;

    public Slot(T valore, Id id) {
        this.id = id;
        this.valore = valore;
    }

    public Slot(Id id) {
        this.id = id;
    }

    public Slot(T valore) {
        this.id = new Id(idCounter + 1);
        idCounter = idCounter + 1;
        this.valore = valore;
    }

    public T getValore() {
        return valore;
    }
    
    public void setValore(T valore) {
        this.valore = valore;
    }

    public Id getId() {
        return id;
    }

    public Slot getNext() {
        return next;
    }
    
    public void setNext(Slot next) {
        this.next = next;
    }

    public Slot getPrev() {
        return prev;
    }

    public void setPrev(Slot prev) {
        this.prev = prev;
    }

    @Override
    public int compareTo(Slot<T> other) {
        return Integer.compare(this.id.getValue(), other.id.getValue());
    }

    public String toString() {
        return "Slot{" +
                "valore=" + valore +
                ", id=" + id.getValue() +
                '}';
    }

    public void addNext(Slot<T> next) {
        this.next = next;
        next.prev = this;
    }

    public void addPrev(Slot<T> prev) {
        this.prev = prev;
        prev.next = this;
    }

    public void removeNext() {
        if (this.next != null) {
            this.next.prev = null;
            this.next = null;
        }
    }

    public void removePrev() {
        if (this.prev != null) {
            this.prev.next = null;
            this.prev = null;
        }
    }

    public void sort(){
        if (this.next != null) {
            this.next.sort();
            if (this.compareTo(this.next) > 0) {
                T tempValore = this.valore;
                this.valore = (T) this.next.valore;
                this.next.valore = tempValore;
                this.sort();
            }
        }
    }
}

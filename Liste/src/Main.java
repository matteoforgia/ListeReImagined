public class Main {
    public static void main(String[] args) throws Exception {
        Slot<Integer> slot1 = new Slot<Integer>(1, new Id(1));
        Slot<Integer> slot2 = new Slot<Integer>(2, new Id(2));
        Slot<Integer> slot3 = new Slot<Integer>(3, new Id(3));

        slot1.addNext(slot2);
        slot2.addNext(slot3);

        System.out.println("Before sorting:");
        System.out.println(slot1);
        System.out.println(slot2);
        System.out.println(slot3);

        slot1.sort();

        System.out.println("After sorting:");
        System.out.println(slot1);
        System.out.println(slot2);
        System.out.println(slot3);
    }
}

package io.github.frozzik1.taskmanager.lab;

public class MemoryLab {

    public static void main(String[] args) {
        // Experiment 1: integer overflow
        int maxInt = Integer.MAX_VALUE;
        System.out.println("MAX_VALUE + 1 = " + (maxInt + 1));

        // Experiment 2: floating-point precision
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));

        // Experiment 3: division and narrowing cast
        System.out.println("7 / 2 = " + (7 / 2));
        System.out.println("7 / 2.0 = " + (7 / 2.0));
        System.out.println("(byte) 130 = " + (byte) 130);

        // Experiment 4: String pool
        String a = "task";
        String b = "task";
        String c = new String("task");
        System.out.println("a == b: " + (a == b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println("a == c.intern(): " + (a == c.intern()));

        // Experiment 5: Integer cache
        Integer x1 = 127, x2 = 127;
        Integer y1 = 128, y2 = 128;
        System.out.println("127: " + (x1 == x2));
        System.out.println("128: " + (y1 == y2));
    }
}
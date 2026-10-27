package io.github.frozzik1.taskmanager.lab;

public class MethodsLab {

    private static int depth = 0;

    static void changePrimitive(int x) {
        x = 100;
    }

    static void changeArrayElement(int[] arr) {
        arr[0] = 100;
    }

    static void reassignArray(int[] arr) {
        arr = new int[]{999};
    }

    static void changeString(String s) {
        s = s + " changed";
    }

    static void recurse() {
        depth++;
        recurse();
    }

    public static void main(String[] args) {
        int number = 1;
        changePrimitive(number);
        System.out.println("1) number = " + number);

        int[] numbers = {1, 2, 3};
        changeArrayElement(numbers);
        System.out.println("2) numbers[0] = " + numbers[0]);

        reassignArray(numbers);
        System.out.println("3) numbers[0] = " + numbers[0]);

        String text = "task";
        changeString(text);
        System.out.println("4) text = " + text);

        try {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("5) stack overflow at depth " + depth);
        }
    }
}
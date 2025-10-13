package com.ericbouchut.immutability;

public class ThreadSafetyExample {
    public static final String SHARED_STRING = "Programming";

    public static void main(String... args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                // Safe operation - no synchronization needed, toUpperCase() because returns a new String but does not change SHARED_STRING
                String upperCase = SHARED_STRING.toUpperCase();

                System.out.println(Thread.currentThread().getName() + ": \"" + SHARED_STRING + "\".toUpperCase()=\"" + upperCase + "\"");
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Warning this dirty methid has a side-effect because it stores the passed-in String to the String Pool.

     * @param string the String to check
     * @return true if <code>string</code> is in the String Pool
     */
    public static boolean isInPool(String string) {
        return string == string.intern();
    }
}

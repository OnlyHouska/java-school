package org.delta;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        try {
            app.run();
        } catch (ArithmeticException e) {
            System.out.println("Pocitas blbe, " + e.getMessage());
        } catch (Throwable thr) {
            System.out.println("Neco se ti pokazilo");
        }
    }
}

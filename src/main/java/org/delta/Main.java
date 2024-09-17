package org.delta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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

package modsChecker;

public class Main {
    public static void main(String[] args) {
        Checker ch = new Checker();
        ch.CheckModsDir();
        System.out.println("-----------------------------------------------------------------------------");
        ch.CheckExtension();
    }
}
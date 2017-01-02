package 单例模式;

public class Singelon {
    static class HeldSingelon {
        private static Singelon instance = new Singelon();
    }

    public Singelon getSingelon() {
        return HeldSingelon.instance;
    }

    public static void main(String[] args) {

    }

}

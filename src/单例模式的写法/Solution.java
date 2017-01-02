package 单例模式的写法;



/**
 * Created by h on 16-12-22.
 */
class Singleton {
    static int val = 1;
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("this is SingletonHolder Class");
        }
    }
    private Singleton (){}
    public static final Singleton getInstance() {

        return SingletonHolder.INSTANCE;
    }
}
public class Solution{
    public static void main(String[] args){
        System.out.println(Singleton.val);
    }
}
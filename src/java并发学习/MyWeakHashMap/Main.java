package java并发学习.MyWeakHashMap;

import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        whm.put(new String("语文"), new String("60"));
        whm.put(new String("数学"), new String("70"));
        whm.put("java", new String("100"));
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        System.out.println(whm);
        String s1 = "java";
        String s2 = new String("java");
        String s3 = new String("java");
        System.out.println(s2 == s3);
        System.out.println(s1 == s2);
    }
}

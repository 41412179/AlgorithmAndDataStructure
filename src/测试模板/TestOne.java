package 测试模板;

/**
 * Created by h on 16-12-28.
 */
public class TestOne {
    private static TestOne ourInstance = new TestOne();

    public static TestOne getInstance() {
        return ourInstance;
    }

    private TestOne() {
    }
}

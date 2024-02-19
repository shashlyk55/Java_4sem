package by.belstu.it.slesarev;

public class MyFunction {
    public MyFunction() {
    }
    public int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getValue(String s){
        String repeat = getRepeat(s);
        return "Hello from first project!" + repeat;
    }

    private static String getRepeat(String s) {
        String repeat = s.repeat(3);
        return repeat;
    }

    final int fi = 1;
    static final int sfi = 2;
    public static final int psfi = 3;
}

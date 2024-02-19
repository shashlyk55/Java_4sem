package by.belstu.it.slesarev.basejava;

import java.nio.charset.StandardCharsets;

import static java.lang.Math.*;

/*
@author me
@version 1.0
 */
public class JavaTest {
/*
@return void
@param String[] args
 */
    public static void main(String[] args) {
        /*
        @value 'q'
         */
        char c = 'q';
        int i = -30;
        short sh = 32;
        byte by = 21;
        long l = 7328;
        boolean b = false;

        System.out.println("str"+i);
        System.out.println("str"+c);
        System.out.println("str"+18.3);

        System.out.println(by + i);
        System.out.println(82.6 + l);
        System.out.println(i + 2147483647);

        //static int sint;
        boolean b1 = true && false;
        boolean b2 = true^true;
        //b1 = true + false;

        long num1 = 9_223_372_036_854_775_807L;
        long num2 = 0x7fff_ffff_fffL;

        char c1 = 'a';
        char c2 = '\u0061';
        char c3 = 97;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c1+c2+c3);

        System.out.println(3.45%2.4);
        System.out.println(1.0%0.0);
        System.out.println(0.0%0.0);
        System.out.println(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        System.out.println(PI);
        System.out.println(E);
        System.out.println(round(PI));
        System.out.println(round(E));
        System.out.println(min(PI, E));
        System.out.println(random());

        /*Создать объекты разных классов оболочек (Boolean,
Character, Integer, Byte, Short, Long, Double)*/
        Boolean boolVal = false;
        Character chVal = 's';
        Integer intVal = 534;
        Byte byteVal = 124;
        Short shortVal = 164;
        Long longVal = 1832L;
        Double doubVal = 523.56;

        /*выполните на ними арифметические, логические и битовые
операторы (, >>>, >>, ~, &, *, -, +) – выборочно*/
        System.out.println(byteVal>>>3);
        System.out.println(longVal<<2);
        System.out.println(~intVal);
        System.out.println(shortVal&longVal);

        //веведите MIN_VALUE и MAX_VALUE для Long и Double
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        //выполнить упарковку и распаковку для типов Integer и Byte
        Integer boxedInt = 43;
        int unboxedInt = boxedInt;

        Byte boxedByte = 12;
        byte unboxedByte = boxedByte;

        /*вызовите для Integer методы : parseInt ; toHexString ; compare ;
toString ; bitCount ; isNaN …*/
        System.out.println(Integer.parseInt("235"));
        System.out.println(Integer.toHexString(123));
        System.out.println(Integer.compare(55,45));
        System.out.println(Integer.toString(intVal));
        System.out.println(Integer.bitCount(6));

        //Выполните преобразование числа типа String (String s34 = "2345";) к int , используя: конструктор, valueOf, parse….
        String s34 = "2345";
        System.out.println(Integer.parseInt(s34));

        /*переводите строку в массив байтов и обратно из массива байтов в
строку*/
        byte[] bytes = s34.getBytes();
        for(byte val : bytes)
            System.out.print(val + " ");
        System.out.println();

        String myStr = new String(bytes);
        System.out.println(myStr);

        //преобразуйте строку в логический тип 2-мя способами.
        System.out.println(Boolean.parseBoolean(s34));
        boolVal = new Boolean("true");
        System.out.println(boolVal);

        //определите два строки (String) с одинаковыми инициализаторами.


        /*Выполите ==, equals, compareTo. В чем разница, поясните
результат. Одной из строк присвойте null. Повторите все тир
варианта сравнения.*/


        /*для произвольной строки выполните функции split, contains,
hashCode, indexOf, length, replace.*/


        //Проверьте какая из форм объявлений многомерного массива допустима:
        char[][] ch1;
        char[] ch2[];
        char ch3[][];

        /*для с1 c1 = new char[3][];
сделайте так, чтобы каждая последущая строка содержала на один
элемент больше чем предыдущая. Выведите c1.length; c1[0].length и т.д.*/
        ch1 = new char[3][];
        ch1[0] = new char[1];
        ch1[1] = new char[2];
        ch1[2] = new char[3];

        System.out.println(ch1.length);
        for(char[] val : ch1)
            System.out.print(val.length + " ");

        //проинициализируйте с2 и с3
        ch2 = new char[][]{{'v', 'n'}, {'b','i'}};
        ch3 = new char[][]{{'t','m','j'},{'y','o'}};
        boolean comRez = ch3 == ch2;
        ch2 = ch3;

        //выведите один из массивов совращенным циклом (foreach)
        System.out.println();
        for(var ch : ch2){
            System.out.println(ch);
        }

        //System.out.println(ch2[5]);

        WrapperString wString = new WrapperString();
        wString.setStr("qwertyytrewq");
        wString.replace('w','x');
        System.out.println(wString.getStr());

        WrapperString wStr = new WrapperString(){
            @Override
            public void replace(char oldchar,char newchar){
                super.setStr(super.getStr().replace(oldchar, newchar));
            }
            public void delete(char ch){
                this.setStr(super.getStr().replace(String.valueOf(ch),""));
            }
        };
        wStr.setStr("zxcasdssaaa");

        System.out.println(wStr.getStr());


    }
}

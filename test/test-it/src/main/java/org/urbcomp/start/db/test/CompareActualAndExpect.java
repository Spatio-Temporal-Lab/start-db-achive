package org.urbcomp.start.db.test;

public class CompareActualAndExpect {

    public static void compareData(String actualValue, String expectValue) throws Exception {
        // todo 比较实际返回值或者实际抛出的异常是否与预期一致, 不一致就抛出异常
        if (true) {

            System.out.println("正确返回结果");
        }else {
            throw new Exception("返回结果有误");
        }
    }

}

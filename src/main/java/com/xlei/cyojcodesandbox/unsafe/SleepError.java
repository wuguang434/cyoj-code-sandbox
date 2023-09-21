package com.xlei.cyojcodesandbox.unsafe;
//****包名一定要去掉****
/**
 * 无限睡眠(阻塞程序)
 */
public class SleepError {
    public static void main(String[] args) throws InterruptedException {
        long ONE_HOUR = 60 * 60 * 1000l;
        Thread.sleep(ONE_HOUR);
        System.out.println("睡够了");

    }
}

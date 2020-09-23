package com.lfs.common.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.util.Random;

public class RandomUtils {
    public static int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static Random random = new Random();

    public RandomUtils() {
    }

    public static String randomNumber(int length) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            int index = random.nextInt(10);
            builder.append(nums[index]);
        }

        return builder.toString();
    }
}

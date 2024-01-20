package com.vtxlab.mastercode;

import java.util.ArrayList;
import java.util.List;

public class Question2 {

    public List<Integer> duplicateCounts(int[] nums1, int[] nums2, int[] nums3) {
        //return new ArrayList<>();
        ArrayList<Integer> dict = new ArrayList<>();
        int maxNum = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > maxNum)
            maxNum = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > maxNum)
            maxNum = nums2[i];
        }

        for (int i = 0; i < nums3.length; i++) {
            if (nums3[i] > maxNum)
            maxNum = nums3[i];
        }

        int[] stat = new int[maxNum + 1];
        for (int i = 0; i < nums1.length; i++) {
            stat[nums1[i]] = 1;
        }

        int[] stat2 = new int[maxNum + 1];
        for (int i = 0; i < nums2.length; i++) {
            if (stat[nums2[i]] >= 1 && stat2[nums2[i]] < 1) {
                stat[nums2[i]] += 1;
            } else if (stat[nums2[i]] == 0) {
                stat[nums2[i]] = 1;
            }
            stat2[nums2[i]] = 1;
        }
        int[] stat3 = new int[maxNum + 1];
        for (int i = 0; i < nums3.length; i++) {
            if (stat[nums3[i]] >= 1 && stat3[nums3[i]] < 1) {
            //if (stat[nums3[i]] == 2 || stat[nums3[i]] == 3) {
                stat[nums3[i]] += 1;
            } else if (stat[nums3[i]] == 0) {
                stat[nums3[i]] = 1;
            }
            stat3[nums3[i]] = 1;
        }
            for (int i = 0; i < stat.length; i++) {
            if (stat[i] > 1) {
                dict.add(i);
            }
        }
        return dict;
    }

}

package com.vtxlab.mastercode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * Copyright 2024 Venturenix LAB. All Rights Reserved.
 * 
 * @author vincent.lau
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MastercodeTests {

  private static int totalScore = 0;

  private static int q1Score = 0;
  private static int q1TCPassed = 0;

  private static int q2Score = 0;
  private static int q2TCPassed = 0;

  private static int q3Score = 0;
  private static int q3TCPassed = 0;

  // private static int q1Bonus = 0;
  // private static boolean q1Runtimelevel1 = false;

  // private static int q2Bonus = 0;
  // private static boolean q2Runtimelevel1 = false;

  // private static int q3Bonus = 0;
  // private static boolean q3Runtimelevel1 = false;
  // private static boolean q3Runtimelevel2 = false;
  // private static boolean q3Runtimelevel3 = false;
  // private static boolean q3Runtimelevel4 = false;

  private Question1 question1;
  private Question2 question2;
  private Question3 question3;

  @BeforeAll
  void init() {
    question1 = new Question1();
    question2 = new Question2();
    question3 = new Question3();
  }

  @AfterAll
  void score() {
    System.out.println("Question 1 Test Cases Passed=" + q1TCPassed);
    System.out.println("Question 2 Test Cases Passed=" + q2TCPassed);
    System.out.println("Question 3 Test Cases Passed=" + q3TCPassed);
    if (q3TCPassed == 15)
      q3Score = 5;
    if (q2TCPassed == 5)
      q2Score = 4;
    if (q1TCPassed == 9)
      q1Score = 3;

    // Question 1: 3 marks (base)
    // Question 2: 4 marks (base)
    // Question 3: 5 marks (base)
    totalScore = q1Score + q2Score + q3Score;

    System.out.println("Q1 Basic Score=" + q1Score);
    System.out.println("Q2 Basic Score=" + q2Score);
    System.out.println("Q3 Basic Score=" + q3Score);
    System.out.println("Total Score=" + totalScore);
  }

  /**
   * Functional Testing for Question 1.
   */
  @Test
  void question1Case1() {
    double tax =
        question1.computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 10);
    assertThat(tax, is(2.65000));
    q1TCPassed++;
  }

  @Test
  void question1Case2() {
    double tax =
        question1.computeTax(new int[][] {{3, 50}, {7, 10}, {12, 25}}, 12);
    assertThat(tax, is(3.15000));
    q1TCPassed++;
  }

  @Test
  void question1Case3() {
    double tax =
        question1.computeTax(new int[][] {{1, 0}, {4, 25}, {5, 50}}, 2);
    assertThat(tax, is(0.25000));
    q1TCPassed++;
  }

  @Test
  void question1Case4() {
    double tax = question1.computeTax(new int[][] {{2, 50}}, 0);
    assertThat(tax, is(0.00000));
    q1TCPassed++;
  }

  @Test
  void question1Case5() {
    double tax =
        question1.computeTax(new int[][] {{2, 50}, {3, 99}, {4, 99}}, 3);
    assertThat(tax, is(1.99000));
    q1TCPassed++;
  }

  @Test
  void question1Case6() {
    double tax = question1.computeTax(new int[][] {{1, 0}}, 0);
    assertThat(tax, is(0.00000));
    q1TCPassed++;
  }

  @Test
  void question1Case7() {
    double tax = question1.computeTax(
        new int[][] {{1, 5}, {10, 10}, {100, 20}, {1000, 30}}, 1000);
    assertThat(tax, is(288.95000));
    q1TCPassed++;
  }

  @Test
  void question1Case8() {
    double tax = question1.computeTax(new int[][] {{100, 2}}, 99);
    assertThat(tax, is(1.98000));
    q1TCPassed++;
  }

  @Test
  void question1Case9() {
    int[][] brackets = new int[100][2];
    for (int i = 0; i < 99; i++) {
      brackets[i] = new int[] {(i + 1) * 10, i + 1};
    }
    brackets[99][0] = 1000;
    brackets[99][1] = 1;

    double tax = question1.computeTax(brackets, 500);
    assertThat(tax, is(127.5));
    q1TCPassed++;
  }

  /**
   * Functional Testing for Question 2.
   */
  @Test
  void question2Case1() {
    List<Integer> integers = question2.duplicateCounts(new int[] {1, 1, 3, 2},
        new int[] {2, 3}, new int[] {3});
    assertThat(integers, containsInAnyOrder(2, 3));
    assertThat(integers, not(contains(Integer.valueOf(1))));
    assertThat(integers, hasSize(2));
    q2TCPassed++;
  }

  @Test
  void question2Case2() {
    List<Integer> integers = question2.duplicateCounts(new int[] {3, 1},
        new int[] {2, 3}, new int[] {1, 2});
    assertThat(integers, containsInAnyOrder(1, 2, 3));
    assertThat(integers, not(contains(Integer.valueOf(1))));
    assertThat(integers, hasSize(3));
    q2TCPassed++;
  }

  @Test
  void question2Case3() {
    List<Integer> integers = question2.duplicateCounts(new int[] {1, 2, 2},
        new int[] {4, 3, 3}, new int[] {5});
    assertThat(integers, is(empty()));
    assertThat(integers, hasSize(0));
    q2TCPassed++;
  }

  @Test
  void question2Case4() {
    List<Integer> integers = question2.duplicateCounts(
        new int[] {1, 2, 100, 100, 100, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 100, 100, 100, 100,
            100, 100, 100, 100, 100},
        new int[] {4, 3, 3, 99, 100, 1, 2, 3, 4, 5, 6, 7, 65, 8, 9, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25},
        new int[] {5, 6, 7, 8, 4, 34, 55, 66, 77, 88, 99, 100});

    assertThat(integers, is(not(empty())));
    assertThat(integers, hasSize(27));
    q2TCPassed++;
  }

  @Test
  void question2Case5() {
    int[] nums1 = new int[100];
    int[] nums2 = new int[100];
    int[] nums3 = new int[100];

    for (int i = 0; i < 100; i++) {
      nums1[i] = i + 1;
    }
    int j = 0;
    for (int i = 100; i > 0; i--) {
      nums2[j++] = i;
    }
    Arrays.fill(nums3, 100);

    List<Integer> integers = question2.duplicateCounts(nums1, nums2, nums3);
    assertTrue(!integers.isEmpty());
    assertEquals(100, integers.size());
    q2TCPassed++;
  }

  /**
   * Functional Testing for Question 3.
   */
  @Test
  void question3Case1() {
    int intValue = question3.vowelCounts("aeiouu");
    assertThat(intValue, is(2));
    q3TCPassed++;
  }

  @Test
  void question3Case2() {
    int intValue = question3.vowelCounts("unicornarihan");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case3() {
    int intValue = question3.vowelCounts("cuaieuouac");
    assertThat(intValue, is(7));
    q3TCPassed++;
  }

  @Test
  void question3Case4() {
    int intValue = question3.vowelCounts("cuaieuuouc");
    assertThat(intValue, is(4));
    q3TCPassed++;
  }

  @Test
  void question3Case5() {
    int intValue = question3.vowelCounts("cuaieuxouc");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  public void question3Case6() {
    int intValue = question3.vowelCounts("caeoip");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case7() {
    int intValue = question3.vowelCounts("aeioxu");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case8() {
    int intValue = question3.vowelCounts("a");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case9() {
    int intValue = question3.vowelCounts("ae");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case10() {
    int intValue = question3.vowelCounts("aei");
    assertThat(intValue, is(0));
    q3TCPassed++;
  }

  @Test
  void question3Case11() {
    int intValue = question3.vowelCounts("uieaou");
    assertThat(intValue, is(3));
    q3TCPassed++;
  }

  @Test
  void question3Case12() {
    int intValue = question3.vowelCounts("aeiou");
    assertThat(intValue, is(1));
    q3TCPassed++;
  }

  @Test
  void question3Case13() {
    int intValue = question3.vowelCounts(
        "aieuouaieuouaieuouaieuouaieuouaieuouaieuouazieuouaieuouaieuouaieuouaieuouaieuouaieuoua");
    assertThat(intValue, is(1469));
    q3TCPassed++;
  }

  @Test
  void question3Case14() {
    int intValue = question3.vowelCounts(
        "aeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiouaeiou");
    assertThat(intValue, is(4656));
    q3TCPassed++;
  }

  @Test
  void question3Case15() {
    int intValue = question3.vowelCounts(
        "abcdeabcdeabcdeabcdeabcdeabcdeabcdeaeiouabacdeabcdabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde");
    assertThat(intValue, is(5));
    q3TCPassed++;
  }

  // Non-functional Requirement: Run Time Test (Time Complexity) refers to HiddenRunTime.java.
  // Run time result will be recorded by single machine/ server for final ranking.

  // If you still want to try the Run Time Test. Try the following command:
  // mvn clean test -Dtest=HiddenRunTime

}

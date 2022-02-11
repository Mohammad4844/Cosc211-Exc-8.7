package pkg;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Scanner;

public class FindNearestPointsTest {

  @Test
  public void testInputArray() {
    Scanner testInput;
    double[][] actualArray;
    double[][] expectedArray;

    // Test Case 1 - (3,3,3) (4,6,7) (8,7,11) (3,6,9)
    testInput = new Scanner("4   3 3 3   4 6 7   8 7 11   3 6 9");
    actualArray = FindNearestPoints.inputArray(testInput);
    expectedArray = new double[][] {{3, 3, 3}, {4, 6, 7}, {8, 7, 11}, {3, 6, 9}};
    assertArrayEquals("Test Case 1 failed", actualArray, expectedArray);

    // Test Case 2 - (1.1, 4.4, 3.1) (4.7, 8.9, 12.5) (11.234, 1.001, 4.341)
    testInput = new Scanner("3   1.1 4.4 3.1   4.7 8.9 12.5   11.234 1.001 4.341");
    actualArray = FindNearestPoints.inputArray(testInput);
    expectedArray = new double[][] {{1.1, 4.4, 3.1}, {4.7, 8.9, 12.5}, {11.234, 1.001, 4.341}};
    assertArrayEquals("Test Case 2 failed", actualArray, expectedArray);
  }

  @Test
  public void testDistanceBetweenTwoPoints() {
    double actualDistance;
    double expectedDistance;

    // Test Case 1 - (1, 1, 1) -> (3, 3, 3) = 2√3
    actualDistance =
        FindNearestPoints.distanceBetweenTwoPoints(new double[] {1, 1, 1}, new double[] {3, 3, 3});
    expectedDistance = 2 * Math.sqrt(3);
    assertEquals("Test Case 1 failed", actualDistance, expectedDistance, 0.000001);

    // Test Case 2 - (5.16, 10.7, 15.44) -> (77.19, 67.0, 91.964) = 119.2222021
    actualDistance = FindNearestPoints.distanceBetweenTwoPoints(new double[] {5.16, 10.7, 15.44},
        new double[] {77.19, 67.0, 91.964});
    expectedDistance = 119.2222021;
    assertEquals("Test Case 2 failed", actualDistance, expectedDistance, 0.000001);

    // Test Case 3 - (5,5,5) -> (5,5,5) = 0
    actualDistance =
        FindNearestPoints.distanceBetweenTwoPoints(new double[] {5, 5, 5}, new double[] {5, 5, 5});
    expectedDistance = 0;
    assertEquals("Test Case 3 failed", actualDistance, expectedDistance, 0.000001);

    // Test Case 4 - (2,2,2) -> (-2,-2,-2) = 4√3
    actualDistance = FindNearestPoints.distanceBetweenTwoPoints(new double[] {2, 2, 2},
        new double[] {-2, -2, -2});
    expectedDistance = 4 * Math.sqrt(3);
    assertEquals("Test Case 4 failed", actualDistance, expectedDistance, 0.000001);
  }

  @Test
  public void testClosestPoints() {
    double[][] testPoints;
    int[] actualIndexes;
    int[] expectedIndexes;

    // Test Case 1
    testPoints = new double[][] {{0, 0, 0}, {-33, 45, -55}, {100, 133, 4}, {-3, 4, 1}, {12, 11, 0}};
    actualIndexes = FindNearestPoints.closestPoints(testPoints);
    expectedIndexes = new int[] {0, 3};
    assertArrayEquals("Test Case 1 failed", actualIndexes, expectedIndexes);

    // Test Case 2
    testPoints = new double[][] {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
    actualIndexes = FindNearestPoints.closestPoints(testPoints);
    expectedIndexes = new int[] {0, 1};
    assertArrayEquals("Test Case 2 failed", actualIndexes, expectedIndexes);
  }


}

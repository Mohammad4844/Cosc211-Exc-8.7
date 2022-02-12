package pkg;

import java.util.Scanner;

public class FindNearestPoints {
  /*
   * Made all methods static as it seemed like the best approach. Other way required making an
   * instance of this class, which doesn't make much sense. Testing is also way easier in this, as
   * the return values in methods make sense. Using an instance involved either making an instance
   * variable of the array or have methods as below, own having their own issues.
   */
  public static void main(String[] args) {
    double[][] points = inputArrayFromUser();
    int[] indexesOfClosestPoints = closestPoints(points);
    displayPoints(points, indexesOfClosestPoints[0], indexesOfClosestPoints[1]);
  }

  public static double[][] inputArrayFromUser() {
    return inputArray(new Scanner(System.in));
  }

  // separated scanner creation from input method to make it viable for testing
  public static double[][] inputArray(Scanner input) {
    System.out.println("Enter the number of points: ");
    int numberOfPoints = input.nextInt();
    double[][] points = new double[numberOfPoints][3];
    System.out.print("Enter " + numberOfPoints + " points: ");
    for (int i = 0; i < points.length; i++) {
      points[i][0] = input.nextDouble();
      points[i][1] = input.nextDouble();
      points[i][2] = input.nextDouble();
    }
    return points;
  }

  // returning an array of the indexes because you cannot return more than 1 value
  public static int[] closestPoints(double[][] points) { //
    int p1 = 0;
    int p2 = 1;
    double shortestDistance = distanceBetweenTwoPoints(points[0], points[1]);
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double distance = distanceBetweenTwoPoints(points[i], points[j]);
        if (shortestDistance > distance) {
          p1 = i;
          p2 = j;
          shortestDistance = distance;
        }
      }
    }
    return new int[] {p1, p2};
  }

  // modified method header by also sending in the array itself, as without an instance variable,
  // the (int,int) header does'nt make sense
  public static void displayPoints(double[][] points, int index1, int index2) {
    System.out.println("The closest two points are (" + points[index1][0] + ", " + points[index1][1]
        + ", " + points[index1][2] + ") and (" + points[index2][0] + ", " + points[index2][1] + ", "
        + points[index2][2] + ")");
  }

  public static double distanceBetweenTwoPoints(double[] firstPoint, double[] secondPoint) {
    double changeInX = secondPoint[0] - firstPoint[0];
    double changeInY = secondPoint[1] - firstPoint[1];
    double changeInZ = secondPoint[2] - firstPoint[2];
    return Math.sqrt(Math.pow(changeInX, 2) + Math.pow(changeInY, 2) + Math.pow(changeInZ, 2));
  }
}

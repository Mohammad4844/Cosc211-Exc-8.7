# Cosc211-Exc-8.7
Quick link to files:
<br>
[FindNearestPoints.java]()
<br>
[JUnit Test File]()
## Method overview
double[][] inputArrayFromUser()
- creates a Scanner object and calls inputArray(), returning the array recieved

double[][] inputArray(Scanner)
- takes input from Scanner object, adds it to a 2d array of type double containing points (in a 3d plane) and returns it

int[] closestPoints(double[][])
- determines the 2 closest points in an array of points, and returns their indexes in an int array

void displayPoints(double[][], int, int)
- displays the 2 points, at said indexes, of the 2d array onto the screen

double distanceBetweenTwoPoints(double[], double[])
- returns the distance between 2 points (which are in a 3d plane)

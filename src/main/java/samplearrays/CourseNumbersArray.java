package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        // Get the length of the array
        int n = registeredCourses.length;

        // Create a larger array
        int[] updatedCourse = new int[n+1];

        // Manual copy of all the elements from the first array
        for (int i = 0; i < n; i++) {
            updatedCourse[i] = registeredCourses[i];
        }

        // Add a new course
        updatedCourse[n] = 2170;

        // Display the updated course array
        for (int i = 0; i < n+1; i++) {
            System.out.print(updatedCourse[i] + " ");
        }
    }
}

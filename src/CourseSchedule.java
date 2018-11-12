import java.util.*;

class CourseScheduleSolution {
	// fail situation: 0 requires 1 and 1 requires 0
	
	// Solution 1
	// First: needs to find a course that has no prerequisite at all (degree == 0)
	// Take any one of it
	// Then delete dependency edge that requires the taken course
	// Find a course that has to prerequisite (indegree == 0), recursion
	// check if all courses are taken, no cycles left
	public boolean scheduleCourses(int[][] prerequisites){
		// greedy strategy:
		// if degree == 0 no prerequisite, can take this course
		int[] degree = new int[prerequisites.length];
		// build an inverted index list
		List<Integer>[] neighbors = new List[prerequisites.length];
		// record all available courses 
		Queue<Integer> available = new LinkedList<>();
		
		// build degree and available
		for (int i = 0; i < prerequisites.length; i++) {
			neighbors[i] = new ArrayList<>();
			degree[i] = prerequisites[i].length;
			if (degree[i] == 0) {
				available.offer(i);
			}
		}
		
		// build neighbors
		for (int from = 0; from < prerequisites.length; from++) {
			for (int to: prerequisites[from]) {
				neighbors[to].add(from);
			}
		}
		
		// how many courses already taken
		int count = 0;
		
		while (!available.isEmpty()) {
			for (int id: neighbors[available.poll()]) {
				if (--degree[id] == 0) {
					available.offer(id);
				}
			}
			count++;
		}
		return count == prerequisites.length;
	}
	
	
	// Solution 2: check if there is circle in a graph
	// only returns true / false, but not a sequence
	
}

/*
 * Modification
 * 1. What if a person can take 2 courses at a time
 * 		only possible a pair points to each other 1 <-> 2 
 */
public class CourseSchedule {
	public static void main(String[] args) {
		// prerequisites for course 0 is 1, for course 1 is 3, for course 2 is 3, for course 3 is none
		// output can be 3, 2, 1, 0 or 3, 1, 2, 0 or 3, 1, 0, 2
		int[][] prerequisites = {{1}, {3}, {3}, {}};
		// int[][] prerequisites = {{1}, {0}};
		CourseScheduleSolution s = new CourseScheduleSolution();
		System.out.println(s.scheduleCourses(prerequisites));
	}
}

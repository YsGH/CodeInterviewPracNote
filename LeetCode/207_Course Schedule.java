// There are a total of n courses you have to take, labeled from 0 to n - 1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
// which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// For example:

// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
// and to take course 0 you should also have finished course 1. So it is impossible.

// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
// Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.

public boolean canFinish(int numCourses, int[][] prerequisites) {
		Set<Integer> courses = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			courses.add(i);
		}
		while (courses.size() > 0) {
			Set<Integer> canLearn = new HashSet<>();
			for (int c : courses) {
				boolean req = false;
				for (int[] p : prerequisites) {
					if (p[0] == c && p[1] != -1) {
						req = true;
						break;
					}
				}
				if (!req) {
					canLearn.add(c);
				}
			}
			if (canLearn.size() == 0) {
				return false;
			}
			for (int c : canLearn) {
				courses.remove(c);
			}
			for (int[] p : prerequisites) {
				if (canLearn.contains(p[1])) {
					p[1] = -1;
				}
			}
		}
		return true;
	}
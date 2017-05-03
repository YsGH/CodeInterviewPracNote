// Given two words (beginWord and endWord), and a dictionary's word list, 
// find all shortest transformation sequence(s) from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:
// Return an empty list if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.

public class Solution {
    List<List<String>> results;
	List<String> list;
	Map<String, List<String>> map;
	boolean neighbor (String a, String b) {
		boolean flag=false;
		for (int i=0; i<a.length(); i++) {
			if (a.charAt(i)==b.charAt(i)) {
				continue;
			} else if (flag) {
				return false;
			} else {
				flag=true;
				continue;
			}
		}
		return true;
	}

	public List<List<String>> findLadders(String start, String end,	List<String> dict) {
		results = new ArrayList<List<String>>();
		list = new LinkedList<String>();
		if (dict.size() == 0)
			return results;
		if (!dict.contains(start)) {
			dict.add(start);
		}
		map = new HashMap<String, List<String>>();
		for (int i=0; i<dict.size(); i++) {
			String a=dict.get(i);
			List<String> aList=map.get(a);
			if (aList==null) {
				aList=new ArrayList<String>();
				map.put(a, aList);
			}
			for (int j=i+1; j<dict.size(); j++) {
				String b=dict.get(j);
				if (neighbor(a,b)) {
					aList.add(b);
					List<String> bList=map.get(b);
					if (bList==null) {
						bList=new ArrayList<String>();
						map.put(b, bList);
					}
					bList.add(a);
				}
			}
		}
		Deque<String> queue = new ArrayDeque<String>();
		Set<String> unvisited = new HashSet<String>(dict);
		Set<String> visited = new HashSet<String>();
		
		queue.add(start);
		unvisited.add(end);
		unvisited.remove(start);
		int step=1;
		int cur=1;
		int next=0;
		boolean found=false;
		// BFS
		while (!queue.isEmpty()) {
			String a = queue.poll();
			cur--;
			for (String n: map.get(a)) {
				if (unvisited.contains(n)){
					//Handle queue
					if (visited.add(n)){//Key statement,Avoid Duplicate queue insertion
						next++;
						queue.add(n);
					}
					if (n.equals(end)) 
						found=true;							
				}
			}
			if (cur==0) {
				step++;
				if (found) break;
				cur=next;
				next=0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}// End While

		backTrace(end, start, step);

		return results;
	}

	private void backTrace(String word, String start, int step) {
		if (step==0) {
			return;
		}
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null)
			for (String s : map.get(word))
				backTrace(s, start, step-1);
		list.remove(0);
	}
}
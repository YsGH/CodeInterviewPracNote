/**
 * List of music, and each music is denoted by one number
 * Each person has his/her own ranking list in terms of his/her favorite musics:
 * Input: E.g., Person A: {1 8 9}
 *              Person B: {2 9}
 *              Person C: {9 3}
 *              Person D: {1}
 * Question: How to combine musics together to one big list so that music
 * ranking in the big list would be in consistent with the music ranking list of each person.
 *
 * Output: E.g., {1 2 8 9 3}
 * It may have multiple feasible solutions. E.g., {1 8 2 9 3} is also feasible
 *
 * */

 // follow up, we have a VIP, and we want to his music to be as front as possible

 public List<Integer> combineList(Map<String, List<Integer>> personRankingLists) {
    Map<Integer, Set<Integer>> lowerRankGraph=new HashMap<>();
    Map<Integer, Set<Integer>> higherRankGraph=new HashMap<>();
    int count=0;
    for (List<Integer> list : personRankingLists.values()) {
        for (int i=0; i<list.size(); i++) {
            int m=list.get(i);
            Set<Integer> l=lowerRankGraph.get(m);
            Set<Integer> h=higherRankGraph.get(m);
            if (l==null) {
                count++;
                l=new HashSet<Integer>();
                lowerRankGraph.put(m, l);
            }
            if (h==null){
                h=new HashSet<Integer>();
                higherRankGraph.put(m, h);
            }
            if (i+1<list.size()) {
                l.add(list.get(i+1));
            }
            if (i>0) {
                h.add(list.get(i-1));
            }
        }
    }
    List<Integer> res=new LinkedList<>();
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i:higherRankGraph.keySet()) {
    if (higherRankGraph.get(i).size()==0) {
        queue.offer(i);
    }
    }
    while (queue.isEmpty()) {
        int m=queue.poll();
        res.add(m);
        for (int sub: lowerRankGraph.get(m)) {
            Set<Integer> set=higherRankGraph.get(sub);
            set.remove(m);
            if (set.size()==0) {
                queue.offer(sub);
            }
        }
        count--;
    }
    if (count!=0) {
        return null;
    }
    return res;
}
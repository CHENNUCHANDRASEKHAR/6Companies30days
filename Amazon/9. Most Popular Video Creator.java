// Problem Link: https://leetcode.com/problems/most-popular-video-creator/

// Language: Java


class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> viewMap = new HashMap<>();
        Map<String, PriorityQueue<Integer>> idMap = new HashMap<>();
        int n = creators.length;
        long max = 0;
        for(int i = 0; i < n; i++) {
            long viewsTillNow = viewMap.getOrDefault(creators[i], 0L) + views[i];
            max = Math.max(max, viewsTillNow);
            viewMap.put(creators[i], viewsTillNow);
            
            PriorityQueue<Integer> q = idMap.getOrDefault(creators[i], 
                                   new PriorityQueue<>((a, b) -> views[a] == views[b]? ids[a].compareTo(ids[b]) : views[b] - views[a]));
            q.add(i);
            idMap.put(creators[i], q);
        }
       List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, Long> entry : viewMap.entrySet()) {
            if(entry.getValue() == max) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(ids[idMap.get(entry.getKey()).remove()]);
                res.add(list);
            }
        }
        return res;
    }
}

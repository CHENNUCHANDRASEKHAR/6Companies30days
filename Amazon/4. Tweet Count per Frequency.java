// Problem Link: https://leetcode.com/problems/tweet-counts-per-frequency/

// Language: Java


class TweetCounts {
    
    Map<String, TreeMap<Integer, Integer>> map;
    public TweetCounts() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        map.compute(tweetName, (k, v) -> {
            if(v == null) v = new TreeMap<>();
            v.compute(time, (x, y) -> {
               int t = 0;
               if(y != null) t = y;
                t++;
                return t;
            });
            return v;
        });
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        if(!map.containsKey(tweetName)) {
            res.add(0);
            return res;
        }
        
        int delta = getDelta(freq);
        int time = startTime;
        TreeMap<Integer, Integer> m = map.get(tweetName);
        int size = ((endTime - startTime)/delta) + 1;
        while(size-- > 0) res.add(0);
        for(Map.Entry<Integer, Integer> e : m.subMap(startTime, endTime + 1).entrySet()) {
            int idx = (e.getKey() - startTime)/delta;
            res.set(idx, res.get(idx) + e.getValue());
        }
        return res;
    }
    
    private int getDelta(String freq) {
        if(freq.equals("minute")) {
            return 60;
        } else if(freq.equals("hour")) {
            return 60 * 60;
        } else {
            return 60 * 60 * 24;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

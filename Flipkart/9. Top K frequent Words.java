// Problem Link: https://leetcode.com/problems/top-k-frequent-words/

//Language: Java


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         HashMap<String, Integer> map = new HashMap<>();
        
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Item> queue = new PriorityQueue<>(new ItemComparator());
        
        for (String key: map.keySet()) {
            queue.add(new Item(key, map.get(key)));
        }
        
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<k; i++) {
            list.add(queue.remove().word);
        }
        
        return list;
    }
}

class Item {
    String word;
    int count;
    
    Item(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class ItemComparator implements Comparator<Item> {
    
    public int compare(Item a, Item b) {
        if (a.count < b.count) 
            return 1;
        else if (a.count > b.count)
            return -1;
        else
            return a.word.compareTo(b.word);
        
    }
}

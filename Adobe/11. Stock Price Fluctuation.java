// Problem Link: https://leetcode.com/problems/stock-price-fluctuation/

// Language: Java



class StockPrice {
    private final Map<Integer, Integer> map;
    private TreeSet<Integer> set;
    private int currentStockPrice;
    private int currentTimestamp;
    private Map<Integer, Integer> occurrences;
    public StockPrice() {
        map = new HashMap();
        set = new TreeSet();
        occurrences = new HashMap();
        currentStockPrice = 0;
        currentTimestamp = 0;
    }
    
    public void update(int timestamp, int price) {
        if(timestamp >= currentTimestamp) {
            currentTimestamp = timestamp;
            currentStockPrice = price;
        }
        if(map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            if(occurrences.get(oldPrice) == 1) {
                occurrences.remove(oldPrice);
                set.remove(oldPrice);
            } else {
                occurrences.put(oldPrice, occurrences.get(oldPrice)-1);
            }
        }
        int currentPrice = price;
        map.put(timestamp, currentPrice);
        set.add(currentPrice);
        occurrences.put(currentPrice, occurrences.getOrDefault(currentPrice, 0) + 1);
    }
    
    public int current() {
        return currentStockPrice;
    }
    
    public int maximum() {
        return set.last();
    }
    
    public int minimum() {
        return set.first();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

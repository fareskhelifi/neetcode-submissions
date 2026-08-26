class MedianFinder {
    private List<Integer> values;

    public MedianFinder() {
        this.values = new ArrayList<>();        
    }
    
    public void addNum(int num) {
        this.values.add(num);
        Collections.sort(values);    
    }
    
    public double findMedian() {  
        int size = getSize();
        if (size == 0) return 0;
        if (size % 2 != 0) {
            return (double) values.get(size / 2);
        } 
        int index = size / 2;
        double median = (double) (values.get(index - 1) + values.get(index)) / 2;
        return median;
    }

    public int getSize() {
        return this.values.size();
    }
}

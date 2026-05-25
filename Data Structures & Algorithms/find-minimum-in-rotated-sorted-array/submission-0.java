class Solution {
    public int findMin(int[] arr) {
        int l = 0;
        int h = arr.length - 1;

        while(l < h) {
            int m = l + (h - l) / 2;

            if(arr[m] > arr[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return arr[l];
    }
}



// 4 5 6 7
// 0 1 2 3
// l     h

// l=0
// h=3
// m=1


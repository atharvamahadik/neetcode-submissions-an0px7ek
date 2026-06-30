class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for(int[] temp : matrix) {
            swap(temp);
        }
    }

    private void swap(int[] temp) {
        int left = 0;
        int right = temp.length - 1;
        while(left < right) {
            int newv = temp[left];
            temp[left] = temp[right];
            temp[right] = newv;
            left++;
            right--;
        }
    }
}

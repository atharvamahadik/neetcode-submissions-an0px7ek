class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        int l = 0;
        int r = people.length - 1;
        Arrays.sort(people);
        while(l <= r) {
          if((people[l]+people[r])<=limit) {
            boat=boat+1;
            l++;
            r--;
          } 
          else {
            boat=boat+1;
            r--;
          }
        }
        return boat;
    }
}





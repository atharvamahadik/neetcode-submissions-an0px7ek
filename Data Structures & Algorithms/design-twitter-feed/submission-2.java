class Twitter {

    private int timeCount;

    private class Tweet {
        int tweetId;
        int time;
        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeCount++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<> ((a,b) -> Integer.compare(a.time, b.time));

        Set<Integer> users = new HashSet<>();
        users.add(userId);

        if(followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        for(int user : users) {
            List<Tweet> userTweets = tweetMap.get(user);
            if(userTweets == null) continue;

            for(Tweet tweet : userTweets) {
                minHeap.offer(tweet);
                if(minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        List<Integer> result = new LinkedList<>();

        while(!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll().tweetId);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

class Twitter {

    class Tweet implements Comparable<Tweet>{
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            next = null;
        }

        @Override
        public int compareTo(Tweet another) {
            return Integer.compare(another.time, this.time);
        }
    }

    class User {
        int id;
        Set<User> follow;
        Tweet head;

        User(int id) {
            this.id = id;
            follow = new HashSet<>();
            follow.add(this);
            head = null;
        }

        public void postTweet(int tweetId) {
            Tweet t = new Tweet(tweetId, time++);
            t.next = head;
            head = t;
        }

        public void follow(User followee) {
            follow.add(followee);
        }

        public void unfollow(User followee) {
            follow.remove(followee);
        }

        public List<Integer> getNewsFeed() {
            List<Integer> news = new ArrayList<>();
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>();
            for (User user : follow) {
                if (user.head != null) {
                    maxHeap.offer(user.head);
                }
            }

            while (news.size() < N && !maxHeap.isEmpty()) {
                Tweet t = maxHeap.poll();
                news.add(t.id);
                if (t.next != null) {
                    maxHeap.offer(t.next);
                }
            }

            return news;
        }
    }


    int N;
    int time;
    Map<Integer, User> users;

    public Twitter() {
        N = 10;
        time = 0;
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        users.get(userId).postTweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        users.putIfAbsent(userId, new User(userId));
        return users.get(userId).getNewsFeed();
    }
    
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follow(users.get(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).unfollow(users.get(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
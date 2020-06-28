package LeetCode.first_0301;

import java.util.*;
/*
355.设计推特
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：

postTweet(userId, tweetId): 创建一条新的推文
getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
follow(followerId, followeeId): 关注一个用户
unfollow(followerId, followeeId): 取消关注一个用户
 */
public class Medium_355 {

    static class Twitter {
        private int tick;
        private Map<Integer, List<Integer>> posts;
        private Map<Integer, Set<Integer>> following;
        private Map<Integer, Integer> postTick;
        private static final int LIMIT = 10;
        /**
         * Initialize your data structure here.
         */

        public Twitter() {
            posts = new HashMap<>();
            following = new HashMap<>();
            postTick = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            List<Integer> userPosts = posts.computeIfAbsent(userId, x -> new LinkedList<>());
            if (userPosts.size() == LIMIT)
                userPosts.remove(userPosts.size() - 1);
            userPosts.add(0, tweetId);
            postTick.put(tweetId, tick++);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ans = new ArrayList<>();
            Iterator<Integer> it = posts.computeIfAbsent(userId, x -> new LinkedList<>()).iterator();
            // add current user's posts
            // 添加当前用户的推文
            for (int i = 0; i < LIMIT && it.hasNext(); i++)
                ans.add(it.next());
            //遍历follow的用户ID
            for (int uid : following.computeIfAbsent(userId, x -> new LinkedHashSet<>())) {
                if (userId == uid) continue;
                List<Integer> tmp = new ArrayList<>();
                //获取follow的用户的Set推文
                it = posts.computeIfAbsent(uid, x -> new LinkedList<>()).iterator();
                // 初始化pid1为当前用户第一条推文
                // 初始化pid2为follow用户第一条推文
                Integer pid1 = ans.size() > 0 ? ans.get(0) : null;
                Integer pid2 = it.hasNext() ? it.next() : null;

                // merge K linked list with 10 items limit
                for (int i = 1; (pid1 != null || pid2 != null) & tmp.size() < LIMIT; ) {
                    if (pid1 != null && pid2 != null) {
                        if (postTick.get(pid1) > postTick.get(pid2)) {
                            tmp.add(pid1);
                            pid1 = i < ans.size() ? ans.get(i++) : null;
                        } else {
                            tmp.add(pid2);
                            pid2 = it.hasNext() ? it.next() : null;
                        }
                    } else if (pid1 != null) {
                        tmp.add(pid1);
                        pid1 = i < ans.size() ? ans.get(i++) : null;
                    } else {
                        tmp.add(pid2);
                        pid2 = it.hasNext() ? it.next() : null;
                    }
                }
                ans = tmp;
            }

            return ans;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            following.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            following.computeIfAbsent(followerId, x -> new HashSet<>()).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }
}

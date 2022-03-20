package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/13 23:35
 * @Description:
 */
public class Twitter {
    /**
     * 全局时间戳
     */
    private static int timestamp = 0;
    private HashMap<Integer, Tweet> userMap;
    private HashMap<Integer, HashSet<Integer>> followings;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
        followings = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (userMap.containsKey(userId)) {
            Tweet topTweet = userMap.get(userId);
            Tweet newTweet = new Tweet(tweetId, timestamp);
            newTweet.next = topTweet;
            userMap.put(userId, newTweet);
        } else {
            userMap.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>(10);
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
        Tweet tweet = userMap.get(userId);
        //根据多路归并原理，只需把链表头结点入队
        if (tweet != null) {
            maxHeap.offer(tweet);
        }
        HashSet<Integer> follows = followings.get(userId);
        if (follows != null && follows.size() > 0) {
            for (Integer integer : follows) {
                Tweet twee = userMap.get(integer);
                if (twee != null) {
                    maxHeap.offer(twee);
                }
            }
        }
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            list.add(head.id);
            if (head.next != null){
                maxHeap.offer(head.next);
            }
            count++;
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        HashSet<Integer> follows = followings.get(followerId);
        if (follows == null) {
            follows = new HashSet<>();
            follows.add(followeeId);
            followings.put(followerId, follows);
        } else {
            follows.add(followeeId);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        HashSet<Integer> follows = followings.get(followerId);
        if (follows == null) {
            return;
        } else {
            follows.remove(followeeId);
        }

    }

    private class Tweet {
        /**
         * 推文id
         */
        private int id;
        /**
         * 推文发布时间
         */
        private int timestamp;
        private Tweet next;

        private Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);

    }

}

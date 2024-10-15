package bfs;

import java.util.*;

public class FriendRecommendation {

    public int[] friendRecommendations(int n, int m, int[][] friendships) {
        // write your code here
        //0: 1, 2
        //1: 0
        //2: 0
        int[] result = new int[n];
        List<Set<Integer>> friendshipList = toList(n, friendships);
        for (int i = 0; i < n; i++) {
            result[i] = getRecommendations(i, friendshipList);
        }
        return result;
    }
    private List<Set<Integer>> toList(int n, int[][] friendships) {
        List<Set<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new HashSet<>());
        }
        for (int[] friendship : friendships) {
            result.get(friendship[0]).add(friendship[1]);
            result.get(friendship[1]).add(friendship[0]);
        }
        return result;
    }
    private int getRecommendations(int user, List<Set<Integer>> friendships) {
        // it's better to use int[] !!!!
        Map<Integer, Integer> recommendationCount = new HashMap<>();
        int recommendation = -1;
        int maxCount = 0;
        Set<Integer> firstFriends = friendships.get(user);
        if (firstFriends.isEmpty())   return user == 0 ? 1: 0;
        if (firstFriends.size() == friendships.size() - 1)  return -1;
        for (int firstFriend: firstFriends) {
            Set<Integer> secondFriends = friendships.get(firstFriend);
            for (int secondFriend: secondFriends) {
                if (secondFriend == user || firstFriends.contains(secondFriend))   continue;
                int count = recommendationCount.getOrDefault(secondFriend, 0) + 1;
                recommendationCount.put(secondFriend, count);
                if (count > maxCount || (count == maxCount && recommendation > secondFriend)) {
                    recommendation = secondFriend;
                    maxCount = count;
                }
            }
        }
        return recommendation;
    }

}

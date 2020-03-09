package wxf.lc$n207;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description
 * @auther xuefeng
 * @create 2020-03-05 21:12
 */
public class Main {
    public static void main(String[] args) {
        int[][] courses = {{1, 0}};
        System.out.println(new Solution().canFinish(2, courses));
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courseNums = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            courseNums[prerequisite[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<courseNums.length; i++){
            if(courseNums[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer preCourse = queue.remove();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == preCourse) {
                    courseNums[prerequisite[0]]--;
                    if (courseNums[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}

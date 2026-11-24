/*
 * LeetCode 1. Two Sum (Easy)   https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input has exactly one solution, and you may not use
 * the same element twice. You can return the answer in any order.
 *
 * Example 1: nums = [2,7,11,15], target = 9   Output: [0,1]
 * Example 2: nums = [3,2,4],     target = 6   Output: [1,2]
 * Example 3: nums = [3,3],       target = 6   Output: [0,1]
 *
 * Constraints:
 *   2 <= nums.length <= 10^4
 *   -10^9 <= nums[i] <= 10^9
 *   -10^9 <= target <= 10^9
 *   Only one valid answer exists.
 *
 * Follow-up: can you come up with an algorithm that is less than O(n^2) time?
 */

#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

// ============ WRITE YOUR SOLUTION HERE (exactly as on LeetCode) ============
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // your code
        return {};
    }
};
// ===========================================================================

// ---- Local test harness: LeetCode runs the tests for you; here we do it. Do not edit below. ----
static int failures = 0;
static void run(const char* name, vector<int> nums, int target, vector<int> expected) {
    Solution s;
    vector<int> got = s.twoSum(nums, target);
    sort(got.begin(), got.end());          // "any order" is allowed
    sort(expected.begin(), expected.end());
    bool ok = got == expected;
    if (!ok) ++failures;
    cout << (ok ? "Accepted  " : "Wrong Answer  ") << name << "\n";
}
int main() {
    run("Example 1", {2, 7, 11, 15}, 9, {0, 1});
    run("Example 2", {3, 2, 4}, 6, {1, 2});
    run("Example 3", {3, 3}, 6, {0, 1});
    run("negatives", {-1, -2, -3, -4, -5}, -8, {2, 4});
    run("zeros", {0, 4, 3, 0}, 0, {0, 3});
    run("mixed signs", {-3, 4, 3, 90}, 0, {0, 2});
    run("large values", {1000000000, -1000000000, 7}, 0, {0, 1});
    cout << (failures ? "\nSome test cases failed.\n" : "\nAll test cases passed.\n");
    return failures ? 1 : 0;
}

/* WRITTEN ANSWERS (follow-ups; replace the text)
 * 1. Sorted array, O(1) extra space: TODO
 * 2. Return all pairs; how do duplicates change the map?: TODO
 * 3. Data does not fit in memory: TODO
 * 4. Average vs worst-case time of your solution, and why: TODO
 */

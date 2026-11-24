// Day 1 DSA: LeetCode 1 Two Sum. Fill in your solution and run:
//   g++ -std=c++17 -Wall -Wextra -o /tmp/two_sum dsa/day-01/two_sum.cpp && /tmp/two_sum
#include <cassert>
#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

vector<int> twoSum(const vector<int>& nums, int target) {
    // TODO: your solution here (apply the review notes: loop from 0, single lookup, earlier index first)
    (void)nums; (void)target;  // remove once you use them
    return {};
}

static int failures = 0;
static void check(const char* name, vector<int> nums, int target, vector<int> expected) {
    vector<int> got = twoSum(nums, target);
    bool ok = got == expected;
    cout << (ok ? "PASS " : "FAIL ") << name << "\n";
    if (!ok) ++failures;
}

int main() {
    check("basic", {2, 7, 11, 15}, 9, {0, 1});
    check("middle", {3, 2, 4}, 6, {1, 2});
    check("duplicates", {3, 3}, 6, {0, 1});
    check("negatives", {-1, -2, -3, -4, -5}, -8, {2, 4});
    check("zeros", {0, 4, 3, 0}, 0, {0, 3});
    check("negative+positive", {-3, 4, 3, 90}, 0, {0, 2});

    // WRITTEN ANSWERS (replace the text):
    // 1. Sorted array, O(1) extra space approach: TODO
    // 2. Return all pairs; how do duplicates change the map?: TODO
    // 3. Data does not fit in memory: TODO
    // 4. Average vs worst-case time of your solution and why: TODO
    return failures ? 1 : 0;
}

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        crt = {}
        for val in nums:
            if val in crt:
                return True
            else:
                crt[val] = 1
        return False
class Solution:
    """
    @param A: an integer array
    @return: nothing
    """
    def sortIntegers(self, A):
        # write your code here
        # sort a list of integers with quicksort 
        if len(A) == 0:
            return
    
        quickSort(A, 0, len(A) - 1)
    
    def quickSort(A, start, end):
        
        if start >= end:
            return
        
        # randomly pick a pivot value 
        pivot = A[(start + end) / 2]
        left = start
        right = end
    
        while left <= right:
            while left <= right and A[left] < pivot:
                left += 1
            while left <= right and A[right] > pivot:
                right -= 1
            if left <= right:
                # exchange the 2 values
                tmp = A[left]
                A[left] = A[right]
                A[right] = tmp
                left += 1
                right -= 1
    
        quickSort(A, start, right)
        quickSort(A, left, end)

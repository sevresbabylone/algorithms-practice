"""Quicksort"""

def quicksort(array, left, right):
    """A method to perform quicksort on an array"""
    if left < right:
        pivot = partition(array, left, right)
        quicksort(array, left, pivot-1)
        quicksort(array, pivot+1, right)

def partition(array, left, right): 
    """Returns new pivot after partitioning array elements according to current pivot"""
    for index in range(left, right):
        if array[index] <= array[right]:
            array[left],array[index] = array[index],array[left]
            left += 1
    array[left],array[right] = array[right],array[left]
    return left


UNSORTED_ARRAY = [9, 7, 5, 11, 12, 2, 14, 3, 10, 6]
quicksort(UNSORTED_ARRAY, 0, len(UNSORTED_ARRAY) - 1)
print(UNSORTED_ARRAY)

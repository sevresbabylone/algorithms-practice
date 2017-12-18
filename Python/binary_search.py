"""Binary Search"""

def binary_search(array, upper_bound, lower_bound, value):
    """A method to perform binary search recursively"""
    midpoint = int((lower_bound + upper_bound) / 2)
    if lower_bound > upper_bound:
        return -1
    if array[midpoint] == value:
        return midpoint
    if array[midpoint] > value:
        return binary_search(array, midpoint -1, lower_bound, value)
    if array[midpoint] < value:
        return binary_search(array, upper_bound, midpoint + 1, value)

ORDERED_ARRAY = [1, 2, 3, 4, 5, 6, 7, 9, 20]
print(str(binary_search(ORDERED_ARRAY, len(ORDERED_ARRAY), 0, 19)))

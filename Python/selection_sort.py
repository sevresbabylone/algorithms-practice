"""Selection sort"""

def swap(array, first_index, second_index):
    """A method to swap values of two indexes"""
    temp = array[first_index]
    array[first_index] = array[second_index]
    array[second_index] = temp

def find_minimum_index(array, start_index):
    """A method to find index of minimum value in a subarray"""
    minimum_index = 0
    subarray = array[start_index:]
    for i, value in enumerate(subarray):
        if subarray[minimum_index] > subarray[i]:
            minimum_index = i
    return minimum_index + start_index

def selection_sort(array):
    """A method to sort an array from smallest to largest using selection sort"""
    for i, value in enumerate(array):
        minimum_index = find_minimum_index(array, i)
        swap(array, minimum_index, i)

UNSORTED_ARRAY = [99, 14, 32, 30, 22, 1, 1]
selection_sort(UNSORTED_ARRAY)
print(UNSORTED_ARRAY)

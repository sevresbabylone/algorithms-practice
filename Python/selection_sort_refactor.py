"""Selection sort"""

def swap(array, first_index, second_index):
    """A method to swap values of two indexes"""
    temp = array[first_index]
    array[first_index] = array[second_index]
    array[second_index] = temp

def selection_sort(array):
    """A method to sort an array from smallest to largest using selection sort"""
    for i, value1 in enumerate(array):
        minimum_index = i
        for k, value2 in enumerate(array[i + 1:]):
            if array[minimum_index] > value2:
                minimum_index = k + i + 1
        swap(array, minimum_index, i)

UNSORTED_ARRAY = [99, 14, 32, 30, 22, 1, 1]
selection_sort(UNSORTED_ARRAY)
print(UNSORTED_ARRAY)
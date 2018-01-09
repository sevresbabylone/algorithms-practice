"""Binary Gap"""

def binary_gap_split(integer):
    """A function that returns the length of longest binary gap of positive integer N"""
    return max(len(gap) for gap in bin(integer)[2:].split('1'))

def binary_gap_iterative(integer):
    """A function that returns the length of longest binary gap of positive integer N"""
    largest_gap = 0
    current_gap = 0
    for c in bin(integer)[2:]:
        if c == '0':
            current_gap += 1
        else:
            if current_gap > largest_gap:
                largest_gap = current_gap
            current_gap = 0
    return largest_gap

print(binary_gap_split(1041))
print(binary_gap_iterative(2147483647))
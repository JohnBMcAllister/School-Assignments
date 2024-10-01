'''
COMP 3270 Intro to Algorithms Homework 1: Introduction to Python
install python (google it) and make sure you have python version 3.6+ 
'''
import random
import time

'''
Problem 1: Implement your favorite n^2 sorting method
'''
# your code here
#A personal favorite of mine. A destructive, in-place n^2 algorithm that makes me laugh.
def gnomeSort(arr):
    i = 0
    while i < len(arr):
        if i == 0:
            i = i + 1
        if arr[i] >= arr[i - 1]:
            i = i + 1
        else:
            arr[i], arr[i - 1] = arr[i - 1], arr[i]
            i = i -1

    return arr
'''
Problem 2: Implement merge sort
'''
# your code here
def mergeSort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    L = arr[:mid]
    R = arr[mid:]

    L = mergeSort(L)
    R = mergeSort(R)

    return merge(L, R)

def merge(L, R):
    l, r = 0, 0
    arr = []
    while l < len(L) or r < len(R):
        if l == len(L):
            arr.append(R[r])
            r += 1
        elif r == len(R):
            arr.append(L[l])
            l += 1
        else:
            if L[l] <= R[r]:
                arr.append(L[l])
                l += 1
            else:
                arr.append(R[r])
                r += 1
    return arr



'''
Problem 3: Implement quick sort 2 ways. 1 using a random element as the pivot. 2nd using the median of 3 random elements as the pivot
'''
#your code here
def quickSortRan(A):
    n = len(A)
    if n <= 1:
        return A
    pivot = random.randint(0, n-1)
    pivot_value = A[pivot]
    pivot_pos = partition(A, pivot)
    left = quickSortRan(A[0:pivot_pos])
    right = quickSortRan(A[pivot_pos+1:n])
    return left + [pivot_value] + right

def partition(A, pivot):
    swap(A, pivot, 0)
    pivot_val = A[0]
    low = 1
    high = len(A) - 1
    while low <= high:
        while low <= high and A[low] <= pivot_val:
            low += 1
        while low <= high and A[high] > pivot_val:
            high -= 1
        if high > low:
            swap(A, low, high)
    swap(A, 0, high)
    return high

def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

def quickSortMed(A):
    if len(A) <= 1:
        return A
    pivotElements = [random.randint(0,len(A)-1) for i in range(3)]
    pivotLocation = pivotElements[1]
    pivotValue = A[pivotLocation]
    pivotPosition = partition(A, pivotLocation)
    left = quickSortMed(A[:pivotPosition])
    right = quickSortMed(A[pivotPosition+1:])
    return left + [pivotValue] + right

'''
Problem 4: Compare the runtime between merge sort, quick sort with random pivot, and quick sort with median of 3 random elements on lists ranging from 100k to 2m by increments of 100k 
use the time package to get the time, so use start = time.time() then after the algorithm runs end = time.time()
make a graph of this. I recommend the ggplot python port plotnine, but matplotlib would be fine as well
for inputs sizes 10000 to 300000 by 20k increments also run your n^2 method and plot vs the other methods
'''
#your code here
# inputs might look like A = [random.randint(0,1000000000) for i in range(100000)]

A = [random.randint(0,1000000000) for i in range(100000)]


start_time = time.time()
gnomeArray = gnomeSort(A.copy())  # Use A.copy() to avoid sorting the same array
elapsed_time = time.time() - start_time


start_time2 = time.time()
sortedMergeArray = mergeSort(A.copy())
elapsed_time2 = time.time() - start_time2


start_time3 = time.time()
sortedQuickRan = quickSortRan(A.copy())
elapsed_time3 = time.time() - start_time3


start_time4 = time.time()
sortedQuickMed = quickSortMed(A.copy())
elapsed_time4 = time.time() - start_time4


print("Gnome Sort took " + str(elapsed_time) + " seconds")
print("Merge Sort took " + str(elapsed_time2) + " seconds")
print("Quick Sort with random pivot took " + str(elapsed_time3) + " seconds")
print("Quick Sort with median of 3 random pivots took " + str(elapsed_time4) + " seconds")

'''
COMP 3270 Intro to Algorithms Homework 1: Introduction to Python
install python (google it) and make sure you have python version 3.6+ 
'''
import random
import time
from math import floor

'''
Problem 1: Make your own hashmap class from scratch (using only python lists). dicts not allowed. This problem will be 75% of this homework
Implement chaining in case of collisions. 
Use any hash function you like (such as those in the lecture notes). 
The underlying list may be fixed length. You do not have to account for the need to double its size when it is near capacity. Set it to 1024
Allow for types int and str (to convert an arbitrary str to a number you can use number = int.from_bytes(mystring.encode('utf-8'), 'little') and to recover the str you can use recoveredstring = number.to_bytes((number.bit_length() + 7) // 8, 'little').decode('utf-8').
For each key, there should be an associated value.
Implement insert(self, key, value), delete(self, key), get(self, key), and iter(self) which only loops through non-empty key, value pairs.
See https://www.w3schools.com/python/python_iterators.asp for how to implement an iterator in python
'''
# your code here
#Defining a linked list to use in the hash map to prevent collision using chaining
class LinkedListNode:
    def __init__(self, k = 1, v = 1, next = None):
        self.k = k
        self.v = v
        self.next = next

class HashLinkedList:

    #initializes hashmap and constants for universal hashing
    def __init__(self):
        self.size = 1024
        self.hash_table = self.buckets()
        self.const_a = random.randint(1, self.size - 1)
        self.const_b = random.randint(0, self.size - 1)

    #
    def buckets(self):
        return [[] for _ in range(self.size)]

    #operation for universal hashing to prevent the amount of collisions
    def uni_hash(self, key):
        #converts str to int for key
        if isinstance(key, str):
            key = int.from_bytes(key.encode('utf-8'), 'little')

        return ((self.const_a * key + self.const_b) % 1033) % self.size

    def insert(self, key, value):
        index = self.uni_hash(key)
        cur = self.hash_table[index]

        # Check if the key already exists in the chain
        while cur:
            if cur.k == key:
                cur.v = value
                return
            cur = cur.next

        # If key is not found, insert a new node at the head of the list
        new_node = LinkedListNode(key, value)
        new_node.next = self.hash_table[index]
        self.hash_table[index] = new_node

    def delete(self, key):
        index = self.uni_hash(key)
        cur = self.hash_table[index]

        # Traverse the list to find the node to delete
        while cur and cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next
                return
            cur = cur.next

    def get(self, key):
        index = self.uni_hash(key)
        cur = self.hash_table[index]
        while cur:
            if cur.key == key:
                return cur.v
            cur = cur.next
        return -1

    def __iter__(self):
        for bucket in self.hash_table:
            cur = bucket
            while cur:
                yield cur.k, cur.v
                cur = cur.next


'''
Problem 2: Use your hashmap class to count the number of each substring of length k in a DNA sequence. 
Print out the repeated items and the number of times they were repeated
run it on string "ATCTTGGTTATTGCGTGGTTATTCTTGC" with k=4
'''
#your code here


'''
Problem 3: Two sum. This time just use the python dict or set. 
Given an array, find two numbers that sum to a target number (don't worry about not reusing the same index this time). 
Code this two ways. Once brute force with nested for loops. And once using hashing. 
Use the input below. Bonus to code the sorting/binary search method. Feel free to use sort() or sorted() but code binary search yourself.
Compare the time taken between the implementations using the time package imported above.
'''
A = [random.randint(0,1000000000) for i in range(10000)]
target = A[random.randint(0, len(A)-1)] + A[random.randint(0,len(A)-1)]

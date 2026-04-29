# DS-W11-Chris_Brilianto_Chandra


## 4.3.e & 4.3.f
See the main implementation on MainCode.java

## 4.3.g 
is skipped

## 4.3.h
 It will only be the same if and only if the main tree only have one child or childless (Older generation will cry at this). Pre order will clean all the left side first then moves on onto the right side, BFS will clean all the side before going down a level. If the level is at most 1, BFS basically acts the same as Pre Order because it still scans from left to right.

## 4.3.I 
a. It will be O(n). Each directory is basically a node in the tree that require it to be accessed. For each directory and files that are scanned it becomes O(1)

b. Mechanically it still will be O(n) as it will be the same as 4.3.i but the main differences are another extra step of processing for getting the file name. It will still be O(n) tho

c. Doesnt really change anything, it will still be linear and result in O(n)
R1

// two easy questions, do not remember at all
// talked a little on golang coroutine

R2

// talked kind of a system design problem, basically it works like we discussed together to solve the problem
custom service chat box work
finite state machine
// talked lot on my project, I choose the compiler, basically I introduced him how to build a compiler
// a javascript asynchronous problem

R3
// weird code reading problem

// check whether a binary tree is 'balanced', the interviewer seems do not know how to describe the problem himself...
// 说话也说不清楚，非常讨厌，还是之前那个人好的男的和之后人很好的那个女的的manager，我也是醉了

// 'balanced' mean for every node in the tree, the difference of the deepest depth of either leaf node from its left and right child
// is less than 2, if there is no leaf node from its left/right child, it is still 'balanced'... WTF
/* e.g.   1
         2
        3
       4 5      is balanced       */

R4
// Binary tree level traverse
trivial

R5
// VP of the team he is going to build, including two new employers and another two senior one
// Give a huge list with strings (millions of), and an Englished dictionary
// Check whether the string is in the dictionary, whether it is an compound word, 
// e.g. blackboard, both BLACK and BOARD are words in dict
trivial, O(n*m) m is the length of the string
// improve?
in a dict the length of a word is not infinite, record the largest word in the dict
cache the dulpliate compound word
// Good but may not improve much
// consider that the dict is a serves you can used, not a map or something, how to improve
multi thread
// How? Do you know thread pools? 
No
// OK then lets talk on something else
// difference between string in Unicode with UTF-8? 
I know that one of them length of bytes to represent a char may change, the other is fixed
and will cause problem but actually remember it the wrong way.
// CJKT? Chinese, Japanese, Korea, Thai, how to deal those characters, not English any more
byte array with a given number to record the number of bytes needed for a character

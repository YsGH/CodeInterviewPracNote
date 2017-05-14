// Find the SUM of contiguous subarray within a one-dimensional array of numbers which has the largest sum
// Example from this array [−2, 1, −3, 4, −1, 2, 1, −5, 4]

int largestSub (int[] array) {
    if (array==null || array.length==0) {
        throw new IllegalArgumentException();
    }
    int max=array[0];
    int cur=array[0];
    for (int i=1; i<array.length; i++) {
        cur+=array[i];
        cur=Math.max(array[i],cur);
        max=Math.max(max, cur);
    }
    return max;
}

// what kind of test case you will use?
// {-1, -2, -3, 0}
// {-3, -1, -2}
// {99, -100, 99, -90, -8, 99}

// Reverse words in a String //
// My   name is Zhen --> Zhen is name   My

String reverse(String s) {
    if (s==null && s.length()==0) {
        return s;
    }
    String[] array=s.split(" ");
    StringBuilder sb=new StringBuilder();
    int n=array.length;
    for (int i=n-1; i>0; i++) {
        sb.append(array[i]);
        sb.append(" ");
    }
    sb.append(array[0]);
    return sb.toString();
}

// what kind of test case you will use?
// " "
// ""
// "abc"
// "ab bc cd"
// "  ab bc cd  " 

// Reverse individual sub-strings in a string //
// My name is Zhen --> yM eman si nehZ //

String newReverse (String s) {
    if (s==null && s.length()==0) {
        return s;
    }
    StringBuilder sb=new StringBuilder(s);
    return reverse;
}
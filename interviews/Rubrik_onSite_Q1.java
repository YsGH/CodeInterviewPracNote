Q1:
// Find the SUM of contiguous subarray within a one-dimensional array of numbers which has the largest sum
// Example from this array [−2, 1, −3, 4, −1, 2, 1, −5, 4]

// pretended I did not see it before...

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

// Follow-up, how much there is minimum requirement for the length of the subarray k
// consider input is always legal, no overflow issue (I mentioned)

int largestSub (int[] array, int k) {
    if (array==null || array.length==0) {
        throw new IllegalArgumentException();
    }
    int max=array[0];
    int cur=sum of array[0] to k-1
    for (int i=k; i<array.length; i++) {
        update cur
        cur=Math.max(array[i],cur);
        max=Math.max(max, cur);
    }
    return max;
}

Q1a
// on concurrency coding, how to use wait() and notify(). I told the interviewer that I do not have
// much experience on concurrency coding, and I might be more familiar with golang currency with chanell
// I introduced channel to the interviewer, it turns out the question is basically to make blocking queue
// while in golang channel wiil do the job...

// if we use Golang, the question will be trivial...
func push(ch channel, ) {
    while true {
        ch<-newData
    }
}

func pop(ch channel) {
    while true {
        d:=<-ch
        push d
    }
}
// so we use java, since the interviewer made this question during the interview, so I did not write the code this clean

// assume data's length is infinite, infinite size of blocking queue, so push does no wait
pesudo code writing with notify and wait shown blow
thread push(Data d) {
    while true {
        get d.lock {
            d.write()
        }
        notify(); //notify other waiting threads, in this case the pop thread
        release d.lock;
    }
}

thread pop(Data d) {
    while true {
        get d.lock {
            if d.isEmpty() {
                release d.lock
                wait(); //stopped here until further notified
            } else {
                d.read()
                release d.lock
            }
        }
    }
}

// I think it is better to know some basic ideas on concurrency coding, thread, process, lock, blocking queue, thread pool





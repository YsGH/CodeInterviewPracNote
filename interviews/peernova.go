// implement merkle tree for hashing
// https://en.wikipedia.org/wiki/Merkle_tree

package merkle

import (
        "hash/fnv"
		"strconv"
)

// Node is a node/atom of a list 
type Node struct {
	data []byte
}

func hash(d *Node) uint32 {
        h := fnv.New32a()
	    h.Write(d.data)
        return h.Sum32()
}

func newNodeInt(d int64) *Node {
	// This part I made it arbitrarily
	return &Node{
		data: []byte(strconv.FormatInt(d,10)),
	}
}

// TopHash returns the top hash
func TopHash (n []*Node) uint32{
	l:=len(n)
	if !legal(l) {
		panic("illegal")
	}
	for l!=1 {
		s:=make([]*Node, l/2);
		for i:=0;i<l;i+=2 {
			h1:=hash(n[i])
			h2:=hash(n[i+1])
			s=append(s, newNodeInt(int64(h1+h2)))
		}
		n=s;
	}
	return hash(n[0])
}

func legal(n int) bool {
	if n==0 {
		// no data, considered illegal
		return false
	}
	for n&1==0 {
		n=n>>1
	}
	return n==1
}

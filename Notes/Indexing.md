# Indexing

- ## Ordered indices: Based on sorting the values.
- ## Hash indices: Based on a uniform distibution of values across a range of buckets.

## Factors:
- Access type; Specific vs range.
- Access time
- Insetion time
- Deletion time
- Space overhead

### Search key: set of attributes used to look up records in a file.

## Types
- ### Dense index: Every searchkey value has a corresponding index entry. 
    In a dense clustering index, only the pointer to the first record with the given searchkey value needs to be stored, but for nonclustered indices, pointers to each such record are necessary.
- ### Sparse index: Not dense.
    Only for clustered indices. Nonclustered ones must be dense. Usually only contains one entry per block.

### Multilevel indices: Should the index itself outgrow the main memory, we can treat it like any ther file and create another index on it. Since the inner index will be ordered, the outer index may be sparse. Naturally, we can repeat this as many times as necessary.

### Clustered Index: If the file containing the indexed record is sequentially ordered, a clusterng index is one whose search key defines the sequential order of the file. This search key is often the primary key.

## Index updates
- First, the system performs a lookup with the given searchkey value. Then,
- ### Insertion:
  - Dense:
    - If value new, insert as appropriate. New index entry at correct position with pointer to record.
    - else if clustered, append to records with same searchkey value. No change to index.
    - else if unclustered, insert record as appropriate and add pointer to index.
  - Sparse:
    - update sparse index to point to first entry in blocks including and after the one into which the new record was inserted. 
    - If last, or new block created, add pointer to last record to index.
- ### Deletion:
  - Dense: 
    - If current record only record with given searchkey value, delete from index.
    - else if nonclustered, deletes corresponding pointer.
    - else if current record is first for value, sets pointer to next record.
    - else nothing
  - Sparse:
    - update sparse index to point to first entry in blocks including and after the one from which the record was deleted. 

#### Update = Deletion, then insertion.

## BTrees

### Structure:
- Leaf: i'th pointer points to location of record containing i'th value. Last pointer points to right sibling.
- Internal: Each level of the BTree represents a sparse index over the level below. i'th value is equal to first value of subtree that i + 1'th pointer points to. First value is less than last value of subtree that the first pointer points to.

### Operations:
- Query: 
```
    FIND_LEAF(v):
        C ← root
        while C internal:
            i ← greatest st v ≥ C.K[i]
            if i == |K|
                C ← Last nonnull pointer in C.P
            else
                C ← C.P[i + 1]
    FIND(v):
        C ← FIND_LEAF(v)
        if ∃ i | C.K[i] == v
            return C.P[i]
        else return null 
```
- Range Query: 
  - Return all values ∈ [lb, ub].
```
    RQ(u, v):
        A ← FIND_LEAF(u)
        B ← FIND_LEAF(v)
        result = {}

        U ← A.P[i] for least i where A.K[i] ≥ u
        V ← B.P[i] for greatest i where B.K[i] ≤ v 

        while U ≠ V
            result ∪= U
            if U at end of K
                A = Right sibling of A
                U = A.P[0]
            else
                U = Next element of A.P
        result ∪= V

        return result
```
- Insert:
```
    INSERT(V, P):
        if tree empty, trivial.
        L ← FIND_LEAF(V)

        if L has < n - 1 values, INTO_LEAF(L, V, P)
        else
            make new node L'
            create memory buffer T, copy L.K into T and INTO_LEAF(T, V, P).
            L'.next ← L.next and L.next ← L'
            copy first half of T into L and rest into L'
            INTO_PARENT(L, L'.K[0], L')
    
    INTO_LEAF(L, V, P):
        i ← greatest where L.K[i] ≤ V.
        insert V into L.K after position i
        insert P into L.P after position i + 1

    INTO_PARENT(N, K', N'):
        if N was root, make new node R = &N, K', &N', R be the root. return.
        P ← N.parent
        if P not full, insert K', &N' after N.
        else
            Copy P into T. Insert K', &N' after N. 
            Make new node P'. 
            Let M be the median element in T.K
            Copy first half of T into P, second half into P'.
            INTO_PARENT(P, M, P')
```
- Delete:
```
Too complex, fuck it.
```

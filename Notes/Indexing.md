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

### Clustering Index: If the file containing the indexed record is sequentially ordered, a clusterng index is one whose search key defines the sequential order of the file. This search key is often the primary key.

- ## Dense index: Every searchkey value has a corresponding index entry. 
    In a dense clustering index, only the pointer to the first record with the given searchkey value needs to be stored, but for nonclustered indices, pointers to each such record are necessary.
- ## Sparse index: Not dense.
    Only for clustered indices. Nonclustered ones must be dense. Usually only contains one entry per block.

## Multilevel indices: Should the index itself outgrow the main memory, we can treat it like any ther file and create another index on it. Since the inner index will be ordered, the outer index may be sparse. Naturally, we can repeat this as many times as necessary.

## Index updates
- ### Insertion:
  - First, the system performs a lookup with the given searchkey value. Then,
  - Dense:
    - If value new, insert as appropriate. New index entry at correct position with pointer to record.
    - else if clustered, append to records with same searchkey value. No change to index.
    - else if unclustered, insert record as appropriate and add pointer to index.
  - Sparse:
    - update sparse index to point to first entry in blocks including after the one into which the new record was inserted. 
    - If last, or new block created, add pointer to last record to index.
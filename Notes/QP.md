# Query Processing

## Steps:
- Parsing and translation → Relational algebra expression
- Optimization → Query execution plan ≡ {evaluation primitives}
- Evaluation → Query result

### Pipeline: Spooling, basically.

## Cost : Minimize resource-consumption
### Notation
- $t_s$: Avg access time
- $t_t$: Avg block transfer time.
- b: #blocks
  - $b_r$ blocks in relation
- n: #records
- M: #blocks in memory

## Selection
- Linear search: Universal, but slow. $T = t_s + b ⋅ t_t$
- BTree: $T = (h_i + 1)(t_s + t_t)$
- Primary BTree fetch-multiple: Since the b blocks are sequential (whole point of primary-secondary dichotomy), only one $t_s$ needed to access. $T = h_i (t_s + t_t) + t_s + b ⋅ t_t$
- Secondary BTree fetch-multiple: Each record can potentially be on a different block, so $T = (h_i + n)(t_s + t_t)$
- Bitmap scan: Cool shit. So take a bitstring and set to 1 all blocks that contain good tuples (find the blocks with secondary index) and then do linear scan in blocks, since they smoll. Postgres mejik.
- Complex
  - If only some have indices, then select those using those, and in te memory bbuffer test retreived records for the rest of the conditions.
  - Composite index makes things way easier.
  - Pointer intersection/union: Get only pointers, not the entire records, and intersect/unify those. Then test for remaining conditions.

## Sorting: External merge sort.
- Generalisation of mergesort.
- So you bring the relation into memory in portions (as much as the buffer can fit, say M blocks) and sort each batch, then store into a separate file for each run.
- Then you bring $b_b$ blocks from $⌊\frac{M}{b_b}⌋ - 1$ runs into memory (extra block for writing output, which will then be written to file) and merge them into a single run. Keep going until you have one file with the entire relation.
- Analysis:
  - So you have $⌈\frac{b_r}{M}⌉$ runs generated in the first stage, i.e twice as many block transfers. This corresponds to $⌈log_{⌊\frac{M}{b_b}⌋}\frac{b_r}{M}⌉$ passes, each of which do one read and one write for each block in the relation.
  - So $⌈\frac{b_r}{b_b}⌉ (2⌈log_{⌊\frac{M}{b_b}⌋}\frac{b_r}{M}⌉ - 1)$ block transfers for run merging. The -1 is because the last run can produce the sorted output without writing to disk.
  - Total: $2⌈\frac{b_r}{M}⌉ + ⌈\frac{b_r}{b_b}⌉ (2⌈log_{⌊\frac{M}{b_b}⌋}\frac{b_r}{M}⌉ - 1)$

## Joins
- Brute-force with nested loops - too many block reads, as the blocks in relation of the inner loop being reread each iteration.
  - Solution: Read block from outer, then from inner, then do pairwise checking. Improvement since each block from inner loop read once per outer loop relation block, not outer loop relation tuple.
  - Naturally, further improvement by reading more of outer loop relation at a time.
  - Analysis: $⌈\frac{b_r}{b_b}⌉ b_s + b_r$ transfers and $2⌈\frac{b_r}{b_b}⌉$ seeks.
- Indexes!
- Merge-join: First sort both, then one pass through the relations yields the join.
  - Hybrid 
- Hash-join: Hash req. attributes, put into buckets. Two sets of bucket, compare pairs in i'th bucket of R with i'th bucket of S. Add if equal.
  - Analysis
  - Hybrid
- Complex
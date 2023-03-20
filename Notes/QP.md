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
- n: #records
## Selection
- Linear search: Universal, but slow. $T = t_s + b ⋅ t_t$
- BTree: $T = (h_i + 1)(t_s + t_t)$
- Primary BTree fetch-multiple: Since the b blocks are sequential (whole point of primary-secondary dichotomy), only one $t_s$ needed to access. $T = h_i (t_s + t_t) + t_s + b ⋅ t_t$
- Secondary BTree fetch-multiple: Each record can potentially be on a different block, so $T = (h_i + n)(t_s + t_t)$
- Bitmap scan: Cool shit. So take a bitstring and set to 1 all blocks that contain good tuples (find the blocks with secondary index) and then do linear scan in blocks, since they smoll.

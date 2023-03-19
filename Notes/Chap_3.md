# Intro to SQL

### History
- IBM (System R)
- BEcame SQL
- Versions -86, -89, -92, -1999, -2003

### Parts
- DDL view def
- DML
  - Teg. contraints
  - TRansac cont.
  - Emb, dyn SQL
  - Auth.

### DDL
- Schema for rel.
- type of val. for each attr. 
- teg. constraints.
- set of indices for each rel.
- auth info for rel
- physical storage structure for each rel on disk

# SQL things

### Aggregate funcs
-  operate on the multiset of values of a column of a relation, and return a value
-  .
   -  avg
   -  min
   -  max
   -  sum
   -  count
- group-by
  - finds avg salary of intstructors in each dept, gives a table
- having
  -  predicates in the having clause are applied after the formation of groups whereas predicates in the where clause are applied before forming groups
  
### Nesting subqueries
select $A_1, A_2, \ldots A_n$
from $r_1, \ldots, r_m$
where P
- each $A_i$ can be replaced by a subquery that generates a single value
- each $r_i$ can be replaced by any subquery
- P can be replaced with an expression of the form:
B $⟨operation⟩$ (subquery)
B is an attribute and $⟨operation⟩$ to be defined later.

### Set membership: in, not in
### Set comparison: some, all (coupled with relational operator, $≡ ∃, ∀$) and negations

### Correlation: You name group formed by select


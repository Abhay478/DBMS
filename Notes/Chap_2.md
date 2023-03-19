# Intro to RDB
- Structure
- Schema
- Keys
- Sc. diag.
- Rel. Query lang
- Rel. alg.

### Attributes
- has domain
- Atomic
- null exists, => unknown
- Effing headache

#### Relation : set of attributes i.e. unordered.

### Keys
- Let $K ⊆ R$, R is a row.
- K is a superkey elements of key are suff. to uniq. identify the tuple of each relation.
- If K is superkey and minimal, then K is a *candidate key*.
- One cand. key is slected as *primary key*.
- #### foreign key : key in this rel is prim. key in other rel. $∀ tuples of foreign key in this rel, ∃ tuple of primary key in referenced rel with equal values $, e.g. dept_name in *instructor* references *name* in *dept* relation, and you can't have a dept_name in *instructor* which is not a name in *dept*.

### Rel. q. langs
- types
  - imperative : user instructs the system to perform a specific sequence of operations on the database to compute the desired result
  - functional : the computation is expressed as the evaluation of functions that may operate on data in the database or on the results of other functions
  - declarative : the desired information is typically described using some form of mathematical logic. It is the job of the database system to figure out how to obtain the desired information.
  
- pure :
  - functional
    - rel. alg. 
  - declarative
    - tuple rel. calculus
    - domain rel. calc.

All of which are computationally equivalent.

### Rel. alg.
- Operators : seq(r) -> r, r = relation.
  - selection : $σ_p : T → T$ shaves off rows.
  - project : $Π | Π : T → T$ shaves off columns.
  - Union : $∪ | (t, t) → t$ 
  - Set diff. : $-$
  - Cart. prod. : $× | (r, r) → r$
  - rename : $ρ$
- Select : Selects tuples satisfying predicate
  - Notation : $σ_p(r)$
- Project : Returns arg. with some attr. left out.
  - Notation : $Π\{seq A, A \in r\}(r)$
- Product : Resultant tuple constructed from each possible pair of tuples in args. Most tuples are untrue.
  - Join : Removes untrue tuples, $\Join_p = σ_p ∘ ×$, where p is the appropriate predicate.
- Union : Operands should be compatible, i.e. same # columns, same datatype for corr. attribute..



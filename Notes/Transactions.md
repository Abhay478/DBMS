# Transactions

## ACID
- Atomicity: All or none, recovery system
- Consistency: Isolated exec. of a T preserves consistency
- Isolation: Despite concurrent execution of transactions, system guarantees that for each $T_i$ and $T_j$, it appears to both that the other either hasn't begun execution or has completed it.
- Durability: The changes made by a transaction persist even after system failures.

#### Compensating transaction: To undo the effects of a prior transaction.

## Transaction states:
- Active: while executing
- Partially committed: after final statement executed.
- Failed: after discovery that normal execution cannot proceed.
- Aborted: after the transaction has been rolled back and database restored to previous state
- Committed: after successful completion.

## Serializability
- ### Serial schedule: Giiven an active transaction, every other transaction must either be terminated or uninitiated. Clearly, be n!.
- ### Serializable: Equivalent to serial in some sense.
- ### Conflict: A pair of instructions from different transactions acting on the same data item conflict if one of them is a write.
- ### Conflict equivalence: If a series of swaps of non-conflicting instructions S → S', then S and S' are conflict-equivalent.
- ### Conflict serializability: We say that a schedule S is conflict-serializable if it is conflict-equivalent to a serializable schedule.
- ### Precedence graph: G = ({all transactions}, {$T_i$ → $T_j$ st ∃ conflicting a ∈  $T_i$, a' ∈ $T_j$ where a executes before a'})
- Thus, we can obtain a serializable schedule from a topological sorting of the graph. If none exists, i.e. graph has cycle, those can also be detected (linear in #edges)

## Atomicity and Isolation
- ### Recoverable schedule: ∀ ($T_i, T_j$) | $T_j$ reads data written by $T_i$, $T_i$ is committed before $T_j$.
- ### Cascading rollback: Phenomenon where a single failure leads to a series of rollbacks.
- ### Cascadeless schedule: ∀ ($T_i, T_j$) | $T_j$ reads data written by $T_i$, $T_i$ is committed before $T_j$ reads the data.
- ### Isolation levels:
  - Serializable
  - Repeatable read: Ensures that between two reads of a data item by a transaction, no other transaction may update it.
  - Read committed: Allows only committed data to be read.
  - Read uncommitted
- All these levels disallow dirty writes, viz. writes to data item which was written to by an uncommitted transaction.
- ### Implementation:
  - Locking
  - Timestamps
  - Snapshot isolation: Overkill.
- ### Phantom pheomenon: where clause induces ambiguity in the set of tuples a transaction interacts with, viz. when an update to a tuple or a new tuple would have been included by where if it had executed first. Conflict caussed by a tuple that does not exist.
- ### Predicate locking: Say CUD statements conflict with predicate from a where clause, and use locks accordingly.
# Concurrency

## Locks
- Shared: r
- Exclusive: rw
- Upgrade: S → X
- Downgrade: x → S

### Locking protocol: {rules} that indicate when a transaction may lock and unlock {items}. This restricts #schedules
- $T_i$ precedes $T_j$ if ∃ Q st $T_i$ has held lock-A on it and $T_j$ has held lock-B on it later, and the lock modes are incompatible. 
- Schedule S is legal under a given locking protocol if S is a possible schedule for a {transactions} that folow the protocol.
- Locking protocol ensures serializability iff all legal schedules are conflict serializable.


### Two-phase locking protocol
- Growing phase: Obtain/upgrade, don't relase.
- Shrinking phase: Release/downgrade, don't obtain.
- Strict 2-plp: All X-locks held until commit. Ensures cascadeless rollbacks, coz data is locked and can't be read by other transactions until lock is released, which is at commit.
- Rigorous 2-plp: All locks held until commit.
- ### Lock manager
  - Hash table of data items(with chaining if two items hash to the same value).
  - Each data item maintains a queue of transactions.
  - Viewed as a process that accepts lock/unlock requests and send out grants or aborts (deadlocks).
  - For each lock request, the manager enqueues the record onto the wait queue of that specific data item (or creates a new queue). This is dequeued once the transaction sends an unlock request/aborts.


### Tree protocol: graph-based, only X-lock
- Impose partial ordering on {data items} to get a DAG, called the database graph.
- Initial lock by any transaction unrestricted.
- Subsequently, a transaction may lock Q only if it holds a lock on Q.parent
- Unlock unrestricted, re-lock disallowed.
- Pro: Avoids deadlock.
- Con: Could acquire unnecessary locks.

## Deadlocks
- Prevention:
  - Lock-ordering
  - Timestamps
    - wait-die: Younger process killed if waiting for older.
    - wound-wait: Younger process rolled back if older waiting for it.
  - Timeouts: Rollback and restart if long wait.
- Detection and recovery
  - Detection through cycle-checking in a wait-for directed graph.
  - Recovery: 
    - Select victim(s) which minimize cost (#transactions, #data items, duration of execution). This may cause starvation.
    - Total/partial rollback.

## Multiple granularity
- Nested data item hierarchy - data items children of {data items} children of {{data items}}...
- Only need to lock one node.
- Intention locks: when locking request made for a node, lock it and it's descendants with lock-X or lock-S, and lock ancestors with lock-IX or lock-IS

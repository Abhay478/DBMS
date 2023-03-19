# DBMS I

## Applications:
- Enterprise information
    Sales, accounting, HR
- Manufacturing:
    Inventory, Supply chain
- Banking and Finance
  - Customer information
  - transaction information
- Universities:
    Registration, grades.
- Airlines
- telecom
- Web services
- Navigation systems

## Drawbacks of file-base data storage
- Data Redundancy
  - Same data in multiple files
- Access difficulty :
    - Need to write new program for each insertion
- Data isolation:
    - Multiple files and formats
- Integrity problems
  - Non-explicit constraints
  - Hard to add new ones
- Inconsistency
  - Atomicity
  - Concurrent access

## Data models

A collection of tools for describing
- Data
- Data relationships
- Data semantics
- Data constraints

### Namely,

- Relational
- Entity-Relationship 
- Object based
- Semistructured (XML)
- Network
  - older
- Hierarchial
  - older



## Architecture 
- view level : us
- logical level : Admin
- physical level : Next course.

#### Schema : overall structure of DB
- logical
- physical

#### Instance : Actual content of a given DB

#### Physical data independence : Ability to modify PS wo modifying LS.

***

## DDL : Data definition language
#### Data dictionary:
- Schemas
- Constraints
- Auth

## DML : Data manip. lang.
- Procedural : user specifies data and data acquisition mech.
- Declarative : Data acq. left to software

## SQL

Nonprocedural.

`Query: {Tables} --> One table`

Not Turing complete.

Usually embedded in other languages.

### Design:
- Logical - choice of schema
  - Business - content
  - CS - Algo
- Physical

## Engine
- ### Storage Manager
  - #### Tasks
    - Interacts with OS FS
    - Effecient data manip.
  - #### Components
    - Auth/Teg manager.
    - Transaction "
    - File "
    - Buffer "
  - #### DS
    - Files
    - Dictionary (metadata)
    - Indices
- ### Query Processor
  - DDL Interpreter : records definitiions in dictionary
  - DML compiler : converts stuff to  low level instructions
  - Evaluation engine : executes low level instructions after compilation.
- ### Transaction man.
  - #### Transaction : A coll. ops performing a single logical func in a DB.
  - Tr. man. ensures that database remains consistent despite sys/tr. failures.
  - Conc. man. ensures concurrent transactions interact such that DB remains consistent.

## Database Arch.
- Centralized
  - Few cores, shared mem
- Client-server
- Parallel
  - Many cored
  - share mem/disk/nothing
- Distributed
  - Non-localised
  - Schema heterogeneity

### Tiers
- #### 2 : App on client, invokes DB functionality in server.
- #### 3 : client acts as frontend, no direct database calls.
  - Client interacts with server through a forms interface
  - Server communicates with DB to get data.

### People
- #### Admin
  - Schema def.
  - Storage sttructure and access method def.
  - schema and phy. org. mod'n
  - Auth granting
  - routine maint.
  - backing up
  - Ensuring disk unfull
  - ensuring peak performance by monitoring tasks
- #### User
  - . Nobody cares.

---


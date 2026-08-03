#  Core Java Roadmap

---

# 1. Java Fundamentals

- Primitive Data Types
- Non-Primitive Data Types
- Types of Variables
- Literals
- Operators
- Type Casting
- Wrapper Classes
- Auto-boxing and Unboxing
- Control Flow Statements
- Switch
- Arrays
- Methods
- Packages
- Import
- Access Modifiers
- Command Line Arguments

---

# 2. Object-Oriented Programming (OOP)

- Classes and Objects
- Constructors
- this Keyword
- super Keyword
- Static Keyword
- Static Block
- Instance Initializer Block (IIB)
- final Keyword
- Object Creation

### Object Class

- equals()
- hashCode()
- toString()
- clone()
- getClass()

### OOP Concepts

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces

### Inner Classes

- Member Inner Class
- Static Nested Class
- Local Inner Class
- Anonymous Inner Class

### Other Topics

- instanceof Operator
- Pattern Matching (instanceof)
- Singleton Class
- Immutable Class
- Sealed Classes
- Enum
- Records

---

# 3. Strings

- String
- String Pool
- StringBuilder
- StringBuffer

---

# 4. JVM & Memory

- JVM Architecture
- Class Loader
- Runtime Data Areas
- Execution Engine
- JIT Compiler
- Garbage Collection (GC)

---

# 5. Exception Handling

- Exception Handling
- Checked Exceptions
- Unchecked Exceptions
- try-catch-finally
- throw
- throws
- Custom Exceptions
- try-with-resources

---

# 6. File Handling

- Files I/O
- Serialization
- Deserialization
- transient Keyword

### NIO

- Path
- Paths
- Files

---

# 7. Collections Framework

```text
Iterable
│
└── Collection
    │
    ├── List
    │   ├── ArrayList
    │   ├── LinkedList
    │   ├── Vector
    │   ├── Stack
    │   └── CopyOnWriteArrayList
    │
    ├── Set
    │   ├── HashSet
    │   ├── LinkedHashSet
    │   ├── TreeSet
    │   ├── EnumSet
    │   ├── CopyOnWriteArraySet
    │   └── ConcurrentSkipListSet
    │
    └── Queue
        ├── PriorityQueue
        ├── LinkedList
        ├── ArrayDeque
        ├── ConcurrentLinkedQueue
        ├── BlockingQueue
        │   ├── LinkedBlockingQueue
        │   ├── ArrayBlockingQueue
        │   ├── PriorityBlockingQueue
        │   ├── DelayQueue
        │   ├── SynchronousQueue
        │   ├── LinkedTransferQueue
        │   └── LinkedBlockingDeque
        │
        └── Deque
            ├── ArrayDeque
            ├── LinkedList
            ├── ConcurrentLinkedDeque
            └── LinkedBlockingDeque
```

### Map Interface

```text
Map
│
├── HashMap
├── LinkedHashMap
├── TreeMap
├── Hashtable
├── WeakHashMap
├── IdentityHashMap
├── EnumMap
├── ConcurrentHashMap
└── ConcurrentSkipListMap
```

### Other Topics

- Generics
- Iterator
- ListIterator
- Spliterator
- Comparable
- Comparator
- Collections Utility Class
- Arrays Utility Class
- Fail-Fast Iterator
- Fail-Safe / Weakly Consistent Iterator

---

# 8. Modern Java

### JPMS (Modules)

- module-info.java
- requires
- exports
- opens
- requires transitive
- provides
- uses

### Language Features

- var
- Switch Expressions
- Text Blocks
- Pattern Matching (instanceof)
- Pattern Matching (switch)
- Records
- Sealed Classes
- Sequenced Collections
- Virtual Threads

### Functional Programming

- Reflection API
- Annotations
- Lambda Expressions
- Functional Interfaces
  - Predicate
  - Function
  - Consumer
  - Supplier
- Method References
- Streams
- Optional

---

# 9. Multithreading

- Multithreading
- Thread Lifecycle
- Thread Creation
- Synchronization
- Concurrent Package

---

# 10. JDBC

- JDBC Architecture
- DriverManager
- Connection
- Statement
- PreparedStatement
- CallableStatement
- ResultSet
- Transactions
- Batch Processing

---

# 11. Design Patterns

- Singleton
- Factory
- Builder
- Prototype
- Adapter
- Decorator
- Facade
- Proxy
- Strategy
- Observer
- Command
- MVC

---

# 12. Servlets

- Servlets

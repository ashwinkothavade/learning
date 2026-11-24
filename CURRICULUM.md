# 56-Day Curriculum (source of truth for the daily lesson)
Languages: OOP, SOLID, patterns, LLD, concurrency = Java; DSA = C++; AI and project = Python. Time split and rules: PLAN.md.

## Week 1 — OOP Foundations
1. Classes, objects, encapsulation, invariants
2. Constructors, object lifecycle, initialization, copying vs references, equals/hashCode, resource handling (Java counterpart of RAII)
3. Inheritance, composition, aggregation, object relationships
4. Polymorphism, virtual dispatch, interfaces, how method dispatch works (vtable idea)
5. Abstraction, coupling, cohesion, dependency direction
6. SOLID: SRP, OCP, LSP
7. SOLID: ISP, DIP, weekly review
## Week 2 — Design Principles and Patterns
8. UML class diagrams, requirements to classes
9. Creational: Factory, Abstract Factory, Builder, Singleton and trade-offs
10. Structural: Adapter, Decorator, Facade, Composite, Proxy
11. Behavioral: Strategy, Observer, State, Command
12. Template Method, Iterator, Chain of Responsibility
13. Refactoring, dependency injection, testability, anti-patterns
14. Review and timed LLD exercise
## Week 3 — Concurrency Foundations (Java)
15. Processes, threads, concurrency vs parallelism, race conditions
16. Java Memory Model: visibility, happens-before, volatile, atomics, ordering
17. Locks: synchronized, ReentrantLock, critical sections, deadlocks
18. wait/notify, Condition, producer-consumer, thread coordination
19. Read-write locks, shared state, contention, lock granularity
20. Future, CompletableFuture, executors, thread pools
21. Review, debugging, implementation exercise
## Week 4 — Advanced Concurrency and Reliability
22. Lock ordering, deadlock prevention, livelock, starvation
23. CAS, atomic classes, lock-free concepts
24. Thread-safe structures, concurrent queues
25. Parallel algorithms, task scheduling, backpressure
26. Cancellation, timeouts, graceful shutdown
27. Profiling, contention, throughput, latency
28. Concurrency design review and mock interview
## Week 5 — Backend and Database Fundamentals (AI and project tracks begin)
29. HTTP, REST, TCP basics, request lifecycle
30. AuthN vs AuthZ, sessions, tokens, OAuth
31. SQL schema design, indexes, query plans
32. Transactions, ACID, isolation levels, anomalies
33. Optimistic/pessimistic locking, MVCC, lost updates
34. Idempotency, retries, distributed consistency
35. Caching, Redis, invalidation, stampede
## Week 6 — Distributed Backend Systems
36. Message queues, Kafka, delivery semantics
37. Distributed transactions, outbox, saga
38. Rate limiting, quotas, throttling
39. Resilience: timeouts, retries, circuit breakers, bulkheads
40. Observability: logs, metrics, traces, SLOs
41. Security fundamentals, OWASP, input validation
42. Backend review and architecture exercise
## Week 7 — HLD and Production Engineering
43. Requirements, capacity estimation, API design, data modeling
44. Load balancing, horizontal scaling, stateless services
45. DB scaling: replication, partitioning, sharding
46. Queues, event-driven architecture, consistency trade-offs
47. Object storage, CDN, caching layers
48. Deployment, Docker, CI/CD, cloud architecture
49. End-to-end HLD review and timed design
## Week 8 — LLD Systems and Interview Readiness
50. Bank account and ledger LLD
51. Parking lot LLD
52. Movie ticket booking LLD
53. Inventory and reservation LLD
54. Rate limiter LLD
55. Full mock interview: DSA, LLD/HLD, behavioral
56. Final review, gap analysis, next 30-day plan

DSA across days: medium/hard, covering arrays, strings, hashing, two pointers, sliding window, binary search, stacks, queues, linked lists, trees, graphs, heaps, greedy, backtracking, DP. Do not repeat problems.
AI Engineering (from Week 5) and portfolio project: see the original spec topics (LLM basics, structured output, embeddings, RAG, tools, agents, evals, guardrails; FastAPI knowledge-assistant project). Deferred Day 1 material: archive/.

# Time Plan (applies from Day 2; Day 1 was delivered with the original 7-track split)

Decision (2026-11-24): fundamentals first. DSA is a strength, so it is kept as light maintenance. AI Engineering and the portfolio project start in Week 5, when the backend curriculum begins.

| Phase | DSA (C++) | Core SWE (Java) | LLD/HLD (Java for LLD) | AI (Python) | Project (Python) | Open source | Career | Total |
|---|---|---|---|---|---|---|---|---|
| Weeks 1-4 (Days 2-28) | 20 | 75 | 55 | 0 | 0 | 15 | 15 | 180 |
| Weeks 5-8 (Days 29-56) | 20 | 40 | 45 | 20 | 30 | 15 | 10 | 180 |

Notes
- DSA slot: one medium/hard problem or pattern per day, with emphasis on explaining trade-offs and handling follow-ups, not on easy problems. Weekly review covers weak patterns only.
- Core SWE: OOP, SOLID, patterns, concurrency (Java), then DBMS/OS/networking/backend as per curriculum.
- Open source: light repo exploration and reading in Weeks 1-4; first real contribution attempts from Week 5.
- Career: 10 min/day in Weeks 5-8 (behavioral stories, ownership and impact), plus the Day 55 mock and Day 56 review.
- After Day 56: the 30-day plan shifts weight to AI Engineering and project polish.

## Target level: Software Engineer 2 (mid-level)
Calibrate everything to SWE-2 interviews, not new-grad ones.
- DSA: medium and hard; expect two rounds. Must explain trade-offs, optimize, and handle follow-ups cleanly under time pressure.
- LLD: a working, extensible design in code (Java) in ~45-60 min: clean interfaces, patterns used for a reason, concurrency considered, tests. Not just a class diagram.
- HLD: expected at this level. Add one 10-min HLD drill per week in Weeks 1-4 (inside the LLD/HLD slot), e.g. URL shortener, rate limiter, notification service. Full HLD Weeks 5-7 as in the curriculum.
- Core/backend depth: DB internals (indexes, transactions, isolation), concurrency bugs, caching, queues, failure handling, observability. Questions are "how did you handle X in production" as often as "define X".
- Behavioral: ownership, impact with numbers, incidents and debugging, disagreement, mentoring juniors, scope and ambiguity. Build 6-8 STAR stories from real Akatsuki work.
- Every lesson should include at least one "production incident / trade-off" question, not only definitions.

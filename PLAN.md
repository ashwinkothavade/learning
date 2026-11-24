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

## Teaching format rules
- Every concept gets a relevant diagram: Mermaid blocks in the markdown files (GitHub renders them), ASCII in chat. Use class, sequence, state, flow and architecture diagrams as appropriate.
- Videos: when a topic is better learned by watching, the lesson has a "Watch (optional)" line naming the topic and a search phrase. Include the video link too. Find it with a web search and use only URLs that appeared in results (never invent or guess); say it was found by search and not reviewed in full.
- Exercise workspaces: every day, each exercise lives in a runnable skeleton file (Java for OOP/LLD/concurrency, C++ for DSA) in the matching track folder, e.g. `core-swe/day-NN/`, `lld/day-NN/`, `dsa/day-NN/`. Each file has TODOs, a `main` with tests (exit code 0 = pass), and a WRITTEN ANSWERS spot. A README gives run commands. daily/day-NN.md links to these files instead of repeating exercises. Verify that skeletons compile and fail before delivery; never pre-fill solutions.

## Explanation style (user request: teach as if a complete beginner)
- Assume no prior knowledge. Define every term and every keyword in code the first time it appears; use everyday analogies, small steps, and a "Try it" after each step.
- Each new concept: analogy, tiny code, diagram, what goes wrong without it, then the interview question and a model answer.
- Put the beginner lesson in `core-swe/day-NN/LESSON.md` (and equivalents for other tracks); daily/day-NN.md links to it first.
- Interview focus stays: after the explanation, include timed interview questions, follow-ups and production-style questions.

## DSA files: LeetCode style (user request)
- Each DSA problem file reproduces the LeetCode page: title and link, statement, examples, constraints, follow-up, then the exact `class Solution` stub with LeetCode's signature (no `main` inside the part the user edits).
- A local harness below the class replaces LeetCode's judge: example and edge test cases, verdict lines "Accepted" / "Wrong Answer", any-order answers compared after sorting where LeetCode allows it. The user pastes the same class into LeetCode when done.
- Use LeetCode-supported includes explicitly (no bits/stdc++.h, it is missing on macOS clang).

# KWIC - Key Word In Context (All Architectural Styles)

This project contains four implementations of the KWIC system, each demonstrating a different software architecture style:

1. **Shared Memory (Main + Subroutines)**
2. **Object-Oriented (Abstract Data Types)**
3. **Event-Based (Implicit Invocation)**
4. **Pipes and Filters (Data Flow)**

---

## 📄 Common Input

All versions use the same input file:
```
input.txt
```

Example contents:
```
The quick brown fox
jumps over the lazy dog
Design patterns in software
Architecture matters a lot
```

---

## ▶ How to Compile and Run

You must have **Java (11 or above)** installed. Navigate to the folder of the architecture you want to run and follow the steps:

### 1. Shared Memory
```bash
cd shared_memory
javac KWIC_SharedMemory.java
java KWIC_SharedMemory
```

### 2. Object-Oriented
```bash
cd object_oriented
javac *.java
java KWIC_ObjectOriented
```

### 3. Event-Based
```bash
cd event_based
javac *.java
java KWIC_EventBased
```

### 4. Pipes and Filters
```bash
cd pipes_and_filters
javac *.java
java KWIC_PipesAndFilters
```

---

## 📂 Folder Structure

```
kwic_all_styles/
├── input.txt
├── shared_memory/
├── object_oriented/
├── event_based/
└── pipes_and_filters/
```

---



# 🛠️ KWIC Implementation Guide

This guide explains how each KWIC architecture was implemented and the design rationale behind it. Use this to understand the behavior of each style and to prepare for comparisons in your presentation or midterm.

---

## 1. 🔧 Shared Memory (Monolithic, Procedural)

### ✅ Key Characteristics:
- Uses **global shared variables**.
- Main function calls four sequential methods: `input()`, `circularShift()`, `alphabetize()`, `output()`.
- Each function modifies global state (`lines`, `shifts`).

### 📦 Code Structure:
- `KWIC_SharedMemory.java` contains all logic.
- No encapsulation: All functions and data are in the same class.

### 📌 Pros:
- Simple and efficient.
- Easy to trace flow linearly.

### ❌ Cons:
- Poor modularity and testability.
- Any change to data structure affects all functions.

---

## 2. 🧱 Object-Oriented (Abstract Data Types)

### ✅ Key Characteristics:
- Each responsibility is encapsulated in a class (`Input`, `CircularShifter`, `Alphabetizer`, `Output`).
- Main method orchestrates component calls.

### 📦 Code Structure:
- `KWIC_ObjectOriented.java` (driver)
- 4 separate Java classes implementing responsibilities.

### 📌 Pros:
- High modularity and reusability.
- Easy to extend (e.g., modify sorting logic in isolation).

### ❌ Cons:
- Slight overhead from class boundaries.
- Still relies on sequential orchestration in main.

---

## 3. 📣 Event-Based (Implicit Invocation)

### ✅ Key Characteristics:
- Components communicate through events.
- Uses a simple `EventManager` to register/listen to events.
- Loose coupling between components.

### 📦 Code Structure:
- `KWIC_EventBased.java` (entry point)
- `EventManager.java` for registration and dispatch
- Component classes register their actions to events.

### 📌 Pros:
- Highly extensible (just register a new listener).
- No tight dependencies between modules.

### ❌ Cons:
- Flow is harder to follow (non-linear).
- Debugging can be complex due to indirect calls.

---

## 4. 🔁 Pipes and Filters (Data Flow)

### ✅ Key Characteristics:
- Each stage is a separate thread running a `Runnable` (e.g., `InputFilter`, `CircularShiftFilter`, etc.).
- Data is passed via `BlockingQueue` (Java pipe analog).

### 📦 Code Structure:
- `KWIC_PipesAndFilters.java` (starts threads)
- Each filter class reads from input queue and writes to output queue.

### 📌 Pros:
- Excellent for parallel/concurrent processing.
- Filters can be reused and reordered easily.

### ❌ Cons:
- Complex thread and queue coordination.
- Difficult to implement rollback or random access.

---

## ⚖️ Comparison Summary

| Feature             | Shared Memory | Object-Oriented | Event-Based     | Pipes & Filters |
|---------------------|----------------|------------------|------------------|-----------------|
| Modularity          | ❌ Low         | ✅ High          | ✅ Very High      | ✅ High          |
| Performance         | ✅ High        | ✅ High          | ⚠️ Medium         | ✅ High (with threads) |
| Reusability         | ❌ Low         | ✅ High          | ✅ Very High      | ✅ High          |
| Testability         | ❌ Poor        | ✅ Good          | ⚠️ Complex         | ✅ Good (per filter) |
| Extensibility       | ⚠️ Hard        | ✅ Moderate       | ✅ Easy (new events) | ✅ Easy (new filters) |
| Debugging Simplicity| ✅ Easy        | ✅ Easy          | ❌ Hard           | ⚠️ Moderate       |

---

## ✅ Final Notes

- All styles use `input.txt` to ensure consistent output.
- You may add a **stop word filter** or **interactive UI** to demonstrate extendability.
- Prepare architectural diagrams and justify the trade-offs in your report or midterm.

---

## 🧪 How to Verify Output

Each architecture should output the same sorted KWIC index like:



## 📧 Contact

For questions, feel free to reach out to Vivek

Happy coding!

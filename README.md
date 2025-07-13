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

## 📧 Contact

For questions, feel free to reach out to Vivek

Happy coding!

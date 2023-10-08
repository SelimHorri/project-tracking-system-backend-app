# Input Domain Modeling

## Function: `ProjectService.findById(final Integer projectId);`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Project` object from the repository by its project ID and returns it. Additionally, it should ensure that the function throws an `ObjectNotFoundException` when no Project object is found for the provided project ID.

### Information

- Parameters: `Integer`
- Return Type: `Project`
- Return Value: Object of `Project` according to the given id.
- Exceptional Behavior: Throw `ObjectNotFoundException` if the project does not exist.

### Interface-Based Characteristics

| Characteristics           | B1               | B2   | B3               |
|---------------------------|------------------|------|------------------|
| Refinement of `projectId` | Negative integer | Zero | Positive integer |

### Functionality-Based Characteristics

| Characteristics                 | B1   | B2    |
|---------------------------------|------|-------|
| Target `Project` is found       | True | False |
| Throw `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                 | B1               | B2    | B3               |
|---------------------------------|------------------|-------|------------------|
| Refinement of `projectId`       | Negative integer | Zero  | Positive integer |
| Target `Project` is found       | True             | False |                  |
| Throw `ObjectNotFoundException` | True             | False |                  |

### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 | A3 |
| B               | B1 | B2 |    |
| C               | C1 | C2 |    |

### Combined Partitions

Using **All Combinations (ACoC)** approach will have 12 test cases.

|          | COL1         | COL2         | COL3         | COL4         | COL5         |
|----------|--------------|--------------|--------------|--------------|--------------|
| **ROW1** | (A1, B1, C1) | (A1, B1, C2) | (A1, B2, C1) | (A1, B2, C2) | (A2, B1, C1) |
| **ROW2** | (A2, B1, C2) | (A2, B2, C1) | (A2, B2, C2) | (A3, B1, C1) | (A3, B1, C2) |
| **ROW3** | (A3, B2, C1) | (A3, B2, C2) |              |              |              |

### Derived Test Values

|          | COL1             | COL2              | COL3              | COL4               | COL5             |
|----------|------------------|-------------------|-------------------|--------------------|------------------|
| **ROW1** | (-1, True, True) | (-1, True, False) | (-1, False, True) | (-1, False, False) | (0, True, True)  |
| **ROW2** | (0, True, False) | (0, False, True)  | (0, False, False) | (1, True, True)    | (1, True, False) |
| **ROW3** | (1, False, True) | (1, False, False) |                   |                    |                  |

---
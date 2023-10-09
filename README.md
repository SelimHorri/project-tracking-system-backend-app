# Input Domain Modeling

## Function: `LocationService.deleteById(final Integer locationId)`

### Testing Goal

The testing goal aims for deleted the `Location` from repository by location ID. Furthermore, If the provided location ID is not exit. The Function should throw an `ObjectNotFoundException`.

### Information

- Parameters: `locationId`
- Return Type: `None`
- Return Value: `None`.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the Location does not exist.

### Interface-Based Characteristics

| Characteristics            | B1               | B2    | B3               |
|----------------------------|------------------|-------|------------------|
| Refinement of `locationId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                               | B1   | B2    |
|-----------------------------------------------|------|-------|
| The target `Location` is  delete successfully | True | False |

### Merging Characteristics

| Characteristics                               | B1               | B2    | B3               |
|-----------------------------------------------|------------------|-------|------------------|
| Refinement of `locationId`                    | Negative integer | Zero  | Positive integer |
| The target `Location` is  delete successfully | True             | False |                  |


### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 | A3 |
| B               | B1 | B2 |    |

### Combined Partitions

Using **All Combinations (ACoC)** approach will have 6 test cases.

Base Choice = (A2, B1, C2)

|          | COL1     | COL2     |
|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) |
| **ROW2** | (A2, B1) | (A2, B2) |
| **ROW3** | (A3, B1) | (A3, B2) |

### Derived Test Values

|          | COL1       | COL2        |
|----------|------------|-------------|
| **ROW1** | (-1, True) | (-1, False) |
| **ROW2** | (0, True)  | (0, False)  |
| **ROW3** | (1, True)  | (4, False)  |

### Feasible Test Values / Expected Result

| Test        | Integer | Expected Result                                | 
|-------------|---------|------------------------------------------------|
| (1, True)   | 1       | Deleted, No Error                              |
| (4, False)  | 4       | Can't delete, Throws `ObjectNotFoundException` |
---

## Function: `LocationService.update(final Location location)`

### Testing Goal

Ensure that function must returns the details of `Location` when provided a exit Location object. Vice versa, it will throw an ObjectNotFoundException

### Information

- Parameters: `location`
- Return Type: `Location`
- Return Value: The specific `Location` that has updated some details.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the target location isn't exit.

### Interface-Based Characteristics

| Characteristics           | B1               | B2    | B3               |
|---------------------------|------------------|-------|------------------|
| `Location ` is null       | True             | False |                  |

### Functionality-Based Characteristics

| Characteristics                      | B1   | B2    |
|--------------------------------------|------|-------|
| New details of `Location ` has saved | True | False |

### Merging Characteristics

| Characteristics                      | B1   | B2    |
|--------------------------------------|------|-------|
| `Location ` is null                  | True | False |
| New details of `Location ` has saved | True | False |

### Blocks Abstraction

| Characteristics | B1 | B2 |
|-----------------|----|----|
| A               | A1 | A2 |
| B               | B1 | B2 |

### Combined Partitions

Using **All Combinations (ACoC)** approach will have 4 test cases.

|          | COL1     | COL2     |
|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) |
| **ROW2** | (A2, B1) | (A2, B2) |

### Derived Test Values

|          | COL1          | COL2           |
|----------|---------------|----------------|
| **ROW1** | (null, True)  | (null, False)  |
| **ROW2** | (False, True) | (False, False) |

### Feasible Test Values / Expected Result

| Test           | Location | Expected Result   | 
|----------------|----------|-------------------|
| (null, True)   | null     | Not update, Error |
| (False, True)  | Location | Updated, No Error |
| (False, False) | Location | Not update, Error |

---
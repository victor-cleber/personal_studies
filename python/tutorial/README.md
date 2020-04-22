# Skill Concepts

### Understanding Computer Programming
***
### Understanding Data Types in Python
***
### Understanding Decision Structures
***
### Python Loops
   1. while
* With the while Loop we can execute a set of statements as long as a condition is true.

Example 01: Print i as long as i is less than 6: 
```python
i = 1
while i < 6:
  print(i)
  i += 1 
```

Example 02: Print all letter of your name:
 
```python
name = 'Victor'
i = 0 

while i < len(name):
    print(name[i])
    i += 0 
```

* The break statement: we can stop the loop even if the while condition is true:

Example 03: Exit the loop when i is 5:
```python
i = 1
while i < 10:
  print(i)
  if i == 5:
    break
  i += 1
```
- The continue Statement: we can stop the current iteration, and continue with the next:

Example 04: Continue to the next iteration if i is 5:
```python
i = 0
while i < 10:
  i += 1
  if i == 5:
    continue
  print(i)
```
- The else Statement: we can run a block of code once when the condition no longer is true:

Example 05: Print a message once the condition is false:
```python
i = 1
while i < 6:
  print(i)
  i += 1
else:
  print("The condition is false")
```

   2. for

* With the for loop we can execute a set of statements, once for each item in a list, tuple, set etc.

***
### Understanding Exception Handling

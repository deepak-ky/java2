In Arrays 

    1. LHS can be
        a. int[] numbers
        b. int numbers[]

    2. RHS can be
        a. new int[5];
        b. {1,2,3,4,5};
        c. new int[]{1,2};

    3. You can also declare first and assign later, 
        but this is not applicable to 2(b) case


**Examples**

Focus on Case 9
<br>
<br>
<br>
✅ Style 1: int[] numbers (Preferred Java Style)

| # | Code                                               | Valid? | Notes                                                    |
|---|:---------------------------------------------------|:------:| :------------------------------------------------------- |
| 1 | `int[] numbers = new int[5];`                      |   ✅    | Declare and allocate in one line                         |
| 2 | `int[] numbers; numbers = new int[5];`             |   ✅    | Declare first, assign size later                         |
| 3 | `int[] numbers = {1, 2, 3};`                       |   ✅    | Declare and initialize using `{}` at the same time       |
| 4 | `int[] numbers; numbers = {1, 2, 3};`              |   ❌    | Invalid — cannot use `{}` without new after declaration |
| 5 | `int[] numbers = new int[]{1, 2, 3};`              |   ✅    | Declare and initialize using new with values            |
| 6 | `int[] numbers; numbers = new int[]{1, 2, 3};`     |   ✅    | Declare first, then assign using new with values       |

<br>
<br>
<br>
✅ Style 2: int numbers[] (C-style Java syntax)
<br>

| #  | Code                                           | Valid? | Notes                                                 |
|----|:-----------------------------------------------|:------:| :---------------------------------------------------- |
| 7  | `int numbers[] = new int[5];`                  |   ✅    | Declare and allocate in one line                      |
| 8  | `int numbers[]; numbers = new int[5];`         |   ✅    | Declare first, assign size later                      |
| 9  | `int numbers[] = {1, 2, 3};`                   |   ✅    | Declare and initialize using `{}` at the same time    |
| 10 | `int numbers[]; numbers = {1, 2, 3};`          |   ❌    | Invalid — cannot use `{}` without new after declaration |
| 11 | `int numbers[] = new int[]{1, 2, 3};`          |   ✅    | Declare and initialize using new with values         |
| 12 | `int numbers[]; numbers = new int[]{1, 2, 3};` |   ✅    | Declare first, then assign using new with values    |
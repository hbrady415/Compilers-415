# CS 415 Project 1

There have been a few issues formatting the parse trees please request the full pdf if you want to see a better view

# Spring 2020

You may use any programming language that runs on the ilab machines for
these problems.

1. Use a recursive descent parser to implement an interpreter for this (LL(1))
    arithmetic grammar:

```
〈Program〉 ::=〈StmtList〉.
```
```
〈StmtList〉::=〈Stmt〉 〈NextStmt〉
```
```
〈NextStmt〉::= ;〈StmtList〉 |
```
```
〈Stmt〉 ::=〈Assign〉 | 〈Print〉
```
```
〈Assign〉 ::=〈Id〉=〈Expr〉
```
```
〈Print〉 ::= !〈Id〉
```
```
〈Expr〉 ::= +〈Expr〉 〈Expr〉
| -〈Expr〉 〈Expr〉
| *〈Expr〉 〈Expr〉
| /〈Expr〉 〈Expr〉
| 〈Id〉
| 〈Const〉
```
```
〈Id〉 ::= a|b|c
```
```
〈Const〉 ::= 0| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```
```
The arithmetic operators indicate addition, subtraction, multiplication,
and (integer) division, respectively.
For example, on the input
```
```
a=3;b=2;c=+ab;!c.
```
```
Your program should print 5.
For invalid inputs, such as
```
```
a=+12;!a.b
```
```
you should print “syntax error”.
For runtime errors, print “exception”.
Please treat referencing a variable before it’s assigned a value as an error.
Note that all tokens are single characters, and you can assume we will not
include any whitespace, which should help simplify the scanner implemen-
tation.
```

2. Consider this grammar of boolean expressions:

```
〈Program〉 ::=〈Expr〉.
```
```
〈Expr〉 ::=〈Expr〉&&〈Expr〉
| 〈Expr〉 || 〈Expr〉
| 〈Expr〉ˆ〈Expr〉
| ∼ 〈Expr〉
| 〈Const〉
| (〈Expr〉)
```
```
〈Const〉 ::= F|T
```
```
where the expression operators denote AND, OR, XOR, and NOT, re-
spectively.
```
- What happens if you try to use this grammar in flex/bison?
- Modify the grammar to make flex/bison happy, without changing
    the language itself. Binary operators should have the precendence
    &&, ^, ||(highest to lowest) and be left associative.
- Use your modified grammar and flex/bison to implement an inter-
    preter for the language. For invalid inputs, you should print “syntax
    error”. For example, on inputF || T., you should printT. (justT,
    not the period)

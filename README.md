# Pascal
A Pascal Interpreter (with limitations)

##Getting Started

To run a program with this Antlr Grammar,

```
antlr4 PascalR.g4
javac PascalR*.java 
grun PascalR program <NAME_OF_TEST_FILE>
```
To get debugging print outs, run

```
grun PascalR debug <NAME_OF_TEST_FILE>
```

##Features Supported

* Enums
* Constants

* Primitive Types
* Strings
* Arrays (declaration only)

* Traditional Style Comments (*..*)
* Arithmetic
* Comparison
* Nested If-Then-Else and Case Statements

* Readln
* Writeln
* Exp
* Ln
* Sqrt
* Sin
* Cos

##Features To Be Implemented
* Dereference Arrays
* Modify Array Content
* Proper Loops
* Type Alias and Type Cloning
* String dereference Character

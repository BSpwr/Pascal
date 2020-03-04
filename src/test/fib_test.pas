program fib_test;
function fib_case(a:integer): integer;
begin
    case a of
        0: fib_case := 0;
        1: fib_case := 1;
        else
            fib_case := fib_case(a-1) + fib_case(a-2);
    end;
end;

function fib_if(a:integer): integer;
begin
    if (a = 0) then fib_if := 0
    else if (a = 1) then fib_if := 1
    else fib_if := fib_if(a-1) + fib_if(a-2);
end;

function TriangleArea(side1, side2, side3: real): real;
var
   s, area: real;
begin
   s := (side1 + side2 + side3)/2.0;
   area := sqrt(s * (s - side1)*(s-side2)*(s-side3));
   TriangleArea := area;
end;

begin
// TODO: Make a fib implementation with arrays and check against each other :)
writeln(fib_case(20));
writeln(fib_if(20));
writeln(TriangleArea(12.1,13,14));
end.
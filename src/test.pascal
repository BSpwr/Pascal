program calculator;
uses gol;

var F,L:real;
    b: boolean;
    i,j,n:integer;
    s:string;
    x:array[1..10] of real;
    y:array[1..10] of real;
const
  colMax = 76;
  rowMax = 22;
  dr = colMax+2;
  cDelay = 20;
  letterA = 'A';

begin
  b:=false;
  if (b <> 0) then
  begin
    b:=true;
    i:=0;
    j:=10;
    n:= j*10;
    F:= 0.01234;
    L:= sin(F);
    writeln(L);
    F:= cos(L);
    writeln(F);
    L:= sqrt(F);
    writeln(L);
  end
  else
  begin
    writeln('Enter a value:');
    readln(s,b);
    writeln('My value was: ',s,' and the value of b is ',b);
    (*This is a comment, this does not affect the code at all!*)
    if(b = true) then
        writeln('b was true!');
  end;
  writeln(n);
  writeln(i);
  writeln('test succeeded');
end
.

program calculator;
uses gol;

type meme = (cat, nyan, pepe);

var F,L:real;
    b: boolean;
    i,j,n:integer;
    s:string;
    x:array[1..10] of real;
    y:array[1..10] of real;
    m:meme;
    d:meme;

const colMax = 76;
      rowMax = 22;
      dr = colMax+2;
      cDelay = 20;
      letterA = 'A';

begin
  b:=false;
  d:=cat;
  if (b <> 1) then
  begin
    m:=pepe;
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
    case letterA of
        'C': writeln('Letter was C');
        'B': writeln('Letter was B');
    end;
    case letterA of
        'A': writeln('Letter was A');
        'B': writeln('Letter was B');
    end;
    case letterA of
        'C': writeln('Letter was C');
        'B': writeln('Letter was B');
        else
            writeln('Letter was not in case!');
    end;
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
  writeln('Enter a value:');
  readln(s,b);
  writeln('My value was: ',s,' and the value of b is ',b);
  (*This is a comment, this does not affect the code at all!*)
  if(b = true) then
      writeln('b was true!');
  if(m <> d) then
      writeln('enum works!');
  writeln(n);
  writeln(i);
  writeln('test succeeded');
end
.

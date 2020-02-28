program calculator;

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

  (*Nested Ifs*)
  writeln('Testing Nested Ifs');
  if (b <> true) then
  begin
    m:=pepe;
    b:=true;
    i:=0;
    j:=10;
    n:= j*10;
    F:= 30.0;

    readln(F);
    writeln('write');
    writeln(F);

    (*Functions*)
    writeln('Testing functions');
    writeln('Value to take the sine of: ');
    writeln(F);
    writeln(' degrees');
    L:= sin(F*(PI/180.0));
    writeln('Sin: ');
    writeln(L);
    L:= 45.0;
    F:= cos(L*(PI/180.0));
    writeln('Cos: ');
    writeln(F);
    L:= sqrt(F);
    writeln('Sqrt: ');
    writeln(L);
    L:=20.0;
    writeln('Value to take the natural log of: ');
    writeln(F);
    F:= ln(L);
    writeln('Ln: ');
    writeln(F);
    L:= exp(F);
    writeln('Exp: ');
    writeln(L);

    (*Case*)
    writeln('Testing Cases');
    writeln('Case 1: ');
    case letterA of
        'C': writeln('Letter was C');
        'B': writeln('Letter was B');
    end;
    writeln('Case 2: ');
    case letterA of
        'A': writeln('Letter was A');
        'B': writeln('Letter was B');
    end;
    writeln('Case 3: ');
    case letterA of
        'C': writeln('Letter was C');
        'B': writeln('Letter was B');
        else
            writeln('Letter was not in case!');
    end;
  end;

end
.
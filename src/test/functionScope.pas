program functionScope;

// global vars
var g : string = 'Im a global!';

procedure hi;
begin
    writeln(g);
    g := 'Global set';
end;

begin
hi();
writeln(g);
end.
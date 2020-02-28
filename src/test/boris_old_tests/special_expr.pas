program SpecialExprTest;
var
    val, another: integer;
    // nut: array [0..5] of integer;
begin

   val := 1337;

   if (true) then
   begin end
   else

    writeln(sqrt(val));
    writeln(sin(val));
    writeln(cos(val));
    writeln(ln(val));
    writeln(exp(val));

end.
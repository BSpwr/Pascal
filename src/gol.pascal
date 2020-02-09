program Gol;

uses
  crt;
 
const
  colMax = 76;
  rowMax = 22;
  dr = colMax+2;
  cDelay = 20;

type
  tFldElem  = byte;
  tpFldElem = ^tFldElem;
  tRow = array[0..colMax+1] of tFldElem;
  tpRow = ^tRow;
  tBoard = array[0..rowMax+1] of tRow;
  tpBoard = ^tBoard;
  tpBoards = array[0..1] of tpBoard;
 
type
  tIntArr = array[0..2*dr+2] of tFldElem;
  tpIntArr = ^tIntArr;
 
var
  aBoard,bBoard : tBoard;
  pBoards :tpBoards;
  gblActBoard : byte;
  gblUseTorus :boolean;
  gblGenCnt   : integer;
 
procedure PrintGen;
const
  cChar: array[0..1] of char = (' ','#');
var
  p0 : tpIntArr;
  col,row: integer;
  s : string[colMax];
begin
  setlength(s,colmax);
  gotoxy(1,1);
  writeln(gblGenCnt:10);
  For row := 1 to rowMax do
  begin
    p0 := @pBoards[gblActBoard]^[row,0];;
    For col := 1 to colMax do
      s[col] := cChar[p0[col]];
    writeln(s);
  end;
  delay(cDelay);
end;
 
procedure Init0(useTorus:boolean);
begin
  gblUseTorus := useTorus;
  gblGenCnt := 0;
  fillchar(aBoard,SizeOf(aBoard),0);
  pBoards[0] := @aBoard;
  pBoards[1] := @bBoard;
  gblActBoard := 0;
 
  clrscr;
end;
 
procedure InitRandom(useTorus:boolean);
var
  col,row : integer;
begin
  Init0(useTorus);
  For row := 1 to rowMax do
    For col := 1 to colMax do
      aBoard[row,col]:= tFldElem(random>0.9);
end;
 
procedure InitBlinker(useTorus:boolean);
var
  col,row : integer;
begin
  Init0(useTorus);
  For col := 1 to colMax do
  begin
    IF (col+2) mod 4 = 0 then
      begin
      For row := 1 to rowmax do
        IF row mod 4 <> 0 then
          aBoard[row,col]:= 1;
      end;
  end;
end;
 
procedure Torus;
var
  p0 : tpIntArr;
  row: integer;
begin
  p0 := @pBoards[gblActBoard]^[1,0];
  For row := 1 to rowMax do
    begin
    p0^[0] := p0^[colMax];
    p0^[colmax+1] := p0^[1];
    p0 := Pointer(PtrUint(p0)+SizeOf(tRow));
    end;
  move(pBoards[gblActBoard]^[1,0],pBoards[gblActBoard]^[rowMax+1,0],sizeof(trow));
  move(pBoards[gblActBoard]^[rowMax,0],pBoards[gblActBoard]^[0,0],sizeof(trow));
end;
 
function Survive(p: tpIntArr):tFldElem;
const
  cSurvives : array[boolean,0..8] of byte =
              ((0,0,0,1,0,0,0,0,0),   {alive =false 1->born}
               (0,0,1,1,0,0,0,0,0));  {alive =true  0->die }
var
  sum : integer;
begin
  sum := p^[0]+p^[1])+p^[2]);
  sum := sum+p^[dr+0]+p^[dr+2];
  sum := sum+p^[2*dr+0]+p^[2*dr+1]+p^[2*dr+2];
  survive := cSurvives[p^[dr+1],sum];
end;
 
procedure NextGen;
var
  p0,p1 : tpFldElem;
  row: NativeInt;
  col :NativeInt;
begin
  if gblUseTorus then
    Torus;
  p1 := @pBoards[1-gblActBoard]^[1,1];
  p0 := @pBoards[  gblActBoard]^[0,0];
  For row := rowMax-1 downto 0 do
  begin
    For col := colMax-1 downto 0 do
    begin
      p1^ := survive(tpIntArr(p0));
      inc(p0);
      inc(p1);
    end;
    inc(p1,2);
    inc(p0,2);
  end;
  gblActBoard :=1-gblActBoard;
  inc(gblGenCnt);
end;
 
begin
  InitBlinker(false);
  repeat
    PrintGen;
    NextGen;
  until keypressed;
  PrintGen;
end.
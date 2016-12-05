@echo off
Setlocal EnableDelayedExpansion
for %%f in (.) do (
set WERT=%%~nf
)
for %%A in (*.png) do (
type a1.json > %%~nA_!WERT!.json
echo !WERT!/%%~nA^" >> %%~nA_!WERT!.json
type a2.json >> %%~nA_!WERT!.json
)
pause
@echo off
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo El script necesita privilegios de administrador.
    pause
    exit /b
)

rem Asigna el primer parámetro pasado al batch como la variable DIR_PATH
set "DIR_PATH=%~1"

:: Buscar e instalar los drivers .inf
for /r "%DIR_PATH%" %%f in (*.inf) do (
    echo Instalando driver %%~nxf
    pnputil /add-driver "%%f" /subdirs /install
)

echo Drivers installation completed!
echo done

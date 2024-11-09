      @echo off
      net session >nul 2>&1
      if %errorLevel% neq 0 (
          echo SolidDrivers necesita privilegios de administrador.
          echo Por favor, cierre el programa y ejecutelo como administrador.
          echo si el problema persiste, favor comuniquese con soporte : adderlis@live.com
          echo error: 0x00002
          pause
          exit /b
      )

      rem Asigna el primer parámetro pasado al batch como la variable DIR_PATH
      set "DIR_PATH=%~1"
 echo ****************************************************************************************

      pnputil /add-driver "%DIR_PATH%"  /install

echo *****************************************************************************************


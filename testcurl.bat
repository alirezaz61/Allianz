@ECHO OFF
FOR /L %%A IN (1,23,100) DO (

  ECHO %%A
  curl -v --user sen1:password  localhost:8080/receiver/1/%%A/2012-09-17T18:47:52.699Z
  SLEEP 2
)

pause

cd C:\hybris-commerce-suite-5.5.1.6\hybris\bin\platform
call setantenv.bat
ant runcronjob -Dcronjob=MailCronJob -Dtenant=master
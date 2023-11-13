SELECT LASTNAME, FIRSTNME, MIDINIT, SALARY
FROM EMPLOYEE
WHERE JOB NOT IN ('PRES', 'MANAGER')
ORDER BY SALARY DESC
LIMIT 5;

SELECT LASTNAME, FIRSTNME, MIDINIT, SALARY
FROM EMPLOYEE
WHERE NOT (JOB='PRES') AND NOT (JOB='MANAGER')
ORDER BY SALARY DESC
LIMIT 5;
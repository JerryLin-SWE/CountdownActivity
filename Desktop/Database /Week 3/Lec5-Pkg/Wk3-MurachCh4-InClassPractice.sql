--Week 3
--Murach Ch4, In Class Practice

--Covered topics: Self Join, OUTER JOIN

--Continued from Lec 5.


--4
--Print the names of employees in department 30 and the names of their managers. 

-- SELECT v1.vendor_id ,v1.vendor_name, v1.vendor_contact_first_name || ' ' || v1.vendor_contact_last_name AS "Contact Name" -- v2.vendor_id , v2.vendor_contact_last_name
-- FROM vendors v1 INNER JOIN vendors v2 ON(v1.vendor_contact_last_name = v2.vendor_contact_last_name)
--         AND (v1.vendor_id <> v2.vendor_id)
-- ORDER BY vendor_id 

-- SELECT e.ENAME "Employee", m.ENAME " Manager"
-- FROM emp e INNER JOIN emp m ON (e.MGR = m.EMPNO) 
--     AND e.EMPNO <> m.EMPNO 
-- WHERE e.DEPTNO = 30 
-- ORDER BY e.EMPNO



SELECT e.ENAME "Employee", m.ENAME " Manager"
FROM emp e LEFT JOIN emp m ON (e.MGR = m.EMPNO) 
    AND e.EMPNO <> m.EMPNO 
ORDER BY e.ENAME;

SELECT *
FROM general_ledger_accounts gla LEFT JOIN invoice_line_items il
    ON gla.account_number = il.account_number;

--5
--Print all general ledger accounts' numbers, descriptions, the invoice ids of invoices 
--where the accounts were used.
--The query result also includes accounts that were not used in any purchase. 




--6.
--Print the account numbers and descriptions of general ledger accounts 
--   that were not used in any purchase



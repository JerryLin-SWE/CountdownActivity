--Wk3, Murach Chapter 4, 
--INNER JOIN 4 tables

SELECT v.vendor_name, i.invoice_number, il.line_item_amt, gla.account_description -- *
FROM  vendors v JOIN invoices i ON (v.vendor_id = i.vendor_id)
      JOIN invoice_line_items il ON (il.invoice_id = i.invoice_id)
      JOIN general_ledger_accounts gla ON (il.account_number = gla.account_number)
WHERE   gla.account_number = 572;
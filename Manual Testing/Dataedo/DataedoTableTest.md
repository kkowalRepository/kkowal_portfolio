# Dataedo table test

As a part of a recruitment process I was asked to perform a manual testing of a given table. 
TASK: Please tell us how would you test this form designed for adding and editing tables in a relational database.
This is what the table looks like:

![](https://github.com/kkowalRepository/kkowal_portfolio/blob/master/Manual%20Testing/Dataedo/dataedoTable.png)

Below you can find the description of how I would approach the test.

1. Test whether all descriptions are correct(the same language, spelling faults) and in the right place.
2. Test whether all descriptions are readable/understandable to the user and do not overlap each other.
3. “Add” button, what does it do, does it add new table or new cell, row, column
4. “Remove”- likewise, does it remove the whole table or cell, column or row
5. “Move up” button, does it move selected cell up or entire row, what does it move up when no cell/row is selected (or multiple rows/cells).
6.“Move down” button,  does it move selected cell down or entire row, what does it move down when no cell/row is selected (or multiple rows/cells).
7. “Move to top” & “Move to bottom” likewise as 4. and 5.
8. “Schema” field - I would test it for minimum and maximum number of characters, numeric characters, special characters, space, leave empty and check weather system accepts empty field.
9. “Name” field - I would test it for minimum and maximum number of characters, test if system accepts numeric characters, special characters, space, leave empty and check weather system accepts empty field.
10. “Name” cell - test if clicked, system performs A-Z sorting or not and see whether all other corresponding cells in corresponding rows are also sorted.
11. “Data type” cell - test if clicked, system performs some kind of sorting ( A-Z or whether it sorts values by type, f.e.: ‘date’ values, ‘int’ values then ‘varchar’ values )or not and see whether all other corresponding cells in corresponding rows are also sorted.
12. “Size” cell - test if clicked, system performs sorting ( from small number to big, big to small ) or not and see whether all other corresponding cells in corresponding rows are also sorted.
13. “Name” column - is the name (‘column1’ provided by the system or user can provide its own name, if so I would test it for minimum and maximum number of characters, numeric characters, special characters, space, leave empty and check weather system accepts empty field.
14. “Data type” column - are all the cells provided by the dropdown list by the system, can user input own datatype names if so I would test it for minimum and maximum number of characters, numeric characters, special characters, space, leave empty and check weather system accepts empty field.
15. “Size” column - testing for input values with corresponding data types, f.e.: if column1 has values “int” (integers) I would check for f.e: ’double’, ‘varchar’, ‘string’, ‘boolean’, ‘array’ values and check whether system accepts them or if there’s any alert message provided by the system in case of an error. For instance for integers I would perform a boundary value analysis, also I guess the field should accept positive integers ( more than 0) so I would test for integers smaller than 0. Then, just to be sure I would test this field for minimum and maximum number of characters, special characters, space, leave empty and check weather system accepts empty field. Respectively I would test other data types. 
16. “Nullable” tick field - test when clicked, “tick” appears and how does the system responds, does it also for some of the cell stay empty or not.
17. “Description” column - testing what characters system accepts in this column. So: minimum and maximum number of characters, numeric characters, special characters, space, leave empty. For “date” or “datetime” I would check what kind of format system accepts, f.e: DD-MM-YYYY, MM-DD-YYYY, check whether the system provides a date picker to make it comfortable for the user to pick the right date/date&time or not 
18. “Save” button - when clicked I would check whether a created table was saved to the system
19. “Cancel” button - when clicked I would check whether a created table was not created/saved to the system
20. Testing whether it’s possible do create another table with the same “schema” and “name” values.
21. Error messages - test when entered incorrect values system displays alert
22. “Minimise” button - test if clicked, window is minimised and accessible for later
23. “Maximise” button - test when clicked, window fills the entire screen, and what happens then with the form, does it adjust to the full screen size or not, is the form scaled up or not, check whether clicking the button again form returns to the previous size.
24. “X” button - test when clicked window closes, are the changes in the form saved to the system or not, is there an alert message displayed saying f.e: “do you want to save changes?”


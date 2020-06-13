Feature: Shein scenario

Scenario: Shein

Given open https://www.shein.in/
Given Mouseover on Clothing and click Jeans
Given Choose Black under Jeans product count
Given check size as medium
Given User clicks + in color
Given check whether the color is black
Given Click first item to Add to Bag 
Given Click the size as M and click Submit
Given Click view Bag 
When Check the size is Medium or not.
Then close the browser.

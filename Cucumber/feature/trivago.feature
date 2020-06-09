Feature: Trivago Scenario
Scenario: Room Reservation In Trivago

Given Go to https://www.trivago.com/  
And Type Agra in Destination and select Agra, Uttar Pradesh.
And Choose check in and check out date
And Select Room as Family Room
And Choose Number of Adults Two, Childern One and set Child's Age as Four
And Click Confirm button and click Search
And Select Accommodation type as Hotels only and choose Four stars
And Select Guest rating as Very Good
And Set Hotel Location as Agra Fort and click Done
And In more Filters, select Air conditioning, Restaurant and WiFi and click Done
And Sort the result as Rating & Recommended
And Print the Hotel name, Rating, Number of Reviews and Click View Deal
And Print the URL of the Page
And Print the Price of the Room and click Choose Your Room
When Click Reserve and I'll Reserve
Then Close the browser
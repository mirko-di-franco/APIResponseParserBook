# API Response Parser
**APIResponseParser** is a Java program designed to parse an XML response string and extract specific information about a book. The program extracts the title, author, publication year, average rating, ratings count, and image URL of a book from the response string.

## Code Structure
The program contains two main methods:
1. **`parse(String response)`**: This method takes an XML string as input and returns a **Book** object populated with information extracted from the string.
2. **`parse(String response, String startRule, String endRule)`**: This helper method extracts a substring from the XML response given a start rule and an end rule.


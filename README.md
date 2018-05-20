# springbootexample-rest-retry-template
Spring Boot Example with RestTemplate and RetryTemplate

A credit card company has to provide a tool to its customers to predict the next month bill amount based on simple average of the previous bills. The input to this tool will be a json recieved from its CRM system, which contains basic customer information and the previous bills. The json data is available from following URL.

https://demo1846658.mockable.io/getBills

The tool will make a web service call to retriev json responce, parse the json and calculate the next month's bill amiount, bill date and due date after last available month in the json data.
For example if json responce has latest bill of MAr-2018, next bill should be Apr-2018.

The input will be a single date. Bills with biill date after this date only should be consider for prediction.
In addition, bills for which the bill amount is greater than zero in CRM system data, only should be considered for prediction.

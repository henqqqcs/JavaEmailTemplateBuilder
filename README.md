# JavaEmailTemplateBuilder

##How to create an email template

1. Create a file containing the template for your email and put it on your classpath.
With your variables, which will be replaced.

For example:
Hello %USERNAME%, Welcome to the Java Email Template API forums!

Thanks for registering at Java Email Template API forums!

To complete your registration, please visit this URL:
http://java.com/register?registrationToken=%REGISTRATION-TOKEN%

All the best,
Java Email Template API forums

2. Instantiate the class EmailTemplateBuilder, and set the variables you wish to be replaced on your template file using the method addVariable

example:
 new EmailTemplateBuilder()
				.addVariable("%USERNAME%", "Jon Snow")

3. Set your source file location and the name of the file

4. Use the method createTemplate() to finish the template.


###Email template - simple model


###Using header to aditional information

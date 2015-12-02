#Java Email Template Builder

##How to create an email template

####Create a file with your email temaple
Create a file containing the template for your email and put it on your classpath with your variables, which will be replaced.

For example:

	Hello %USERNAME%, Welcome to the Java Email Template API forums!

	Thanks for registering at Java Email Template API forums!

	To complete your registration, please visit this URL:
	h ttp://java.com/register?registrationToken=%REGISTRATION-TOKEN%

	All the best,
	Java Email Template API forums

####Add your variables
Instantiate the class EmailTemplateBuilder, and set the variables you wish to be replaced on your template file using the method addVariable

example:

 	new EmailTemplateBuilder().addVariable("%USERNAME%", "Jon Snow")
 	

####Set your source file location and the name of the file
Using the method setSourceFileLocation() set the location of your template, and it's name.

	setSourceFileLocation("resources/emails/registration-template.txt");


####Use the method createTemplate() to generate your temaplate
When the method createTemplate() is called, all variables are replaced

####Example - Creating and template

	EmailTemplate emailTemplate = new EmailTemplateBuilder()
		.addVariable("%USERNAME%", "Jon Snow")
		.addVariable("%REGISTRATION-TOKEN%", "430e842440a3f0989d")
		.setHeaderCharacters("##")
		.setSubjectProperty("subject:")
		.setSourceFileLocation("resources/emails/registration-template.txt").createTemplate();

###Using header to aditional information
Example of template with a header and a subject:

	## ------------------------------------------------------------------
	## template: Registration email template
	## subject: Welcome %USERNAME%, this a registration email!
	## ------------------------------------------------------------------

	Hello %USERNAME%, Welcome to the Java Email Template API forums!

	Thanks for registering at Java Email Template API forums! We are glad you have chosen to be a part of our community and we 		hope you enjoy your stay.

	To complete your registration, please visit this URL:
	h ttp://java.com/register?registrationToken=%REGISTRATION-TOKEN%

	All the best,
	Java Email Template API forums




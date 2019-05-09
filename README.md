# ----------------------------------------------------------------------

Setup Steps

----------------------------------------------------------------------



Clone/ download from git repository : https://github.com/sachingwlsharma/CustomerServiceRepository.git



Import as maven project in eclipse/inteliJ and let IDE resolve maven dependency.



Run PersonServiceApplication as --&gt; JAVA Application



----------------------------------------------------------------------

Demo Steps

----------------------------------------------------------------------



To test API with cutomerId and InitialCredit call below:



http://localhost:8800/newAccount



If CustomerId present then It'll create new acccount with transaction of initialCredit (If initialCredit available).

Else redirect to createCustomer page and after creation can use the same customerId for new Account creation.



To see report for any customer, use below API call:



http://localhost:8800/findReportById/{custId}

example:

http://localhost:8800/findReportById/2



To see report for All customer, use below API call:



http://localhost:8800/completeReport



----------------------------------------------------------------------

Technology Stack

----------------------------------------------------------------------



Using SpringBoot with thymeleaf template engine (for UI mapping and quick development). I would have used multiple microservices (AccountService and TransactionService ) to handle this in real application.

Using Apache Maven to resolve jar dependencies.



Few code has to written to handle inmemory objects, can be removed once using database.



PersonController is handling responsibility for Customer Creation screen i.e. add-user.html

AccountController is handling responsibility for account Creation screen i.e. add-account.html



Corresponding sample JUNIT test case as well written in test directory.

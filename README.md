# rate-calculator

This program processes information from a csv file and makes decisions according to user input and data. 

In this instance the data provided will be related to lenders and different types of loans. Upon user entry the program will calculate and provide the best quote from the available lenders and loans. 

To run the application please do the following:

 - unpack the zip file with project contents to your directory
 - if you are using a new loan file locate loan_files folder within src folder of rate-calculator
 - place any file you would like to use for loan calculations into this folder. The default market.csv is in the folder already. Some values may have changed for testing purposes.
 - Go to Build Artifacts in your editor to re-build jar file (if you are using a new file)
 - Go to your terminal and locate rate-calculator folder and cd into it. 
 - run java -jar out/artifacts/rate_calculator_jar/rate-calculator.jar market.csv 1000

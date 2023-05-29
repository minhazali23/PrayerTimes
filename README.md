# PrayerTimes Project
Prayer Times project is a web application which gives you information about prayer times depending on your location.

## Description
Prayer Times is a SpringBoot project written in Java in order to create a RESTFUL service to the end user. Everytime a request is made to the backend server (hosted in AWS EC2),
the application will first check the DynamoDB database, to see if the prayer times for the requested city exists. If the prayer times for the requested city exists in the database, simply return the Object back to the client. 

However, in the event that this data does not exist in the database, a call will be made to an external API. The data consumed from this external API will be reformatted and saved unto the database, before being served back to the client. 

As the project grows, more thoughful methods will be implemented to ensure a robust, scalable and efficient system.

## Getting Started

### Dependencies
* Openjdk-18.0.2.1
* Amazon DynamoDB
* Maven 3.6.0
* Postman
* Docker

### Installing
* When downloading DynamoDB locally please refer to this guide (https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/dynamodb-dg.pdf#DynamoDBLocal)
* Docker will be used to deploy DynamoDb. Amazon AWS Cli will be used to access DynamoDB on the Docker container. Make sure both are installed on your local machine
* After installing both, edit configuration for aws
```
	aws configure 
```
make sure profile being used has the following configurations.
```
[default]
region = us-west-2
dynamodb =
    endpoint = http://localhost:8000
```
* Pull latest amazon AWS DynamoDB image from docker repository and run an instance
```
	docker run -p 8000:8000 amazon/dynamodb-local -jar DynamoDBLocal.jar -inMemory -sharedDb
```
* You must create template schema in the DynamoDB console. This is the schema being used for this project

```
{
	"TableName": "PrayerTimesByCity",
	"KeySchema": [
		{
			"AttributeName": "CityCountry",
			"KeyType": "HASH"
		}
	],
	"AttributeDefinitions": [
		{
			"AttributeName": "CityCountry",
			"AttributeType": "S"
		}
	],
	"ProvisionedThroughput": {
		"ReadCapacityUnits": 5,
		"WriteCapacityUnits": 5
	}
}
```
* Create the table schema in AWS-Cli locally using the command 
```
aws dynamodb create-table \
   --table-name PrayerTimesByCity \
   --attribute-definitions AttributeName=CityCountry,AttributeType=S \
   --key-schema AttributeName=CityCountry,KeyType=HASH \
   --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
   --endpoint-url http://localhost:8000
```
* Add dummy data into the table
```
aws dynamodb put-item \
  --table-name PrayerTimesByCity \
  --item '{
    "CityCountry": {"S": "NewYorkUSA"},
    "timezone": {"S": "CST"},
    "Date": {"S": "01-01-2023"},
    "PrayerTimes": {"S": "your_prayer_times"}
  }' \
  --endpoint-url http://localhost:8000

```
### Executing Program
* When running springboot application, send API requests via postman 

```
http://localhost:8080/prayerTimes/prayerTimeRequest/{Enter City}/{Enter Country}
```

## Current Project Status
**Currently In progress**

## Things to be completed
* Full Amazon AWS integration to allow for EC2 Instance support
* Adding additional features such as Jurisprudence, school of thought, etc
* Angular frontend developement via Amazon Elastic Beanstalk

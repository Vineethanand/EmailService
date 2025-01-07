To configure Kafka server you may need to do some additional changes in server configuration.
While setting up the Kafka using WSL in windows
There is a change is config required.
In server.properties in downloaded Kafka bundle (eg: /kafka_2.12-3.9.0)
Go to config/server.properties
Uncomment listeners=PLAINTEXT://:9092
Uncomment advertised.listeners= line and change it to advertised.listeners=PLAINTEXT://localhost:9092
Start the kafka server after it

Command to create a Kafka Topic
 ./kafka-topics.sh --create   \
 --bootstrap-server localhost:9092   \
 --replication-factor 1 --partitions 1   \
 --topic sendEmail1

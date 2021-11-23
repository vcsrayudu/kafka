from kafka import KafkaConsumer


print('Making connection.')
consumer = KafkaConsumer(bootstrap_servers='localhost:9092',group_id='group_one')
print('Assigning Topic.')

consumer.subscribe(['my-topic'])
print('Getting message.')
for message in consumer:
    print("OFFSET: " + str(message[0])+ "\t MSG: " + str(message))
from kafka import KafkaProducer
import  time
import json
import pprint

producer = KafkaProducer(
    bootstrap_servers='localhost:9092',
    value_serializer=lambda v: json.dumps(v).encode('utf-8'))

while True:
   print("Send message")
   producer.send('my-topic', {'topic': 'kafka'})
   time.sleep(3)

producer.close()


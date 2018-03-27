package com.message.messagekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//import com.message.messagekafka.MessageKafkaApplication.WordCount;



@SpringBootApplication
public class MessageKafkaApplication  {

	
	

	public static void main(String[] args) {
		SpringApplication.run(MessageKafkaApplication.class, args);
	}
	
	
	
	/*
	@EnableBinding(KafkaStreamsProcessor.class)
	public static class WordCountProcessorApplication {
		
		
		private TimeWindows timeWindows;
		
		
		@StreamListener("input")
		@SendTo("output")
		
		public KStream<?,WordCount> process(KStream<Object, String> input){
		
						
			
			
			return input.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
							.map((key, value) -> new KeyValue<>(value, value))
							.groupByKey(Serialized.with(Serdes.String(), Serdes.String()))
							.windowedBy(TimeWindows.of(TimeUnit.SECONDS.toMillis(10)))
							.count(Materialized.as("WordCounts-1"))
							.toStream()
							.map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
				
				}
			}

			static class WordCount {

				private String word;

				private long count;

				private Date start;

				private Date end;

				WordCount(String word, long count, Date start, Date end) {
					this.word = word;
					this.count = count;
					this.start = start;
					this.end = end;
				}

				public String getWord() {
					return word;
				}

				public void setWord(String word) {
					this.word = word;
				}

				public long getCount() {
					return count;
				}

				public void setCount(long count) {
					this.count = count;
				}

				public Date getStart() {
					return start;
				}

				public void setStart(Date start) {
					this.start = start;
				}

				public Date getEnd() {
					return end;
				}

				public void setEnd(Date end) {
					this.end = end;
				}
			}
			*/
			
	}





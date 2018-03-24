package com.message.messagekafka.domainImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.message.messagekafka.domain.ItemEventLog;
import com.message.messagekafka.repository.ItemEventLogRepository;

public class ItemEventLogRepoIMPL {

	
	@Autowired
	ItemEventLogRepository repository ;
	
	public void itemEventlogInsert(String eventName) {
		final ItemEventLog itemEventlog = new ItemEventLog(UUID.randomUUID(),"receiving",100,1000,1);
	/*	itemEventlog.setId(UUID.randomUUID());
		itemEventlog.setEventName("sample");
		itemEventlog.setDC(100);
		itemEventlog.setItemNumber(1000);
		itemEventlog.setQty(1);*/
		
		repository.insert(itemEventlog);
		
		
		
	}
}

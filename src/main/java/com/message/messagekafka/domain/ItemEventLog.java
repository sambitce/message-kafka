/** Table 
 * 
CREATE TABLE IF NOT EXISTS  sample.item_event_log (

    id UUID,

    eventName varchar,

    DC int,

    itemNumber int,

    qty int,

    primary key((id))

);

 */

package com.message.messagekafka.domain;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("item_event_log")
public class ItemEventLog {

	private static final long serialVersionUID=1;
	
	@PrimaryKey
	private UUID id ;
	
	
	
	@Column("dc")
	private Integer DC;
	@Column("eventname")
	private String eventName;
	public ItemEventLog(UUID id, String eventName, Integer dC, Integer itemNumber, Integer qty) {
		
		this.id=id;
		this.eventName = eventName;
		this.DC = dC;
		this.itemNumber = itemNumber;
		this.qty = qty;
	}
	
	public ItemEventLog() {
		// TODO Auto-generated constructor stub
	}
	
	@Column("itemnumber")
	private Integer itemNumber ;
	@Column("qty")
	private Integer qty ;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Integer getDC() {
		return DC;
	}
	public void setDC(Integer dC) {
		DC = dC;
	}
	public Integer getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}

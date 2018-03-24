package com.message.messagekafka.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.message.messagekafka.domain.ItemEventLog;

public interface ItemEventLogRepository extends CassandraRepository<ItemEventLog,UUID>{}

	


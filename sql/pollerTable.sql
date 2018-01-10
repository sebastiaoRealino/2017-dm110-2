create table poller(
	ips varchar(50) not null,
	status bool default 'false',
	constraint pk_host primary key (ips)
);


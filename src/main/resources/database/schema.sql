create table if not exists demo (
    name        varchar(20)     primary key     comment 'name',
    address     varchar(100)                    comment 'address',
    birthday    date                            comment 'birthday'
);
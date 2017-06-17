insert into tb_users(user_id,email,password,user_name) values ('user1','user1@example.com','user1','User');
insert into tb_users(user_id,email,password,user_name) values ('admin','admin@example.com','admin','Admin');
insert into tb_users(user_id,email,password,user_name) values ('user2','user2@example.com','user2','User');

insert into tb_authorities(authority) values ('USER_READ');
insert into tb_authorities(authority) values ('USER_WRITE');
insert into tb_authorities(authority) values ('AUTH_READ');
insert into tb_authorities(authority) values ('AUTH_WRITE');
insert into tb_authorities(authority) values ('ROLE_READ');
insert into tb_authorities(authority) values ('ROLE_WRITE');

insert into tb_groups(group_name) values ('ROLE_ADMIN');
insert into tb_groups(group_name) values ('ROLE_USER');

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'USER_READ'
);

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'USER_WRITE'
);

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'AUTH_READ'
);

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'AUTH_WRITE'
);

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'ROLE_READ'
);

insert into tb_group_authorities(group_id, authority_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	select authority_id from tb_authorities where authority = 'ROLE_WRITE'
);

insert into tb_group_members(group_id, user_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_ADMIN',
	'admin'
);

insert into tb_group_members(group_id, user_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_USER',
	'user1'
);

insert into tb_group_members(group_id, user_id)
values (
	select group_id from tb_groups where group_name = 'ROLE_USER',
	'user2'
);

insert into oauth_client_details(
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types, 
	web_server_redirect_uri,
	authorities
) values (
	'renton-client',
	'secret',
	'READ,WRITE',
	'authorization_code',
	'www.naver.com',
	'ROLE_ADMIN'
);
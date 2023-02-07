DROP TABLE roles IF EXISTS;
DROP TABLE accounts IF EXISTS;
DROP TABLE books IF EXISTS;
DROP TABLE genres IF EXISTS;
DROP TABLE book_genre IF EXISTS;
DROP TABLE customers IF EXISTS;
DROP TABLE favourites IF EXISTS;
DROP TABLE orders IF EXISTS;
DROP TABLE carts IF EXISTS;
DROP TABLE order_details  IF EXISTS;
DROP TABLE comments IF EXISTS;


CREATE TABLE roles (
	role_id int4 auto_increment NOT NULL,
	role_name varchar(55) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (role_id)
);

CREATE TABLE accounts (
	account_id int4 auto_increment NOT NULL,
	email varchar(255) NULL,
	password varchar(255) NULL,
	role_id int4 NOT NULL,
	CONSTRAINT accounts_pkey PRIMARY KEY (account_id),
	FOREIGN KEY (role_id) REFERENCES roles(role_id),
	CONSTRAINT uk_n7ihswpy07ci568w34q0oi8he UNIQUE (email)
);



CREATE TABLE books (
	book_id int4 auto_increment NOT NULL,
	author varchar(255) NULL,
	description text NULL,
	image_link varchar(511) NULL,
	price float8 NULL,
	publisher varchar(255) NULL,
	quantity_left int4 NULL,
	status varchar(55) NULL,
	title varchar(255) NULL,
	CONSTRAINT books_pkey PRIMARY KEY (book_id)
);


CREATE TABLE genres (
	genre_id int4 auto_increment NOT NULL,
	genre_name varchar(55) NULL,
	CONSTRAINT genres_pkey PRIMARY KEY (genre_id)
);



CREATE TABLE book_genre (
	book_genre_id int4 NOT NULL,
	book_id int4 NULL,
	genre_id int4 NULL,
	CONSTRAINT book_genre_pkey PRIMARY KEY (book_genre_id),
	CONSTRAINT fknkh6m50njl8771p0ll3lylqp2 FOREIGN KEY (genre_id) REFERENCES public.genres(genre_id),
	CONSTRAINT fkq0f88ptislu8lv230mvgonssl FOREIGN KEY (book_id) REFERENCES public.books(book_id)
);


CREATE TABLE public.customers (
	customer_id int4 NOT NULL,
	birthday date NULL,
	gender varchar(55) NULL,
	name varchar(255) NULL,
	status varchar(55) NULL,
	CONSTRAINT customers_pkey PRIMARY KEY (customer_id),
	CONSTRAINT fkjv4amvb0o59epwbh0soh2fm9k FOREIGN KEY (customer_id) REFERENCES public.accounts(account_id)
);


CREATE TABLE public.favourites (
	favourite_id int4 NOT NULL,
	book_id int4 NULL,
	customer_id int4 NULL,
	CONSTRAINT favourites_pkey PRIMARY KEY (favourite_id),
	CONSTRAINT fk8fcod45iw8bxhemkkf9u0v6e4 FOREIGN KEY (book_id) REFERENCES public.books(book_id),
	CONSTRAINT fkeg6piokbwhdmatwhg245me6li FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id)
);


CREATE TABLE public.orders (
	order_id int4 NOT NULL,
	address varchar(255) NULL,
	phone varchar(255) NULL,
	status varchar(255) NULL,
	time timestamp NULL,
	total_amount float8 NULL,
	customer_id int4 NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (order_id),
	CONSTRAINT fkpxtb8awmi0dk6smoh2vp1litg FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id)
);


CREATE TABLE public.carts (
	cart_id int4 NOT NULL,
	quantity int4 NULL,
	book_id int4 NULL,
	customer_id int4 NULL,
	CONSTRAINT carts_pkey PRIMARY KEY (cart_id),
	CONSTRAINT fk1oy8oyhoej8p1v2ii97d29x15 FOREIGN KEY (book_id) REFERENCES public.books(book_id),
	CONSTRAINT fk8ba3sryid5k8a9kidpkvqipyt FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id)
);


CREATE TABLE comments (
	comment_id int4 NOT NULL,
	content text NULL,
	rating float4 NULL,
	timestamp timestamp NULL,
	book_id int4 NULL,
	customer_id int4 NULL,
	CONSTRAINT comments_pkey PRIMARY KEY (comment_id),
	CONSTRAINT fk1ey8gegnanvybix5a025vepf4 FOREIGN KEY (book_id) REFERENCES public.books(book_id),
	CONSTRAINT fkev1bd87g1c51ujncao608e6qa FOREIGN KEY (customer_id) REFERENCES public.customers(customer_id)
);

CREATE TABLE order_details (
	order_details_id int4 NOT NULL,
	price float8 NULL,
	quantity int4 NULL,
	book_id int4 NULL,
	order_id int4 NULL,
	CONSTRAINT order_details_pkey PRIMARY KEY (order_details_id),
	CONSTRAINT fkjqe04yonp6a52rhbf2y0m03qw FOREIGN KEY (book_id) REFERENCES public.books(book_id),
	CONSTRAINT fkjyu2qbqt8gnvno9oe9j2s2ldk FOREIGN KEY (order_id) REFERENCES public.orders(order_id)
);
CREATE TABLE users(
u_no int not null AUTO_INCREMENT PRIMARY KEY,
u_name varchar(30) NOT NULL,
u_pwd varchar(16) CONSTRAINT u_pwd_check CHECK (length(u_pwd)>=8 AND length(u_pwd)<=16),
u_tell varchar(16),
u_role int CONSTRAINT user_role_check CHECK (u_role IN(0,1)),
u_money int NOT NULL
);

INSERT INTO users VALUES (null ,'admin','11111111',13800000000,0,0);


CREATE TABLE dishes(
g_no int not null AUTO_INCREMENT PRIMARY KEY,
g_name varchar(30) ,
g_price int ,
g_like_num int,
g_state int CONSTRAINT g_state_check CHECK (g_state IN(0,1))
);
ALTER TABLE dishes ADD CONSTRAINT g_name_uq UNIQUE(g_name);
ALTER TABLE dishes ADD CONSTRAINT g_price_check CHECK(g_price<100);


INSERT INTO dishes VALUES (null ,'大盘鸡',100,10,1);
INSERT INTO dishes VALUES (null ,'羊肉串',3,20,1);
INSERT INTO dishes VALUES (null ,'拌面',18,10,1);




CREATE TABLE orders(
o_no int not null AUTO_INCREMENT PRIMARY KEY,
u_no int,
g_no int,
o_num int,
o_time varchar(20) NOT NULL,
o_address varchar(40) NOT NULL,
o_state int CONSTRAINT o_state_check CHECK (o_state IN(0,1,2))
);
ALTER TABLE orders ADD CONSTRAINT u_no_fk FOREIGN KEY (u_no) REFERENCES users(u_no) ON DELETE SET NULL;
ALTER TABLE orders ADD CONSTRAINT g_no_fk FOREIGN KEY (g_no) REFERENCES dishes(g_no) ON DELETE SET NULL;

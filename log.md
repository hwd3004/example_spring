https://youtu.be/AcbzhJoQ-OY?list=PLljhOa5uVB3GKTm_0Y0jiFU9lkPgtjLxK

devtools
lombok
spring configuration processor
mybatis
mariadb driver
mysql driver
spring web

<hr/>

```sql
  create table T_BOARD (
       board_seq integer not null,
        contents varchar(255),
        reg_date datetime(6),
        title varchar(255),
        primary key (boardSeq)
    )
```

```sql
    create table T_BOARD (
       board_seq integer not null auto_increment,
        contents varchar(255),
        reg_date datetime(6),
        title varchar(255),
        primary key (boardSeq)
    )
```

스웨거 사용을 위해 스프링 부트 버전을 2.5.13으로 변경

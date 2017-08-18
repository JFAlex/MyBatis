#创建数据库，并制定编码格式为UTF-8
CREATE DATABASE mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

#切换数据库到mybatis
use mybatis;

#创建用户表
create table sys_user(
    id bigint not null auto_increment comment '用户ID',
    user_name varchar(50) comment '用户名',
    user_password varchar(50) comment '密码',
    user_email varchar(50) comment '邮箱',
    user_info text comment '简介',
    head_img blob comment '头像',
    create_time datetime comment '创建时间',
    primary key (id)
    
);
alter table sys_user comment '用户表';

#创建角色表
create table sys_role(
    id bigint not null auto_increment comment '角色ID',
    role_name varchar(50) comment '角色名',
    enabled int comment '有效标志',
    create_by bigint comment '创建人',
    create_time datetime comment '创建时间',
    primary key (id)
);
alter table sys_role comment '角色表';

#创建权限表
create table sys_privilege(
    id bigint not null auto_increment comment '权限ID',
    privilege_name varchar(50) comment '权限名称',
    privilege_uri varchar(200) comment '权限URL',
    primary key (id)
);
alter table sys_privilege comment '权限表';

#创建用户角色关系表
create table sys_user_role(
    user_id bigint comment '用户ID',
    role_id bigint comment '角色ID'
);
alter table sys_user_role comment '用户角色关联表';

#创建角色权限关系表
create table sys_role_privilege(
    role_id bigint comment '角色ID',
    privilege bigint comment '权限ID'
);
alter table sys_role_privilege comment '角色权限关联表';

##测试数据
insert into sys_user(id,user_name, user_password, user_email, user_info, head_img, create_time) 
values(1,'admin','123456','admin@mybais.alex','管理员',null,'2017-8-09 15:26:52'),
(2,'test','123456','test@mybais.alex','测试用户',null,'2017-8-09 15:27:30');

insert into sys_role(id,role_name, enabled, create_by, create_time) 
values(1,'管理员','1','1','2017-8-09 15:26:52'),(2,'普通用户','1','1','2017-8-09 15:26:52');

insert into sys_privilege(id,privilege_name, privilege_uri)
values(1,'用户管理','/users'),(2,'角色管理','/roles'),(3,'系统日志','/logs'),(4,'人员维护','/persons'),(5,'部门维护','/companies');

insert into sys_user_role values(1,1),(1,2),(2,2);
insert into sys_role_privilege values(1,1),(1,2),(1,3),(2,4),(2,5);
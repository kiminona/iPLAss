drop table if exists "obj_index_ts" cascade;
create table "obj_index_ts"
(
    "tenant_id" numeric(7,0) not null,
    "obj_def_id" varchar(128) not null,
    "col_name" varchar(36) not null,
    "obj_id" varchar(64) not null,
    "obj_ver" numeric(10,0) default 0 not null,
    "val" timestamp(3)
)
;
create index "obj_index_ts_index1" on "obj_index_ts" ("tenant_id", "obj_def_id", "col_name", "val");
create index "obj_index_ts_index2" on "obj_index_ts" ("tenant_id", "obj_def_id", "obj_id");

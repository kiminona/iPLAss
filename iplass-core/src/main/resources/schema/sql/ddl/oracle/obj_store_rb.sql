/* drop/create OBJ_STORE_RB */
DROP TABLE "OBJ_STORE_RB" CASCADE CONSTRAINT;

CREATE TABLE "OBJ_STORE_RB" 
(
    "RB_ID" NUMBER(16,0) NOT NULL,
    "RB_DATE" TIMESTAMP(3),
    "RB_USER" VARCHAR2(64),
    "TENANT_ID" NUMBER(7,0) NOT NULL, 
    "OBJ_DEF_ID" VARCHAR2(128) NOT NULL, 
    "PG_NO" NUMBER(2,0) NOT NULL, 
    "OBJ_ID" VARCHAR2(64) NOT NULL, 
    "OBJ_VER" NUMBER(10,0) DEFAULT 0 NOT NULL,
    "OBJ_DEF_VER" NUMBER(10,0),
    "STATUS" CHAR(1),
    "OBJ_NAME" VARCHAR2(256), 
    "OBJ_DESC" VARCHAR2(1024), 
    "CRE_DATE" TIMESTAMP (3), 
    "UP_DATE" TIMESTAMP (3), 
    "S_DATE" TIMESTAMP(3),
    "E_DATE" TIMESTAMP(3),
    "LOCK_USER" VARCHAR2(64),
    "CRE_USER" VARCHAR2(64), 
    "UP_USER" VARCHAR2(64)
    ,"USTR_1" VARCHAR2(4000 BYTE)
    ,"USTR_1_TD" VARCHAR2(139)
    ,"UNUM_1" NUMBER
    ,"UNUM_1_TD" VARCHAR2(139)
    ,"UTS_1" TIMESTAMP(3)
    ,"UTS_1_TD" VARCHAR2(139)
    ,"UDBL_1" BINARY_DOUBLE
    ,"UDBL_1_TD" VARCHAR2(139)
    ,"USTR_2" VARCHAR2(4000 BYTE)
    ,"USTR_2_TD" VARCHAR2(139)
    ,"UNUM_2" NUMBER
    ,"UNUM_2_TD" VARCHAR2(139)
    ,"UTS_2" TIMESTAMP(3)
    ,"UTS_2_TD" VARCHAR2(139)
    ,"UDBL_2" BINARY_DOUBLE
    ,"UDBL_2_TD" VARCHAR2(139)
    ,"ISTR_1" VARCHAR2(4000 BYTE)
    ,"ISTR_1_TD" VARCHAR2(139)
    ,"ISTR_2" VARCHAR2(4000 BYTE)
    ,"ISTR_2_TD" VARCHAR2(139)
    ,"INUM_1" NUMBER
    ,"INUM_1_TD" VARCHAR2(139)
    ,"ITS_1" TIMESTAMP(3)
    ,"ITS_1_TD" VARCHAR2(139)
    ,"IDBL_1" BINARY_DOUBLE
    ,"IDBL_1_TD" VARCHAR2(139)
    ,"ISTR_3" VARCHAR2(4000 BYTE)
    ,"ISTR_3_TD" VARCHAR2(139)
    ,"ISTR_4" VARCHAR2(4000 BYTE)
    ,"ISTR_4_TD" VARCHAR2(139)
    ,"INUM_2" NUMBER
    ,"INUM_2_TD" VARCHAR2(139)
    ,"ITS_2" TIMESTAMP(3)
    ,"ITS_2_TD" VARCHAR2(139)
    ,"IDBL_2" BINARY_DOUBLE
    ,"IDBL_2_TD" VARCHAR2(139)
    ,"ISTR_5" VARCHAR2(4000 BYTE)
    ,"ISTR_5_TD" VARCHAR2(139)
    ,"ISTR_6" VARCHAR2(4000 BYTE)
    ,"ISTR_6_TD" VARCHAR2(139)
    ,"INUM_3" NUMBER
    ,"INUM_3_TD" VARCHAR2(139)
    ,"ITS_3" TIMESTAMP(3)
    ,"ITS_3_TD" VARCHAR2(139)
    ,"IDBL_3" BINARY_DOUBLE
    ,"IDBL_3_TD" VARCHAR2(139)
    ,"ISTR_7" VARCHAR2(4000 BYTE)
    ,"ISTR_7_TD" VARCHAR2(139)
    ,"ISTR_8" VARCHAR2(4000 BYTE)
    ,"ISTR_8_TD" VARCHAR2(139)
    ,"INUM_4" NUMBER
    ,"INUM_4_TD" VARCHAR2(139)
    ,"ITS_4" TIMESTAMP(3)
    ,"ITS_4_TD" VARCHAR2(139)
    ,"IDBL_4" BINARY_DOUBLE
    ,"IDBL_4_TD" VARCHAR2(139)
    ,"STR_1" VARCHAR2(4000 BYTE)
    ,"STR_2" VARCHAR2(4000 BYTE)
    ,"STR_3" VARCHAR2(4000 BYTE)
    ,"STR_4" VARCHAR2(4000 BYTE)
    ,"NUM_1" NUMBER
    ,"TS_1" TIMESTAMP(3)
    ,"DBL_1" BINARY_DOUBLE
    ,"STR_5" VARCHAR2(4000 BYTE)
    ,"STR_6" VARCHAR2(4000 BYTE)
    ,"STR_7" VARCHAR2(4000 BYTE)
    ,"STR_8" VARCHAR2(4000 BYTE)
    ,"NUM_2" NUMBER
    ,"TS_2" TIMESTAMP(3)
    ,"DBL_2" BINARY_DOUBLE
    ,"STR_9" VARCHAR2(4000 BYTE)
    ,"STR_10" VARCHAR2(4000 BYTE)
    ,"STR_11" VARCHAR2(4000 BYTE)
    ,"STR_12" VARCHAR2(4000 BYTE)
    ,"NUM_3" NUMBER
    ,"TS_3" TIMESTAMP(3)
    ,"DBL_3" BINARY_DOUBLE
    ,"STR_13" VARCHAR2(4000 BYTE)
    ,"STR_14" VARCHAR2(4000 BYTE)
    ,"STR_15" VARCHAR2(4000 BYTE)
    ,"STR_16" VARCHAR2(4000 BYTE)
    ,"NUM_4" NUMBER
    ,"TS_4" TIMESTAMP(3)
    ,"DBL_4" BINARY_DOUBLE
    ,"STR_17" VARCHAR2(4000 BYTE)
    ,"STR_18" VARCHAR2(4000 BYTE)
    ,"STR_19" VARCHAR2(4000 BYTE)
    ,"STR_20" VARCHAR2(4000 BYTE)
    ,"NUM_5" NUMBER
    ,"TS_5" TIMESTAMP(3)
    ,"DBL_5" BINARY_DOUBLE
    ,"STR_21" VARCHAR2(4000 BYTE)
    ,"STR_22" VARCHAR2(4000 BYTE)
    ,"STR_23" VARCHAR2(4000 BYTE)
    ,"STR_24" VARCHAR2(4000 BYTE)
    ,"NUM_6" NUMBER
    ,"TS_6" TIMESTAMP(3)
    ,"DBL_6" BINARY_DOUBLE
    ,"STR_25" VARCHAR2(4000 BYTE)
    ,"STR_26" VARCHAR2(4000 BYTE)
    ,"STR_27" VARCHAR2(4000 BYTE)
    ,"STR_28" VARCHAR2(4000 BYTE)
    ,"NUM_7" NUMBER
    ,"TS_7" TIMESTAMP(3)
    ,"DBL_7" BINARY_DOUBLE
    ,"STR_29" VARCHAR2(4000 BYTE)
    ,"STR_30" VARCHAR2(4000 BYTE)
    ,"STR_31" VARCHAR2(4000 BYTE)
    ,"STR_32" VARCHAR2(4000 BYTE)
    ,"NUM_8" NUMBER
    ,"TS_8" TIMESTAMP(3)
    ,"DBL_8" BINARY_DOUBLE
    ,"STR_33" VARCHAR2(4000 BYTE)
    ,"STR_34" VARCHAR2(4000 BYTE)
    ,"STR_35" VARCHAR2(4000 BYTE)
    ,"STR_36" VARCHAR2(4000 BYTE)
    ,"NUM_9" NUMBER
    ,"TS_9" TIMESTAMP(3)
    ,"DBL_9" BINARY_DOUBLE
    ,"STR_37" VARCHAR2(4000 BYTE)
    ,"STR_38" VARCHAR2(4000 BYTE)
    ,"STR_39" VARCHAR2(4000 BYTE)
    ,"STR_40" VARCHAR2(4000 BYTE)
    ,"NUM_10" NUMBER
    ,"TS_10" TIMESTAMP(3)
    ,"DBL_10" BINARY_DOUBLE
    ,"STR_41" VARCHAR2(4000 BYTE)
    ,"STR_42" VARCHAR2(4000 BYTE)
    ,"STR_43" VARCHAR2(4000 BYTE)
    ,"STR_44" VARCHAR2(4000 BYTE)
    ,"NUM_11" NUMBER
    ,"TS_11" TIMESTAMP(3)
    ,"DBL_11" BINARY_DOUBLE
    ,"STR_45" VARCHAR2(4000 BYTE)
    ,"STR_46" VARCHAR2(4000 BYTE)
    ,"STR_47" VARCHAR2(4000 BYTE)
    ,"STR_48" VARCHAR2(4000 BYTE)
    ,"NUM_12" NUMBER
    ,"TS_12" TIMESTAMP(3)
    ,"DBL_12" BINARY_DOUBLE
    ,"STR_49" VARCHAR2(4000 BYTE)
    ,"STR_50" VARCHAR2(4000 BYTE)
    ,"STR_51" VARCHAR2(4000 BYTE)
    ,"STR_52" VARCHAR2(4000 BYTE)
    ,"NUM_13" NUMBER
    ,"TS_13" TIMESTAMP(3)
    ,"DBL_13" BINARY_DOUBLE
    ,"STR_53" VARCHAR2(4000 BYTE)
    ,"STR_54" VARCHAR2(4000 BYTE)
    ,"STR_55" VARCHAR2(4000 BYTE)
    ,"STR_56" VARCHAR2(4000 BYTE)
    ,"NUM_14" NUMBER
    ,"TS_14" TIMESTAMP(3)
    ,"DBL_14" BINARY_DOUBLE
    ,"STR_57" VARCHAR2(4000 BYTE)
    ,"STR_58" VARCHAR2(4000 BYTE)
    ,"STR_59" VARCHAR2(4000 BYTE)
    ,"STR_60" VARCHAR2(4000 BYTE)
    ,"NUM_15" NUMBER
    ,"TS_15" TIMESTAMP(3)
    ,"DBL_15" BINARY_DOUBLE
    ,"STR_61" VARCHAR2(4000 BYTE)
    ,"STR_62" VARCHAR2(4000 BYTE)
    ,"STR_63" VARCHAR2(4000 BYTE)
    ,"STR_64" VARCHAR2(4000 BYTE)
    ,"NUM_16" NUMBER
    ,"TS_16" TIMESTAMP(3)
    ,"DBL_16" BINARY_DOUBLE
    ,"STR_65" VARCHAR2(4000 BYTE)
    ,"STR_66" VARCHAR2(4000 BYTE)
    ,"STR_67" VARCHAR2(4000 BYTE)
    ,"STR_68" VARCHAR2(4000 BYTE)
    ,"NUM_17" NUMBER
    ,"TS_17" TIMESTAMP(3)
    ,"DBL_17" BINARY_DOUBLE
    ,"STR_69" VARCHAR2(4000 BYTE)
    ,"STR_70" VARCHAR2(4000 BYTE)
    ,"STR_71" VARCHAR2(4000 BYTE)
    ,"STR_72" VARCHAR2(4000 BYTE)
    ,"NUM_18" NUMBER
    ,"TS_18" TIMESTAMP(3)
    ,"DBL_18" BINARY_DOUBLE
    ,"STR_73" VARCHAR2(4000 BYTE)
    ,"STR_74" VARCHAR2(4000 BYTE)
    ,"STR_75" VARCHAR2(4000 BYTE)
    ,"STR_76" VARCHAR2(4000 BYTE)
    ,"NUM_19" NUMBER
    ,"TS_19" TIMESTAMP(3)
    ,"DBL_19" BINARY_DOUBLE
    ,"STR_77" VARCHAR2(4000 BYTE)
    ,"STR_78" VARCHAR2(4000 BYTE)
    ,"STR_79" VARCHAR2(4000 BYTE)
    ,"STR_80" VARCHAR2(4000 BYTE)
    ,"NUM_20" NUMBER
    ,"TS_20" TIMESTAMP(3)
    ,"DBL_20" BINARY_DOUBLE
    ,"STR_81" VARCHAR2(4000 BYTE)
    ,"STR_82" VARCHAR2(4000 BYTE)
    ,"STR_83" VARCHAR2(4000 BYTE)
    ,"STR_84" VARCHAR2(4000 BYTE)
    ,"NUM_21" NUMBER
    ,"TS_21" TIMESTAMP(3)
    ,"DBL_21" BINARY_DOUBLE
    ,"STR_85" VARCHAR2(4000 BYTE)
    ,"STR_86" VARCHAR2(4000 BYTE)
    ,"STR_87" VARCHAR2(4000 BYTE)
    ,"STR_88" VARCHAR2(4000 BYTE)
    ,"NUM_22" NUMBER
    ,"TS_22" TIMESTAMP(3)
    ,"DBL_22" BINARY_DOUBLE
    ,"STR_89" VARCHAR2(4000 BYTE)
    ,"STR_90" VARCHAR2(4000 BYTE)
    ,"STR_91" VARCHAR2(4000 BYTE)
    ,"STR_92" VARCHAR2(4000 BYTE)
    ,"NUM_23" NUMBER
    ,"TS_23" TIMESTAMP(3)
    ,"DBL_23" BINARY_DOUBLE
    ,"STR_93" VARCHAR2(4000 BYTE)
    ,"STR_94" VARCHAR2(4000 BYTE)
    ,"STR_95" VARCHAR2(4000 BYTE)
    ,"STR_96" VARCHAR2(4000 BYTE)
    ,"NUM_24" NUMBER
    ,"TS_24" TIMESTAMP(3)
    ,"DBL_24" BINARY_DOUBLE
    ,"STR_97" VARCHAR2(4000 BYTE)
    ,"STR_98" VARCHAR2(4000 BYTE)
    ,"STR_99" VARCHAR2(4000 BYTE)
    ,"STR_100" VARCHAR2(4000 BYTE)
    ,"NUM_25" NUMBER
    ,"TS_25" TIMESTAMP(3)
    ,"DBL_25" BINARY_DOUBLE
    ,"STR_101" VARCHAR2(4000 BYTE)
    ,"STR_102" VARCHAR2(4000 BYTE)
    ,"STR_103" VARCHAR2(4000 BYTE)
    ,"STR_104" VARCHAR2(4000 BYTE)
    ,"NUM_26" NUMBER
    ,"TS_26" TIMESTAMP(3)
    ,"DBL_26" BINARY_DOUBLE
    ,"STR_105" VARCHAR2(4000 BYTE)
    ,"STR_106" VARCHAR2(4000 BYTE)
    ,"STR_107" VARCHAR2(4000 BYTE)
    ,"STR_108" VARCHAR2(4000 BYTE)
    ,"NUM_27" NUMBER
    ,"TS_27" TIMESTAMP(3)
    ,"DBL_27" BINARY_DOUBLE
    ,"STR_109" VARCHAR2(4000 BYTE)
    ,"STR_110" VARCHAR2(4000 BYTE)
    ,"STR_111" VARCHAR2(4000 BYTE)
    ,"STR_112" VARCHAR2(4000 BYTE)
    ,"NUM_28" NUMBER
    ,"TS_28" TIMESTAMP(3)
    ,"DBL_28" BINARY_DOUBLE
    ,"STR_113" VARCHAR2(4000 BYTE)
    ,"STR_114" VARCHAR2(4000 BYTE)
    ,"STR_115" VARCHAR2(4000 BYTE)
    ,"STR_116" VARCHAR2(4000 BYTE)
    ,"NUM_29" NUMBER
    ,"TS_29" TIMESTAMP(3)
    ,"DBL_29" BINARY_DOUBLE
    ,"STR_117" VARCHAR2(4000 BYTE)
    ,"STR_118" VARCHAR2(4000 BYTE)
    ,"STR_119" VARCHAR2(4000 BYTE)
    ,"STR_120" VARCHAR2(4000 BYTE)
    ,"NUM_30" NUMBER
    ,"TS_30" TIMESTAMP(3)
    ,"DBL_30" BINARY_DOUBLE
    ,"STR_121" VARCHAR2(4000 BYTE)
    ,"STR_122" VARCHAR2(4000 BYTE)
    ,"STR_123" VARCHAR2(4000 BYTE)
    ,"STR_124" VARCHAR2(4000 BYTE)
    ,"NUM_31" NUMBER
    ,"TS_31" TIMESTAMP(3)
    ,"DBL_31" BINARY_DOUBLE
    ,"STR_125" VARCHAR2(4000 BYTE)
    ,"STR_126" VARCHAR2(4000 BYTE)
    ,"STR_127" VARCHAR2(4000 BYTE)
    ,"STR_128" VARCHAR2(4000 BYTE)
    ,"NUM_32" NUMBER
    ,"TS_32" TIMESTAMP(3)
    ,"DBL_32" BINARY_DOUBLE
    )
;

CREATE INDEX "OBJ_STORE_RB_INDEX1" ON "OBJ_STORE_RB" ("TENANT_ID", "OBJ_DEF_ID", "RB_ID") ;

/* drop/create OBJ_STORE_RB */
DROP TABLE "OBJ_STORE_RB__MTP" CASCADE CONSTRAINT;

CREATE TABLE "OBJ_STORE_RB__MTP" 
(
    "RB_ID" NUMBER(16,0) NOT NULL,
    "RB_DATE" TIMESTAMP(3),
    "RB_USER" VARCHAR2(64),
    "TENANT_ID" NUMBER(7,0) NOT NULL, 
    "OBJ_DEF_ID" VARCHAR2(128) NOT NULL, 
    "PG_NO" NUMBER(2,0) NOT NULL, 
    "OBJ_ID" VARCHAR2(64) NOT NULL, 
    "OBJ_VER" NUMBER(10,0) DEFAULT 0 NOT NULL,
    "OBJ_DEF_VER" NUMBER(10,0),
    "STATUS" CHAR(1),
    "OBJ_NAME" VARCHAR2(256), 
    "OBJ_DESC" VARCHAR2(1024), 
    "CRE_DATE" TIMESTAMP (3), 
    "UP_DATE" TIMESTAMP (3), 
    "S_DATE" TIMESTAMP(3),
    "E_DATE" TIMESTAMP(3),
    "LOCK_USER" VARCHAR2(64),
    "CRE_USER" VARCHAR2(64), 
    "UP_USER" VARCHAR2(64)
    ,"USTR_1" VARCHAR2(4000 BYTE)
    ,"USTR_1_TD" VARCHAR2(139)
    ,"UNUM_1" NUMBER
    ,"UNUM_1_TD" VARCHAR2(139)
    ,"UTS_1" TIMESTAMP(3)
    ,"UTS_1_TD" VARCHAR2(139)
    ,"UDBL_1" BINARY_DOUBLE
    ,"UDBL_1_TD" VARCHAR2(139)
    ,"USTR_2" VARCHAR2(4000 BYTE)
    ,"USTR_2_TD" VARCHAR2(139)
    ,"UNUM_2" NUMBER
    ,"UNUM_2_TD" VARCHAR2(139)
    ,"UTS_2" TIMESTAMP(3)
    ,"UTS_2_TD" VARCHAR2(139)
    ,"UDBL_2" BINARY_DOUBLE
    ,"UDBL_2_TD" VARCHAR2(139)
    ,"ISTR_1" VARCHAR2(4000 BYTE)
    ,"ISTR_1_TD" VARCHAR2(139)
    ,"ISTR_2" VARCHAR2(4000 BYTE)
    ,"ISTR_2_TD" VARCHAR2(139)
    ,"INUM_1" NUMBER
    ,"INUM_1_TD" VARCHAR2(139)
    ,"ITS_1" TIMESTAMP(3)
    ,"ITS_1_TD" VARCHAR2(139)
    ,"IDBL_1" BINARY_DOUBLE
    ,"IDBL_1_TD" VARCHAR2(139)
    ,"ISTR_3" VARCHAR2(4000 BYTE)
    ,"ISTR_3_TD" VARCHAR2(139)
    ,"ISTR_4" VARCHAR2(4000 BYTE)
    ,"ISTR_4_TD" VARCHAR2(139)
    ,"INUM_2" NUMBER
    ,"INUM_2_TD" VARCHAR2(139)
    ,"ITS_2" TIMESTAMP(3)
    ,"ITS_2_TD" VARCHAR2(139)
    ,"IDBL_2" BINARY_DOUBLE
    ,"IDBL_2_TD" VARCHAR2(139)
    ,"ISTR_5" VARCHAR2(4000 BYTE)
    ,"ISTR_5_TD" VARCHAR2(139)
    ,"ISTR_6" VARCHAR2(4000 BYTE)
    ,"ISTR_6_TD" VARCHAR2(139)
    ,"INUM_3" NUMBER
    ,"INUM_3_TD" VARCHAR2(139)
    ,"ITS_3" TIMESTAMP(3)
    ,"ITS_3_TD" VARCHAR2(139)
    ,"IDBL_3" BINARY_DOUBLE
    ,"IDBL_3_TD" VARCHAR2(139)
    ,"ISTR_7" VARCHAR2(4000 BYTE)
    ,"ISTR_7_TD" VARCHAR2(139)
    ,"ISTR_8" VARCHAR2(4000 BYTE)
    ,"ISTR_8_TD" VARCHAR2(139)
    ,"INUM_4" NUMBER
    ,"INUM_4_TD" VARCHAR2(139)
    ,"ITS_4" TIMESTAMP(3)
    ,"ITS_4_TD" VARCHAR2(139)
    ,"IDBL_4" BINARY_DOUBLE
    ,"IDBL_4_TD" VARCHAR2(139)
    ,"STR_1" VARCHAR2(4000 BYTE)
    ,"STR_2" VARCHAR2(4000 BYTE)
    ,"STR_3" VARCHAR2(4000 BYTE)
    ,"STR_4" VARCHAR2(4000 BYTE)
    ,"NUM_1" NUMBER
    ,"TS_1" TIMESTAMP(3)
    ,"DBL_1" BINARY_DOUBLE
    ,"STR_5" VARCHAR2(4000 BYTE)
    ,"STR_6" VARCHAR2(4000 BYTE)
    ,"STR_7" VARCHAR2(4000 BYTE)
    ,"STR_8" VARCHAR2(4000 BYTE)
    ,"NUM_2" NUMBER
    ,"TS_2" TIMESTAMP(3)
    ,"DBL_2" BINARY_DOUBLE
    ,"STR_9" VARCHAR2(4000 BYTE)
    ,"STR_10" VARCHAR2(4000 BYTE)
    ,"STR_11" VARCHAR2(4000 BYTE)
    ,"STR_12" VARCHAR2(4000 BYTE)
    ,"NUM_3" NUMBER
    ,"TS_3" TIMESTAMP(3)
    ,"DBL_3" BINARY_DOUBLE
    ,"STR_13" VARCHAR2(4000 BYTE)
    ,"STR_14" VARCHAR2(4000 BYTE)
    ,"STR_15" VARCHAR2(4000 BYTE)
    ,"STR_16" VARCHAR2(4000 BYTE)
    ,"NUM_4" NUMBER
    ,"TS_4" TIMESTAMP(3)
    ,"DBL_4" BINARY_DOUBLE
    ,"STR_17" VARCHAR2(4000 BYTE)
    ,"STR_18" VARCHAR2(4000 BYTE)
    ,"STR_19" VARCHAR2(4000 BYTE)
    ,"STR_20" VARCHAR2(4000 BYTE)
    ,"NUM_5" NUMBER
    ,"TS_5" TIMESTAMP(3)
    ,"DBL_5" BINARY_DOUBLE
    ,"STR_21" VARCHAR2(4000 BYTE)
    ,"STR_22" VARCHAR2(4000 BYTE)
    ,"STR_23" VARCHAR2(4000 BYTE)
    ,"STR_24" VARCHAR2(4000 BYTE)
    ,"NUM_6" NUMBER
    ,"TS_6" TIMESTAMP(3)
    ,"DBL_6" BINARY_DOUBLE
    ,"STR_25" VARCHAR2(4000 BYTE)
    ,"STR_26" VARCHAR2(4000 BYTE)
    ,"STR_27" VARCHAR2(4000 BYTE)
    ,"STR_28" VARCHAR2(4000 BYTE)
    ,"NUM_7" NUMBER
    ,"TS_7" TIMESTAMP(3)
    ,"DBL_7" BINARY_DOUBLE
    ,"STR_29" VARCHAR2(4000 BYTE)
    ,"STR_30" VARCHAR2(4000 BYTE)
    ,"STR_31" VARCHAR2(4000 BYTE)
    ,"STR_32" VARCHAR2(4000 BYTE)
    ,"NUM_8" NUMBER
    ,"TS_8" TIMESTAMP(3)
    ,"DBL_8" BINARY_DOUBLE
    ,"STR_33" VARCHAR2(4000 BYTE)
    ,"STR_34" VARCHAR2(4000 BYTE)
    ,"STR_35" VARCHAR2(4000 BYTE)
    ,"STR_36" VARCHAR2(4000 BYTE)
    ,"NUM_9" NUMBER
    ,"TS_9" TIMESTAMP(3)
    ,"DBL_9" BINARY_DOUBLE
    ,"STR_37" VARCHAR2(4000 BYTE)
    ,"STR_38" VARCHAR2(4000 BYTE)
    ,"STR_39" VARCHAR2(4000 BYTE)
    ,"STR_40" VARCHAR2(4000 BYTE)
    ,"NUM_10" NUMBER
    ,"TS_10" TIMESTAMP(3)
    ,"DBL_10" BINARY_DOUBLE
    ,"STR_41" VARCHAR2(4000 BYTE)
    ,"STR_42" VARCHAR2(4000 BYTE)
    ,"STR_43" VARCHAR2(4000 BYTE)
    ,"STR_44" VARCHAR2(4000 BYTE)
    ,"NUM_11" NUMBER
    ,"TS_11" TIMESTAMP(3)
    ,"DBL_11" BINARY_DOUBLE
    ,"STR_45" VARCHAR2(4000 BYTE)
    ,"STR_46" VARCHAR2(4000 BYTE)
    ,"STR_47" VARCHAR2(4000 BYTE)
    ,"STR_48" VARCHAR2(4000 BYTE)
    ,"NUM_12" NUMBER
    ,"TS_12" TIMESTAMP(3)
    ,"DBL_12" BINARY_DOUBLE
    ,"STR_49" VARCHAR2(4000 BYTE)
    ,"STR_50" VARCHAR2(4000 BYTE)
    ,"STR_51" VARCHAR2(4000 BYTE)
    ,"STR_52" VARCHAR2(4000 BYTE)
    ,"NUM_13" NUMBER
    ,"TS_13" TIMESTAMP(3)
    ,"DBL_13" BINARY_DOUBLE
    ,"STR_53" VARCHAR2(4000 BYTE)
    ,"STR_54" VARCHAR2(4000 BYTE)
    ,"STR_55" VARCHAR2(4000 BYTE)
    ,"STR_56" VARCHAR2(4000 BYTE)
    ,"NUM_14" NUMBER
    ,"TS_14" TIMESTAMP(3)
    ,"DBL_14" BINARY_DOUBLE
    ,"STR_57" VARCHAR2(4000 BYTE)
    ,"STR_58" VARCHAR2(4000 BYTE)
    ,"STR_59" VARCHAR2(4000 BYTE)
    ,"STR_60" VARCHAR2(4000 BYTE)
    ,"NUM_15" NUMBER
    ,"TS_15" TIMESTAMP(3)
    ,"DBL_15" BINARY_DOUBLE
    ,"STR_61" VARCHAR2(4000 BYTE)
    ,"STR_62" VARCHAR2(4000 BYTE)
    ,"STR_63" VARCHAR2(4000 BYTE)
    ,"STR_64" VARCHAR2(4000 BYTE)
    ,"NUM_16" NUMBER
    ,"TS_16" TIMESTAMP(3)
    ,"DBL_16" BINARY_DOUBLE
    ,"STR_65" VARCHAR2(4000 BYTE)
    ,"STR_66" VARCHAR2(4000 BYTE)
    ,"STR_67" VARCHAR2(4000 BYTE)
    ,"STR_68" VARCHAR2(4000 BYTE)
    ,"NUM_17" NUMBER
    ,"TS_17" TIMESTAMP(3)
    ,"DBL_17" BINARY_DOUBLE
    ,"STR_69" VARCHAR2(4000 BYTE)
    ,"STR_70" VARCHAR2(4000 BYTE)
    ,"STR_71" VARCHAR2(4000 BYTE)
    ,"STR_72" VARCHAR2(4000 BYTE)
    ,"NUM_18" NUMBER
    ,"TS_18" TIMESTAMP(3)
    ,"DBL_18" BINARY_DOUBLE
    ,"STR_73" VARCHAR2(4000 BYTE)
    ,"STR_74" VARCHAR2(4000 BYTE)
    ,"STR_75" VARCHAR2(4000 BYTE)
    ,"STR_76" VARCHAR2(4000 BYTE)
    ,"NUM_19" NUMBER
    ,"TS_19" TIMESTAMP(3)
    ,"DBL_19" BINARY_DOUBLE
    ,"STR_77" VARCHAR2(4000 BYTE)
    ,"STR_78" VARCHAR2(4000 BYTE)
    ,"STR_79" VARCHAR2(4000 BYTE)
    ,"STR_80" VARCHAR2(4000 BYTE)
    ,"NUM_20" NUMBER
    ,"TS_20" TIMESTAMP(3)
    ,"DBL_20" BINARY_DOUBLE
    ,"STR_81" VARCHAR2(4000 BYTE)
    ,"STR_82" VARCHAR2(4000 BYTE)
    ,"STR_83" VARCHAR2(4000 BYTE)
    ,"STR_84" VARCHAR2(4000 BYTE)
    ,"NUM_21" NUMBER
    ,"TS_21" TIMESTAMP(3)
    ,"DBL_21" BINARY_DOUBLE
    ,"STR_85" VARCHAR2(4000 BYTE)
    ,"STR_86" VARCHAR2(4000 BYTE)
    ,"STR_87" VARCHAR2(4000 BYTE)
    ,"STR_88" VARCHAR2(4000 BYTE)
    ,"NUM_22" NUMBER
    ,"TS_22" TIMESTAMP(3)
    ,"DBL_22" BINARY_DOUBLE
    ,"STR_89" VARCHAR2(4000 BYTE)
    ,"STR_90" VARCHAR2(4000 BYTE)
    ,"STR_91" VARCHAR2(4000 BYTE)
    ,"STR_92" VARCHAR2(4000 BYTE)
    ,"NUM_23" NUMBER
    ,"TS_23" TIMESTAMP(3)
    ,"DBL_23" BINARY_DOUBLE
    ,"STR_93" VARCHAR2(4000 BYTE)
    ,"STR_94" VARCHAR2(4000 BYTE)
    ,"STR_95" VARCHAR2(4000 BYTE)
    ,"STR_96" VARCHAR2(4000 BYTE)
    ,"NUM_24" NUMBER
    ,"TS_24" TIMESTAMP(3)
    ,"DBL_24" BINARY_DOUBLE
    ,"STR_97" VARCHAR2(4000 BYTE)
    ,"STR_98" VARCHAR2(4000 BYTE)
    ,"STR_99" VARCHAR2(4000 BYTE)
    ,"STR_100" VARCHAR2(4000 BYTE)
    ,"NUM_25" NUMBER
    ,"TS_25" TIMESTAMP(3)
    ,"DBL_25" BINARY_DOUBLE
    ,"STR_101" VARCHAR2(4000 BYTE)
    ,"STR_102" VARCHAR2(4000 BYTE)
    ,"STR_103" VARCHAR2(4000 BYTE)
    ,"STR_104" VARCHAR2(4000 BYTE)
    ,"NUM_26" NUMBER
    ,"TS_26" TIMESTAMP(3)
    ,"DBL_26" BINARY_DOUBLE
    ,"STR_105" VARCHAR2(4000 BYTE)
    ,"STR_106" VARCHAR2(4000 BYTE)
    ,"STR_107" VARCHAR2(4000 BYTE)
    ,"STR_108" VARCHAR2(4000 BYTE)
    ,"NUM_27" NUMBER
    ,"TS_27" TIMESTAMP(3)
    ,"DBL_27" BINARY_DOUBLE
    ,"STR_109" VARCHAR2(4000 BYTE)
    ,"STR_110" VARCHAR2(4000 BYTE)
    ,"STR_111" VARCHAR2(4000 BYTE)
    ,"STR_112" VARCHAR2(4000 BYTE)
    ,"NUM_28" NUMBER
    ,"TS_28" TIMESTAMP(3)
    ,"DBL_28" BINARY_DOUBLE
    ,"STR_113" VARCHAR2(4000 BYTE)
    ,"STR_114" VARCHAR2(4000 BYTE)
    ,"STR_115" VARCHAR2(4000 BYTE)
    ,"STR_116" VARCHAR2(4000 BYTE)
    ,"NUM_29" NUMBER
    ,"TS_29" TIMESTAMP(3)
    ,"DBL_29" BINARY_DOUBLE
    ,"STR_117" VARCHAR2(4000 BYTE)
    ,"STR_118" VARCHAR2(4000 BYTE)
    ,"STR_119" VARCHAR2(4000 BYTE)
    ,"STR_120" VARCHAR2(4000 BYTE)
    ,"NUM_30" NUMBER
    ,"TS_30" TIMESTAMP(3)
    ,"DBL_30" BINARY_DOUBLE
    ,"STR_121" VARCHAR2(4000 BYTE)
    ,"STR_122" VARCHAR2(4000 BYTE)
    ,"STR_123" VARCHAR2(4000 BYTE)
    ,"STR_124" VARCHAR2(4000 BYTE)
    ,"NUM_31" NUMBER
    ,"TS_31" TIMESTAMP(3)
    ,"DBL_31" BINARY_DOUBLE
    ,"STR_125" VARCHAR2(4000 BYTE)
    ,"STR_126" VARCHAR2(4000 BYTE)
    ,"STR_127" VARCHAR2(4000 BYTE)
    ,"STR_128" VARCHAR2(4000 BYTE)
    ,"NUM_32" NUMBER
    ,"TS_32" TIMESTAMP(3)
    ,"DBL_32" BINARY_DOUBLE
    )
;

CREATE INDEX "OBJ_STORE_RB__MTP_INDEX1" ON "OBJ_STORE_RB__MTP" ("TENANT_ID", "OBJ_DEF_ID", "RB_ID") ;

/* drop/create OBJ_STORE_RB */
DROP TABLE "OBJ_STORE_RB__USER" CASCADE CONSTRAINT;

CREATE TABLE "OBJ_STORE_RB__USER" 
(
    "RB_ID" NUMBER(16,0) NOT NULL,
    "RB_DATE" TIMESTAMP(3),
    "RB_USER" VARCHAR2(64),
    "TENANT_ID" NUMBER(7,0) NOT NULL, 
    "OBJ_DEF_ID" VARCHAR2(128) NOT NULL, 
    "PG_NO" NUMBER(2,0) NOT NULL, 
    "OBJ_ID" VARCHAR2(64) NOT NULL, 
    "OBJ_VER" NUMBER(10,0) DEFAULT 0 NOT NULL,
    "OBJ_DEF_VER" NUMBER(10,0),
    "STATUS" CHAR(1),
    "OBJ_NAME" VARCHAR2(256), 
    "OBJ_DESC" VARCHAR2(1024), 
    "CRE_DATE" TIMESTAMP (3), 
    "UP_DATE" TIMESTAMP (3), 
    "S_DATE" TIMESTAMP(3),
    "E_DATE" TIMESTAMP(3),
    "LOCK_USER" VARCHAR2(64),
    "CRE_USER" VARCHAR2(64), 
    "UP_USER" VARCHAR2(64)
    ,"USTR_1" VARCHAR2(4000 BYTE)
    ,"USTR_1_TD" VARCHAR2(139)
    ,"UNUM_1" NUMBER
    ,"UNUM_1_TD" VARCHAR2(139)
    ,"UTS_1" TIMESTAMP(3)
    ,"UTS_1_TD" VARCHAR2(139)
    ,"UDBL_1" BINARY_DOUBLE
    ,"UDBL_1_TD" VARCHAR2(139)
    ,"USTR_2" VARCHAR2(4000 BYTE)
    ,"USTR_2_TD" VARCHAR2(139)
    ,"UNUM_2" NUMBER
    ,"UNUM_2_TD" VARCHAR2(139)
    ,"UTS_2" TIMESTAMP(3)
    ,"UTS_2_TD" VARCHAR2(139)
    ,"UDBL_2" BINARY_DOUBLE
    ,"UDBL_2_TD" VARCHAR2(139)
    ,"ISTR_1" VARCHAR2(4000 BYTE)
    ,"ISTR_1_TD" VARCHAR2(139)
    ,"ISTR_2" VARCHAR2(4000 BYTE)
    ,"ISTR_2_TD" VARCHAR2(139)
    ,"INUM_1" NUMBER
    ,"INUM_1_TD" VARCHAR2(139)
    ,"ITS_1" TIMESTAMP(3)
    ,"ITS_1_TD" VARCHAR2(139)
    ,"IDBL_1" BINARY_DOUBLE
    ,"IDBL_1_TD" VARCHAR2(139)
    ,"ISTR_3" VARCHAR2(4000 BYTE)
    ,"ISTR_3_TD" VARCHAR2(139)
    ,"ISTR_4" VARCHAR2(4000 BYTE)
    ,"ISTR_4_TD" VARCHAR2(139)
    ,"INUM_2" NUMBER
    ,"INUM_2_TD" VARCHAR2(139)
    ,"ITS_2" TIMESTAMP(3)
    ,"ITS_2_TD" VARCHAR2(139)
    ,"IDBL_2" BINARY_DOUBLE
    ,"IDBL_2_TD" VARCHAR2(139)
    ,"ISTR_5" VARCHAR2(4000 BYTE)
    ,"ISTR_5_TD" VARCHAR2(139)
    ,"ISTR_6" VARCHAR2(4000 BYTE)
    ,"ISTR_6_TD" VARCHAR2(139)
    ,"INUM_3" NUMBER
    ,"INUM_3_TD" VARCHAR2(139)
    ,"ITS_3" TIMESTAMP(3)
    ,"ITS_3_TD" VARCHAR2(139)
    ,"IDBL_3" BINARY_DOUBLE
    ,"IDBL_3_TD" VARCHAR2(139)
    ,"ISTR_7" VARCHAR2(4000 BYTE)
    ,"ISTR_7_TD" VARCHAR2(139)
    ,"ISTR_8" VARCHAR2(4000 BYTE)
    ,"ISTR_8_TD" VARCHAR2(139)
    ,"INUM_4" NUMBER
    ,"INUM_4_TD" VARCHAR2(139)
    ,"ITS_4" TIMESTAMP(3)
    ,"ITS_4_TD" VARCHAR2(139)
    ,"IDBL_4" BINARY_DOUBLE
    ,"IDBL_4_TD" VARCHAR2(139)
    ,"STR_1" VARCHAR2(4000 BYTE)
    ,"STR_2" VARCHAR2(4000 BYTE)
    ,"STR_3" VARCHAR2(4000 BYTE)
    ,"STR_4" VARCHAR2(4000 BYTE)
    ,"NUM_1" NUMBER
    ,"TS_1" TIMESTAMP(3)
    ,"DBL_1" BINARY_DOUBLE
    ,"STR_5" VARCHAR2(4000 BYTE)
    ,"STR_6" VARCHAR2(4000 BYTE)
    ,"STR_7" VARCHAR2(4000 BYTE)
    ,"STR_8" VARCHAR2(4000 BYTE)
    ,"NUM_2" NUMBER
    ,"TS_2" TIMESTAMP(3)
    ,"DBL_2" BINARY_DOUBLE
    ,"STR_9" VARCHAR2(4000 BYTE)
    ,"STR_10" VARCHAR2(4000 BYTE)
    ,"STR_11" VARCHAR2(4000 BYTE)
    ,"STR_12" VARCHAR2(4000 BYTE)
    ,"NUM_3" NUMBER
    ,"TS_3" TIMESTAMP(3)
    ,"DBL_3" BINARY_DOUBLE
    ,"STR_13" VARCHAR2(4000 BYTE)
    ,"STR_14" VARCHAR2(4000 BYTE)
    ,"STR_15" VARCHAR2(4000 BYTE)
    ,"STR_16" VARCHAR2(4000 BYTE)
    ,"NUM_4" NUMBER
    ,"TS_4" TIMESTAMP(3)
    ,"DBL_4" BINARY_DOUBLE
    ,"STR_17" VARCHAR2(4000 BYTE)
    ,"STR_18" VARCHAR2(4000 BYTE)
    ,"STR_19" VARCHAR2(4000 BYTE)
    ,"STR_20" VARCHAR2(4000 BYTE)
    ,"NUM_5" NUMBER
    ,"TS_5" TIMESTAMP(3)
    ,"DBL_5" BINARY_DOUBLE
    ,"STR_21" VARCHAR2(4000 BYTE)
    ,"STR_22" VARCHAR2(4000 BYTE)
    ,"STR_23" VARCHAR2(4000 BYTE)
    ,"STR_24" VARCHAR2(4000 BYTE)
    ,"NUM_6" NUMBER
    ,"TS_6" TIMESTAMP(3)
    ,"DBL_6" BINARY_DOUBLE
    ,"STR_25" VARCHAR2(4000 BYTE)
    ,"STR_26" VARCHAR2(4000 BYTE)
    ,"STR_27" VARCHAR2(4000 BYTE)
    ,"STR_28" VARCHAR2(4000 BYTE)
    ,"NUM_7" NUMBER
    ,"TS_7" TIMESTAMP(3)
    ,"DBL_7" BINARY_DOUBLE
    ,"STR_29" VARCHAR2(4000 BYTE)
    ,"STR_30" VARCHAR2(4000 BYTE)
    ,"STR_31" VARCHAR2(4000 BYTE)
    ,"STR_32" VARCHAR2(4000 BYTE)
    ,"NUM_8" NUMBER
    ,"TS_8" TIMESTAMP(3)
    ,"DBL_8" BINARY_DOUBLE
    ,"STR_33" VARCHAR2(4000 BYTE)
    ,"STR_34" VARCHAR2(4000 BYTE)
    ,"STR_35" VARCHAR2(4000 BYTE)
    ,"STR_36" VARCHAR2(4000 BYTE)
    ,"NUM_9" NUMBER
    ,"TS_9" TIMESTAMP(3)
    ,"DBL_9" BINARY_DOUBLE
    ,"STR_37" VARCHAR2(4000 BYTE)
    ,"STR_38" VARCHAR2(4000 BYTE)
    ,"STR_39" VARCHAR2(4000 BYTE)
    ,"STR_40" VARCHAR2(4000 BYTE)
    ,"NUM_10" NUMBER
    ,"TS_10" TIMESTAMP(3)
    ,"DBL_10" BINARY_DOUBLE
    ,"STR_41" VARCHAR2(4000 BYTE)
    ,"STR_42" VARCHAR2(4000 BYTE)
    ,"STR_43" VARCHAR2(4000 BYTE)
    ,"STR_44" VARCHAR2(4000 BYTE)
    ,"NUM_11" NUMBER
    ,"TS_11" TIMESTAMP(3)
    ,"DBL_11" BINARY_DOUBLE
    ,"STR_45" VARCHAR2(4000 BYTE)
    ,"STR_46" VARCHAR2(4000 BYTE)
    ,"STR_47" VARCHAR2(4000 BYTE)
    ,"STR_48" VARCHAR2(4000 BYTE)
    ,"NUM_12" NUMBER
    ,"TS_12" TIMESTAMP(3)
    ,"DBL_12" BINARY_DOUBLE
    ,"STR_49" VARCHAR2(4000 BYTE)
    ,"STR_50" VARCHAR2(4000 BYTE)
    ,"STR_51" VARCHAR2(4000 BYTE)
    ,"STR_52" VARCHAR2(4000 BYTE)
    ,"NUM_13" NUMBER
    ,"TS_13" TIMESTAMP(3)
    ,"DBL_13" BINARY_DOUBLE
    ,"STR_53" VARCHAR2(4000 BYTE)
    ,"STR_54" VARCHAR2(4000 BYTE)
    ,"STR_55" VARCHAR2(4000 BYTE)
    ,"STR_56" VARCHAR2(4000 BYTE)
    ,"NUM_14" NUMBER
    ,"TS_14" TIMESTAMP(3)
    ,"DBL_14" BINARY_DOUBLE
    ,"STR_57" VARCHAR2(4000 BYTE)
    ,"STR_58" VARCHAR2(4000 BYTE)
    ,"STR_59" VARCHAR2(4000 BYTE)
    ,"STR_60" VARCHAR2(4000 BYTE)
    ,"NUM_15" NUMBER
    ,"TS_15" TIMESTAMP(3)
    ,"DBL_15" BINARY_DOUBLE
    ,"STR_61" VARCHAR2(4000 BYTE)
    ,"STR_62" VARCHAR2(4000 BYTE)
    ,"STR_63" VARCHAR2(4000 BYTE)
    ,"STR_64" VARCHAR2(4000 BYTE)
    ,"NUM_16" NUMBER
    ,"TS_16" TIMESTAMP(3)
    ,"DBL_16" BINARY_DOUBLE
    ,"STR_65" VARCHAR2(4000 BYTE)
    ,"STR_66" VARCHAR2(4000 BYTE)
    ,"STR_67" VARCHAR2(4000 BYTE)
    ,"STR_68" VARCHAR2(4000 BYTE)
    ,"NUM_17" NUMBER
    ,"TS_17" TIMESTAMP(3)
    ,"DBL_17" BINARY_DOUBLE
    ,"STR_69" VARCHAR2(4000 BYTE)
    ,"STR_70" VARCHAR2(4000 BYTE)
    ,"STR_71" VARCHAR2(4000 BYTE)
    ,"STR_72" VARCHAR2(4000 BYTE)
    ,"NUM_18" NUMBER
    ,"TS_18" TIMESTAMP(3)
    ,"DBL_18" BINARY_DOUBLE
    ,"STR_73" VARCHAR2(4000 BYTE)
    ,"STR_74" VARCHAR2(4000 BYTE)
    ,"STR_75" VARCHAR2(4000 BYTE)
    ,"STR_76" VARCHAR2(4000 BYTE)
    ,"NUM_19" NUMBER
    ,"TS_19" TIMESTAMP(3)
    ,"DBL_19" BINARY_DOUBLE
    ,"STR_77" VARCHAR2(4000 BYTE)
    ,"STR_78" VARCHAR2(4000 BYTE)
    ,"STR_79" VARCHAR2(4000 BYTE)
    ,"STR_80" VARCHAR2(4000 BYTE)
    ,"NUM_20" NUMBER
    ,"TS_20" TIMESTAMP(3)
    ,"DBL_20" BINARY_DOUBLE
    ,"STR_81" VARCHAR2(4000 BYTE)
    ,"STR_82" VARCHAR2(4000 BYTE)
    ,"STR_83" VARCHAR2(4000 BYTE)
    ,"STR_84" VARCHAR2(4000 BYTE)
    ,"NUM_21" NUMBER
    ,"TS_21" TIMESTAMP(3)
    ,"DBL_21" BINARY_DOUBLE
    ,"STR_85" VARCHAR2(4000 BYTE)
    ,"STR_86" VARCHAR2(4000 BYTE)
    ,"STR_87" VARCHAR2(4000 BYTE)
    ,"STR_88" VARCHAR2(4000 BYTE)
    ,"NUM_22" NUMBER
    ,"TS_22" TIMESTAMP(3)
    ,"DBL_22" BINARY_DOUBLE
    ,"STR_89" VARCHAR2(4000 BYTE)
    ,"STR_90" VARCHAR2(4000 BYTE)
    ,"STR_91" VARCHAR2(4000 BYTE)
    ,"STR_92" VARCHAR2(4000 BYTE)
    ,"NUM_23" NUMBER
    ,"TS_23" TIMESTAMP(3)
    ,"DBL_23" BINARY_DOUBLE
    ,"STR_93" VARCHAR2(4000 BYTE)
    ,"STR_94" VARCHAR2(4000 BYTE)
    ,"STR_95" VARCHAR2(4000 BYTE)
    ,"STR_96" VARCHAR2(4000 BYTE)
    ,"NUM_24" NUMBER
    ,"TS_24" TIMESTAMP(3)
    ,"DBL_24" BINARY_DOUBLE
    ,"STR_97" VARCHAR2(4000 BYTE)
    ,"STR_98" VARCHAR2(4000 BYTE)
    ,"STR_99" VARCHAR2(4000 BYTE)
    ,"STR_100" VARCHAR2(4000 BYTE)
    ,"NUM_25" NUMBER
    ,"TS_25" TIMESTAMP(3)
    ,"DBL_25" BINARY_DOUBLE
    ,"STR_101" VARCHAR2(4000 BYTE)
    ,"STR_102" VARCHAR2(4000 BYTE)
    ,"STR_103" VARCHAR2(4000 BYTE)
    ,"STR_104" VARCHAR2(4000 BYTE)
    ,"NUM_26" NUMBER
    ,"TS_26" TIMESTAMP(3)
    ,"DBL_26" BINARY_DOUBLE
    ,"STR_105" VARCHAR2(4000 BYTE)
    ,"STR_106" VARCHAR2(4000 BYTE)
    ,"STR_107" VARCHAR2(4000 BYTE)
    ,"STR_108" VARCHAR2(4000 BYTE)
    ,"NUM_27" NUMBER
    ,"TS_27" TIMESTAMP(3)
    ,"DBL_27" BINARY_DOUBLE
    ,"STR_109" VARCHAR2(4000 BYTE)
    ,"STR_110" VARCHAR2(4000 BYTE)
    ,"STR_111" VARCHAR2(4000 BYTE)
    ,"STR_112" VARCHAR2(4000 BYTE)
    ,"NUM_28" NUMBER
    ,"TS_28" TIMESTAMP(3)
    ,"DBL_28" BINARY_DOUBLE
    ,"STR_113" VARCHAR2(4000 BYTE)
    ,"STR_114" VARCHAR2(4000 BYTE)
    ,"STR_115" VARCHAR2(4000 BYTE)
    ,"STR_116" VARCHAR2(4000 BYTE)
    ,"NUM_29" NUMBER
    ,"TS_29" TIMESTAMP(3)
    ,"DBL_29" BINARY_DOUBLE
    ,"STR_117" VARCHAR2(4000 BYTE)
    ,"STR_118" VARCHAR2(4000 BYTE)
    ,"STR_119" VARCHAR2(4000 BYTE)
    ,"STR_120" VARCHAR2(4000 BYTE)
    ,"NUM_30" NUMBER
    ,"TS_30" TIMESTAMP(3)
    ,"DBL_30" BINARY_DOUBLE
    ,"STR_121" VARCHAR2(4000 BYTE)
    ,"STR_122" VARCHAR2(4000 BYTE)
    ,"STR_123" VARCHAR2(4000 BYTE)
    ,"STR_124" VARCHAR2(4000 BYTE)
    ,"NUM_31" NUMBER
    ,"TS_31" TIMESTAMP(3)
    ,"DBL_31" BINARY_DOUBLE
    ,"STR_125" VARCHAR2(4000 BYTE)
    ,"STR_126" VARCHAR2(4000 BYTE)
    ,"STR_127" VARCHAR2(4000 BYTE)
    ,"STR_128" VARCHAR2(4000 BYTE)
    ,"NUM_32" NUMBER
    ,"TS_32" TIMESTAMP(3)
    ,"DBL_32" BINARY_DOUBLE
    )
;

CREATE INDEX "OBJ_STORE_RB__USER_INDEX1" ON "OBJ_STORE_RB__USER" ("TENANT_ID", "OBJ_DEF_ID", "RB_ID");

DROP SEQUENCE SEQ_RB_ID;
CREATE SEQUENCE SEQ_RB_ID MINVALUE 1 MAXVALUE 9999999999999999 INCREMENT BY 1 START WITH 1;


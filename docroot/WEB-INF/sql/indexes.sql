create index IX_DBC67110 on Inventory_Manufacturer (groupId);
create index IX_B74A9FF6 on Inventory_Manufacturer (groupId, status);
create index IX_78E5079A on Inventory_Manufacturer (uuid_);
create unique index IX_51865A50 on Inventory_Manufacturer (uuid_, groupId);

create index IX_F67A54AE on Inventory_Part (groupId);
create index IX_88978EBC on Inventory_Part (manufacturerId);
create index IX_F67CB96E on Inventory_Part (manufacturerId, groupId);
create index IX_7FD93AB8 on Inventory_Part (uuid_);
create unique index IX_1F36C8F2 on Inventory_Part (uuid_, groupId);
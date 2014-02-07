create table Inventory_Manufacturer (
	uuid_ VARCHAR(75) null,
	manufacturerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	website VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	userName VARCHAR(75) null
);

create table Inventory_Part (
	uuid_ VARCHAR(75) null,
	partId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	manufacturerId LONG,
	name STRING null,
	partNumber VARCHAR(75) null,
	orderDate DATE null,
	quantity INTEGER
);

create table Inventory_PurchaseOrder (
	orderId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	partId LONG,
	userId LONG,
	orderDate DATE null,
	closed BOOLEAN
);
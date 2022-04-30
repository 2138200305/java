//Role mode is ued to track what permission a user has
class Role {
    roleId: any;
    role: any;
    constructor(roleId, role) {
        this.roleId = roleId; //number
        this.role = role;//String
    }

    confirmRole() {
        console.log(`The role info: ${this.roleId}  ${this.role}`);
    }
}

const employee = new Role(1, 'Employee');
const admin = new Role(2, 'Finance Administrator');
employee.confirmRole();
admin.confirmRole();

//User model keeps track of uers information
class User {
    userId: any;
    username: any;
    password: any;
    firstName: any;
    lastName: any;
    email: any;
    role: any;
    constructor(userId, username, password, firstName, lastName, email, role) {
        this.userId = userId; //number primary key
        this.username = username;//String not null, unique
        this.password = password;//String not null
        this.firstName = firstName;//String not null
        this.lastName = lastName;//String not null
        this.email = email;//String not null
        this.role = role;//Role not null
    }

    confirmUserInfo() {
        console.log(`This user's info: ${this.userId} ${this.username} ${this.password} ${this.firstName} ${this.lastName} ${this.email} ${this.role}`);
    }
}

const testUser = new User(1, 'password1', 'password1', 'Jill', 'Scott', 'jscott@yahoo.com', employee.role);
testUser.confirmUserInfo();

class ReimbursementStatus {
    statusId: any;
    status: any;
    constructor(statusId, status) {
        this.statusId = statusId; // number  primary key
        this.status = status; //string  not null unique
    }
    viewStatus() {
        console.log(`Reimbursement ${this.statusId} ${this.status}`);
    }
}
const paymentPending = new ReimbursementStatus(1, 'Pending');
const paymentApproved = new ReimbursementStatus(2, 'Approved');
const paymentDenied = new ReimbursementStatus(3, 'Denied');

paymentApproved.viewStatus();

class ReimbursementType {
    typeId: any;
    type: any;
    constructor(typeId, type) {
        this.typeId = typeId; // number primary key
        this.type = type;//  string not null, unique
    }
    viewType() {
        console.log(`ReimbursementType ${this.typeId} ${this.type}`);
    }
}
const typeLodging = new ReimbursementType(1, 'Lodging');
const typeTravel = new ReimbursementType(2, 'Travel');
const typeFood = new ReimbursementType(3, 'Food');
const typeOther = new ReimbursementType(4, 'Other');
typeLodging.viewType();

class Reimbursement {
    reimbursementId: any;
    author: any;
    amount: any;
    dateSubmitted: any;
    dateResolved: any;
    description: any;
    resolver: any;
    status: any;
    type: any;
    constructor(reimbursementId, author, amount, dateSubmitted, dateResolved, description, resolver, status, type) {
        this.reimbursementId = reimbursementId; // number primary key
        this.author = author; // number foreign key -> User, not null
        this.amount = amount; // number not null
        this.dateSubmitted = dateSubmitted;  //number  not null
        this.dateResolved = dateResolved; //number
        this.description = description; // String not null
        this.resolver = resolver; // number foreign key -> User
        this.status = status; // number foreign key -> ReimbursementStatus, not null
        this.type = type; // number foreign key -> ReimbursementType
    }
    viewReimbursement() {
        console.log(`Reimbursement ${this.reimbursementId} ${this.author} ${this.amount} ${this.dateSubmitted} ${this.dateResolved} ${this.description} ${this.resolver} ${this.status} ${this.type}`);
    }
}
const testReimbursement = new Reimbursement(1, 1,1,741919, 12311919, 'Tampa Housing', 1, 1, 1);

testReimbursement.viewReimbursement();
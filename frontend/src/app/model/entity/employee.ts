import { Department } from './department';
import { UserCredential } from "./user-credential";

export class Employee {
	
	constructor(
		public employeeId: number,
		public firstName: string,
		public lastName: string,
		public email: string,
		public phone: string,
		public hiredate: Date,
		public job: string,
		public salary: number,
		public manager: Employee,
		public department: Department,
		public userCredential: UserCredential) {
		
	}
	
	
	
}





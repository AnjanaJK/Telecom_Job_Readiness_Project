import { Manager } from "./manager";
import { User } from "./user";

export class Engineer {
    engineerId!: Number;
    engineerName!: String; // Full Name
    selectedManager!: String;
    manager!: Manager;
    user!: User; // Include the User property
}

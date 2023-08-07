import { Cust } from "./cust";
import { Manager } from "./manager";
import { User } from "./user";

export class LoginResponse {
    user!: User;
    customer!: Cust;
    manager?: Manager; // Make manager field optional since it may not always be present in the response.
}

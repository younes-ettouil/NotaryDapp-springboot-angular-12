export class User {
    id?:number;
    name?:string;
    username?:String;
    password?:string;
    role?:[{
        id?: number,
        name?: string
      }];
}

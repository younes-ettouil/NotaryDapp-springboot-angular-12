import { Custumer } from './custumer.model';
export class Entreprise {
    
        wallet?:string;
        custumerType?: string;
        address?:{
          address?: string,
          city?: string,
          country?: string
        };
        phone?: string;
        tradeRegistry?: string;
        headOffice?: string;
        capital?: number;
        representative?:Custumer; 
}

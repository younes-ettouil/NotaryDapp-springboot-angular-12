import { Entreprise } from './entreprise.model';
import { Custumer } from './custumer.model';
export class Contract {
    type?: string;
    price?: number;
    paymentMethod?: string;
    sellers?: {}[];
    buyers?: {}[];
    property?: {
      type?: string,
      conservationNumber?: string,
      taxesFree?: Boolean,
      surface ?: number,
      address?: {
        address?: string,
        city?: string,
        country?: string
      }
    }
}

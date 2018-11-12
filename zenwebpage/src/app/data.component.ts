export interface CustInfo {
  custId: number;
  custName: string;
  custDob: Date;
  custSex: string;
  custProj: string;
}

export class CenterDetail {
  id: number;
  centerId: string;
  centerPassword: string;
  centerName: string;
  centerDescription: string;
  centerLogo: Blob;
  centerOpendDate: Date;
  centerOwnerFirstName: string;
  centerOwnerMidName: string;
  centerOwnerLastName: string;
  centerAddress1: string;
  centerAddress2: string;
  centerCity: string;
  centerState: string;
  centerZipCode: string;
  centerCountry: string;
  centerOwnerEmail: string;
  centerOwnerLandPhone: string;
  centerOwnerMobilePhone: string;
  centerCustomerRating: number;
  centerLevel: number;
  centerCloseStartDate: Date;
  centerCloseEndDate: Date;
  centerOpenStatus: boolean;
  centerModifiedDate: Date;
  centerModifiedBy: string;
}

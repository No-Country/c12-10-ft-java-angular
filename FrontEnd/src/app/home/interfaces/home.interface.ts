

export interface Ownership {
  id:string;
  ownershipId: string,
  createAt: null,
  modifiedAt: null,
  country: string,
  state: string,
  city: string,
  address: string,
  house_type: string,
  images: string,
  rooms: number,
  bathrooms: number,
  house_area: number,
  description: string,
  price: number,
  deposit: number,
  payment_conditions: string,
  additional_services: string[],
  additional_fees: [],
  policies_cancellation: string,
  latitude: number,
  longitude: number,
  pets_allowed: boolean,
  smoking_policy: string,
  available_date: number,
  userId:UserOwnership
}

export interface UserOwnership {
  id: string,
  userId: string,
  username: string,
  password: string,
  name: string,
  email: string,
  phone: string,
  role: string,
  registerDate: Date,
  birthDate:Date,
  description:string,
}


export interface ResOwnership {
  success:boolean,
  message: string,
  data: Ownership[]
}

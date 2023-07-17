
export interface Homes {
  success: boolean;
  message: string;
  data:    Ownership[];
}

export interface Ownership {
  id:                    string;
  createAt:              string | null;
  modifiedAt:            string | null;
  country:               Country;
  state:                 State;
  city:                  City;
  address:               Address;
  house_type:            HouseType;
  rooms:                 number;
  bathrooms:             number;
  house_area:            number;
  description:           Description;
  price:                 number;
  deposit:               number;
  payment_conditions:    string;
  additional_services:   AdditionalService[];
  additional_fees:       AdditionalFee[];
  images:                null;
  policies_cancellation: string;
  latitude:              number;
  longitude:             number;
  pets_allowed:          boolean;
  smoking_policy:        SmokingPolicy;
  available_date:        string | null;
}

export enum AdditionalFee {
  Parking = "Parking",
}

export enum AdditionalService {
  Gym = "Gym",
  SwimmingPool = "Swimming Pool",
}

export enum Address {
  The123MainSt = "123 Main St",
}


export enum Description {
  CozyApartmentInDowntownLA = "Cozy apartment in downtown LA",
}

export enum HouseType {
  Apartment = "Apartment",
}

export enum SmokingPolicy {
  NoSmoking = "No smoking",
  SiSmoking = "Si Smoking",
}

export enum State {
  Antioquia = "antioquia",
  California = "California",
  Guatemala = "guatemala",
}

export enum Country {
  Colombia = "colombia",
}

export enum City {
  LosAngeles = "Los Angeles",
  Medellin = "medellin",
}

export interface newHome {
  ownership_id:          string;
  country:               string;
  state:                 string;
  city:                  string;
  address:               string;
  house_type:            string;
  rooms:                 number;
  bathrooms:             number;
  house_area:            number;
  description:           string;
  price:                 number;
  deposit:               number;
  payment_conditions:    string;
  additional_services:   string[];
  additional_fees:       string[];
  policies_cancellation: string;
  latitude:              number;
  longitude:             number;
  pets_allowed:          boolean;
  smoking_policy:        string;
  available_date:        Date;
}

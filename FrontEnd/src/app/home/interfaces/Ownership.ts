import { Service } from "./Service";

export enum TypeOfHouse {
    APARTMENT, 
    HOUSE,
    CABIN
}

export interface Ownership {
    id: string,
    createAt: null,
    modifiedAt: null,
    country: string,
    state: string,
    city: string,
    address: string,
    house_type: TypeOfHouse,
    images: string[],
    rooms: number,
    bathrooms: number,
    house_area: number,
    description: string,
    price: number,
    deposit: number,
    payment_conditions: string,
    additional_services: Service[],
    additional_fees: [],
    policies_cancellation: string,
    latitude: number,
    longitude: number,
    pets_allowed: boolean,
    smoking_policy: string,
    available_date: number
}